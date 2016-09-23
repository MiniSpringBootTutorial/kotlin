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

package org.jetbrains.kotlin.idea.imports;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class JvmOptimizeImportsTestGenerated extends AbstractJvmOptimizeImportsTest {
    @TestMetadata("idea/testData/editor/optimizeImports/jvm")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Jvm extends AbstractJvmOptimizeImportsTest {
        public void testAllFilesPresentInJvm() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/editor/optimizeImports/jvm"), Pattern.compile("^([^.]+)\\.kt$"), true);
        }

        @TestMetadata("AlreadyOptimized.kt")
        public void testAlreadyOptimized() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/AlreadyOptimized.kt");
            doTest(fileName);
        }

        @TestMetadata("CallableReference.kt")
        public void testCallableReference() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/CallableReference.kt");
            doTest(fileName);
        }

        @TestMetadata("CallableReference2.kt")
        public void testCallableReference2() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/CallableReference2.kt");
            doTest(fileName);
        }

        @TestMetadata("ClassFromSameFileImportAddedBug.kt")
        public void testClassFromSameFileImportAddedBug() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/ClassFromSameFileImportAddedBug.kt");
            doTest(fileName);
        }

        @TestMetadata("DoNotTouchIfNoChanges.kt")
        public void testDoNotTouchIfNoChanges() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/DoNotTouchIfNoChanges.kt");
            doTest(fileName);
        }

        @TestMetadata("DuplicatedImports.kt")
        public void testDuplicatedImports() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/DuplicatedImports.kt");
            doTest(fileName);
        }

        @TestMetadata("FromCompanionObject.kt")
        public void testFromCompanionObject() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/FromCompanionObject.kt");
            doTest(fileName);
        }

        @TestMetadata("FromCompanionObjectGeneric.kt")
        public void testFromCompanionObjectGeneric() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/FromCompanionObjectGeneric.kt");
            doTest(fileName);
        }

        @TestMetadata("JavaStaticField.kt")
        public void testJavaStaticField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/JavaStaticField.kt");
            doTest(fileName);
        }

        @TestMetadata("KDocReference.kt")
        public void testKDocReference() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/KDocReference.kt");
            doTest(fileName);
        }

        @TestMetadata("KT10226.kt")
        public void testKT10226() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/KT10226.kt");
            doTest(fileName);
        }

        @TestMetadata("KT13766.kt")
        public void testKT13766() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/KT13766.kt");
            doTest(fileName);
        }

        @TestMetadata("Kt1850FullQualified.kt")
        public void testKt1850FullQualified() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/Kt1850FullQualified.kt");
            doTest(fileName);
        }

        @TestMetadata("Kt1850InnerClass.kt")
        public void testKt1850InnerClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/Kt1850InnerClass.kt");
            doTest(fileName);
        }

        @TestMetadata("NestedClassInObject.kt")
        public void testNestedClassInObject() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/NestedClassInObject.kt");
            doTest(fileName);
        }

        @TestMetadata("Operators.kt")
        public void testOperators() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/Operators.kt");
            doTest(fileName);
        }

        @TestMetadata("PlusAndPlusAssign.kt")
        public void testPlusAndPlusAssign() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/PlusAndPlusAssign.kt");
            doTest(fileName);
        }

        @TestMetadata("RemoveImportsIfGeneral.kt")
        public void testRemoveImportsIfGeneral() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/RemoveImportsIfGeneral.kt");
            doTest(fileName);
        }

        @TestMetadata("RemoveImportsIfGeneralBefore.kt")
        public void testRemoveImportsIfGeneralBefore() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/RemoveImportsIfGeneralBefore.kt");
            doTest(fileName);
        }

        @TestMetadata("SamConstructor.kt")
        public void testSamConstructor() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/SamConstructor.kt");
            doTest(fileName);
        }

        @TestMetadata("StaticMethodFromSuper.kt")
        public void testStaticMethodFromSuper() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/StaticMethodFromSuper.kt");
            doTest(fileName);
        }

        @TestMetadata("ThisAndSuper.kt")
        public void testThisAndSuper() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/ThisAndSuper.kt");
            doTest(fileName);
        }

        @TestMetadata("TrivialAlias.kt")
        public void testTrivialAlias() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/TrivialAlias.kt");
            doTest(fileName);
        }

        @TestMetadata("UnusedImports.kt")
        public void testUnusedImports() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/UnusedImports.kt");
            doTest(fileName);
        }

        @TestMetadata("WithAliases.kt")
        public void testWithAliases() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/WithAliases.kt");
            doTest(fileName);
        }

        @TestMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class AllUnderImports extends AbstractJvmOptimizeImportsTest {
            public void testAllFilesPresentInAllUnderImports() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/editor/optimizeImports/jvm/allUnderImports"), Pattern.compile("^([^.]+)\\.kt$"), true);
            }

            @TestMetadata("ClassNameConflict.kt")
            public void testClassNameConflict() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/ClassNameConflict.kt");
                doTest(fileName);
            }

            @TestMetadata("ClassNameConflict2.kt")
            public void testClassNameConflict2() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/ClassNameConflict2.kt");
                doTest(fileName);
            }

            @TestMetadata("ClassNameConflictWithCurrentPackage.kt")
            public void testClassNameConflictWithCurrentPackage() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/ClassNameConflictWithCurrentPackage.kt");
                doTest(fileName);
            }

            @TestMetadata("ClassNameConflictWithCurrentPackage2.kt")
            public void testClassNameConflictWithCurrentPackage2() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/ClassNameConflictWithCurrentPackage2.kt");
                doTest(fileName);
            }

            @TestMetadata("ClassNameConflictWithDefault.kt")
            public void testClassNameConflictWithDefault() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/ClassNameConflictWithDefault.kt");
                doTest(fileName);
            }

            @TestMetadata("NameCountSetting.kt")
            public void testNameCountSetting() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/NameCountSetting.kt");
                doTest(fileName);
            }

            @TestMetadata("PackagesToUseStarImport.kt")
            public void testPackagesToUseStarImport() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/PackagesToUseStarImport.kt");
                doTest(fileName);
            }

            @TestMetadata("Simple.kt")
            public void testSimple() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/jvm/allUnderImports/Simple.kt");
                doTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/editor/optimizeImports/common")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Common extends AbstractJvmOptimizeImportsTest {
        public void testAllFilesPresentInCommon() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/editor/optimizeImports/common"), Pattern.compile("^([^.]+)\\.kt$"), true);
        }

        @TestMetadata("ArrayAccessExpression.kt")
        public void testArrayAccessExpression() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/ArrayAccessExpression.kt");
            doTest(fileName);
        }

        @TestMetadata("ClassMemberImported.kt")
        public void testClassMemberImported() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/ClassMemberImported.kt");
            doTest(fileName);
        }

        @TestMetadata("ComponentFunction.kt")
        public void testComponentFunction() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/ComponentFunction.kt");
            doTest(fileName);
        }

        @TestMetadata("CurrentPackage.kt")
        public void testCurrentPackage() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/CurrentPackage.kt");
            doTest(fileName);
        }

        @TestMetadata("DefaultObjectReference.kt")
        public void testDefaultObjectReference() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/DefaultObjectReference.kt");
            doTest(fileName);
        }

        @TestMetadata("Enums.kt")
        public void testEnums() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/Enums.kt");
            doTest(fileName);
        }

        @TestMetadata("InvokeFunction.kt")
        public void testInvokeFunction() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/InvokeFunction.kt");
            doTest(fileName);
        }

        @TestMetadata("IteratorFunction.kt")
        public void testIteratorFunction() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/IteratorFunction.kt");
            doTest(fileName);
        }

        @TestMetadata("KT11640.kt")
        public void testKT11640() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/KT11640.kt");
            doTest(fileName);
        }

        @TestMetadata("KT11640_1.kt")
        public void testKT11640_1() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/KT11640_1.kt");
            doTest(fileName);
        }

        @TestMetadata("KT13689.kt")
        public void testKT13689() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/KT13689.kt");
            doTest(fileName);
        }

        @TestMetadata("KT9875.kt")
        public void testKT9875() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/KT9875.kt");
            doTest(fileName);
        }

        @TestMetadata("KeywordNames.kt")
        public void testKeywordNames() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/KeywordNames.kt");
            doTest(fileName);
        }

        @TestMetadata("Kt2488EnumEntry.kt")
        public void testKt2488EnumEntry() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/Kt2488EnumEntry.kt");
            doTest(fileName);
        }

        @TestMetadata("Kt2709.kt")
        public void testKt2709() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/Kt2709.kt");
            doTest(fileName);
        }

        @TestMetadata("MemberImports.kt")
        public void testMemberImports() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/MemberImports.kt");
            doTest(fileName);
        }

        @TestMetadata("MembersInScope.kt")
        public void testMembersInScope() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/MembersInScope.kt");
            doTest(fileName);
        }

        @TestMetadata("NestedClassReferenceOutsideClassBody.kt")
        public void testNestedClassReferenceOutsideClassBody() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/NestedClassReferenceOutsideClassBody.kt");
            doTest(fileName);
        }

        @TestMetadata("Overloads.kt")
        public void testOverloads() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/Overloads.kt");
            doTest(fileName);
        }

        @TestMetadata("TwoConstructors.kt")
        public void testTwoConstructors() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/TwoConstructors.kt");
            doTest(fileName);
        }

        @TestMetadata("TypeAliasUsage.kt")
        public void testTypeAliasUsage() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/editor/optimizeImports/common/TypeAliasUsage.kt");
            doTest(fileName);
        }
    }
}