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

package org.jetbrains.uast.kotlin

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.psiUtil.getQualifiedElementSelector
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UImportStatement
import org.jetbrains.uast.USimpleNameReferenceExpression
import org.jetbrains.uast.psi.PsiElementBacked

class KotlinUImportStatement(
        override val psi: KtImportDirective,
        override val containingElement: UElement?
) : UImportStatement {
    override val isOnDemand: Boolean
        get() = psi.isAllUnder
    
    private val importRef by lz { psi.importedReference?.let { ImportReference(it, psi.name ?: psi.text, this) } }
    
    override val importReference: UElement?
        get() = importRef

    override fun resolve() = importRef?.resolve()
    
    private class ImportReference(
            override val psi: KtExpression,
            override val identifier: String,
            override val containingElement: UElement?
    ) : KotlinAbstractUExpression(), USimpleNameReferenceExpression, PsiElementBacked {
        override val resolvedName: String?
            get() = identifier

        override fun resolve() = psi.getQualifiedElementSelector()?.mainReference?.resolve()?.getMaybeLightElement(this)
    }
}