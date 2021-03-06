/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.facet

import com.intellij.facet.impl.ui.libraries.DelegatingLibrariesValidatorContext
import com.intellij.facet.ui.*
import com.intellij.facet.ui.libraries.FrameworkLibraryValidator
import com.intellij.openapi.project.Project
import com.intellij.ui.DocumentAdapter
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.ThreeStateCheckBox
import org.jetbrains.kotlin.cli.common.arguments.*
import org.jetbrains.kotlin.config.*
import org.jetbrains.kotlin.idea.compiler.configuration.Kotlin2JsCompilerArgumentsHolder
import org.jetbrains.kotlin.idea.compiler.configuration.Kotlin2JvmCompilerArgumentsHolder
import org.jetbrains.kotlin.idea.compiler.configuration.KotlinCompilerConfigurableTab
import java.awt.BorderLayout
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.event.DocumentEvent

class KotlinFacetEditorGeneralTab(
        private val configuration: KotlinFacetConfiguration,
        private val editorContext: FacetEditorContext,
        validatorsManager: FacetValidatorsManager
) : FacetEditorTab() {
    class EditorComponent(
            project: Project,
            configuration: KotlinFacetConfiguration?
    ) : JPanel(BorderLayout()) {
        private val isMultiEditor = configuration == null

        val compilerConfigurable = with(configuration?.settings) {
            if (isMultiEditor) {
                KotlinCompilerConfigurableTab(
                        project,
                        object : CommonCompilerArguments() {},
                        K2JSCompilerArguments(),
                        K2JVMCompilerArguments(),
                        CompilerSettings(),
                        null,
                        false,
                        true
                )
            }
            else {
                val compilerArguments = configuration!!.settings.compilerArguments!!
                val k2jvmCompilerArguments = compilerArguments as? K2JVMCompilerArguments
                                    ?: copyBean(Kotlin2JvmCompilerArgumentsHolder.getInstance(project).settings)
                val k2jsCompilerArguments = compilerArguments as? K2JSCompilerArguments
                                    ?: copyBean(Kotlin2JsCompilerArgumentsHolder.getInstance(project).settings)
                KotlinCompilerConfigurableTab(
                        project,
                        compilerArguments,
                        k2jsCompilerArguments,
                        k2jvmCompilerArguments,
                        configuration.settings.compilerSettings!!,
                        null,
                        false,
                        false
                )
            }
        }

        val useProjectSettingsCheckBox = ThreeStateCheckBox("Use project settings").apply { isThirdStateEnabled = isMultiEditor }

        val targetPlatformComboBox =
                JComboBox<TargetPlatformKind<*>>(TargetPlatformKind.ALL_PLATFORMS.toTypedArray()).apply {
                    setRenderer(DescriptionListCellRenderer())
                }

        init {
            val contentPanel = FormBuilder
                    .createFormBuilder()
                    .addComponent(useProjectSettingsCheckBox)
                    .addLabeledComponent("&Target platform: ", targetPlatformComboBox)
                    .addComponent(compilerConfigurable.createComponent()!!)
                    .panel
            add(contentPanel, BorderLayout.NORTH)

            useProjectSettingsCheckBox.addActionListener {
                updateCompilerConfigurable()
            }

            targetPlatformComboBox.addActionListener {
                updateCompilerConfigurable()
            }
        }

        internal fun updateCompilerConfigurable() {
            compilerConfigurable.setTargetPlatform(chosenPlatform)
            compilerConfigurable.setEnabled(!useProjectSettingsCheckBox.isSelected)
        }

        val chosenPlatform: TargetPlatformKind<*>?
            get() = targetPlatformComboBox.selectedItem as TargetPlatformKind<*>?
    }

    inner class VersionValidator : FacetEditorValidator() {
        override fun check(): ValidationResult {
            val apiLevel = editor.compilerConfigurable.apiVersionComboBox.selectedItem as? LanguageVersion?
                           ?: return ValidationResult.OK
            val languageLevel = editor.compilerConfigurable.languageVersionComboBox.selectedItem as? LanguageVersion?
                                ?: return ValidationResult.OK
            val targetPlatform = editor.targetPlatformComboBox.selectedItem as TargetPlatformKind<*>?
            val libraryLevel = getLibraryLanguageLevel(editorContext.module, editorContext.rootModel, targetPlatform)
            if (languageLevel < apiLevel || libraryLevel < apiLevel) {
                return ValidationResult("Language version/Runtime version may not be less than API version", null)
            }
            return ValidationResult.OK
        }
    }

    inner class CoroutineContradictionValidator : FacetEditorValidator() {
        override fun check(): ValidationResult {
            val selectedOption = editor.compilerConfigurable.coroutineSupportComboBox.selectedItem as? CoroutineSupport
                                 ?: return ValidationResult.OK
            val parsedArguments = configuration.settings.compilerArguments?.javaClass?.newInstance()
                                  ?: return ValidationResult.OK
            parseArguments(
                    editor.compilerConfigurable.additionalArgsOptionsField.text.split(Regex("\\s")).toTypedArray(),
                    parsedArguments,
                    true
            )
            val parsedOption = CoroutineSupport.byCompilerArgumentsOrNull(parsedArguments) ?: return ValidationResult.OK
            if (parsedOption != selectedOption) {
                return ValidationResult("Coroutine support setting specified as an additional argument differs from the one in \"Coroutines\" field", null)
            }

            return ValidationResult.OK
        }
    }

    val editor = EditorComponent(editorContext.project, configuration)

    private val libraryValidator: FrameworkLibraryValidator
    private val versionValidator = VersionValidator()
    private val coroutineValidator = CoroutineContradictionValidator()

    init {
        libraryValidator = FrameworkLibraryValidatorWithDynamicDescription(
                DelegatingLibrariesValidatorContext(editorContext),
                validatorsManager,
                "kotlin"
        ) { editor.targetPlatformComboBox.selectedItem as TargetPlatformKind<*> }

        validatorsManager.registerValidator(libraryValidator)
        validatorsManager.registerValidator(versionValidator)
        validatorsManager.registerValidator(coroutineValidator)

        editor.compilerConfigurable.languageVersionComboBox.addActionListener {
            validatorsManager.validate()
        }

        editor.compilerConfigurable.apiVersionComboBox.addActionListener {
            validatorsManager.validate()
        }

        editor.targetPlatformComboBox.addActionListener {
            validatorsManager.validate()
        }

        editor.compilerConfigurable.coroutineSupportComboBox.addActionListener {
            validatorsManager.validate()
        }

        editor.compilerConfigurable.additionalArgsOptionsField.textField.document.addDocumentListener(
                object : DocumentAdapter() {
                    override fun textChanged(e: DocumentEvent) {
                        val text = e.document.getText(0, e.document.length)
                        if (text.contains("-Xcoroutine")) {
                            validatorsManager.validate()
                        }
                    }
                }
        )

        editor.updateCompilerConfigurable()

        reset()
    }

    override fun isModified(): Boolean {
        if (editor.useProjectSettingsCheckBox.isSelected != configuration.settings.useProjectSettings) return true
        if (editor.targetPlatformComboBox.selectedItem != configuration.settings.targetPlatformKind) return true
        return !editor.useProjectSettingsCheckBox.isSelected && editor.compilerConfigurable.isModified
    }

    override fun reset() {
        editor.useProjectSettingsCheckBox.isSelected = configuration.settings.useProjectSettings
        editor.targetPlatformComboBox.selectedItem = configuration.settings.targetPlatformKind
        editor.compilerConfigurable.reset()
        editor.updateCompilerConfigurable()
    }

    override fun apply() {
        editor.compilerConfigurable.apply()
        with(configuration.settings) {
            useProjectSettings = editor.useProjectSettingsCheckBox.isSelected
            (editor.targetPlatformComboBox.selectedItem as TargetPlatformKind<*>?)?.let {
                if (it != targetPlatformKind) {
                    val newCompilerArguments = it.createCompilerArguments()
                    val platformArguments = when (it) {
                        is TargetPlatformKind.Jvm -> editor.compilerConfigurable.k2jvmCompilerArguments
                        is TargetPlatformKind.JavaScript -> editor.compilerConfigurable.k2jsCompilerArguments
                        else -> null
                    }
                    if (platformArguments != null) {
                        mergeBeans(platformArguments, newCompilerArguments)
                    }
                    copyInheritedFields(compilerArguments!!, newCompilerArguments)
                    compilerArguments = newCompilerArguments
                }
            }
        }
    }

    override fun getDisplayName() = "General"

    override fun createComponent(): JComponent {
        val mainPanel = JPanel(BorderLayout())
        val contentPanel = FormBuilder
                .createFormBuilder()
                .addComponent(editor.useProjectSettingsCheckBox)
                .addLabeledComponent("&Target platform: ", editor.targetPlatformComboBox)
                .addComponent(editor.compilerConfigurable.createComponent()!!)
                .panel
        mainPanel.add(contentPanel, BorderLayout.NORTH)
        return mainPanel
    }

    override fun disposeUIResources() {
        editor.compilerConfigurable.disposeUIResources()
    }
}
