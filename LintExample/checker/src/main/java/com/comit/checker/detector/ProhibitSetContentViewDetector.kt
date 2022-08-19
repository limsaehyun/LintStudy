package com.comit.checker.detector

import com.android.tools.lint.detector.api.*
import com.comit.checker.issue.ProhibitSetContentView
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

private const val DATA_BINDING_METHOD = "androidx.databinding.DataBindingUtil"

private const val SET_CONTENT_VIEW_METHOD = "setContentView"

class ProhibitSetContentViewDetector: Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = ProhibitSetContentView.toLintIssue(
            ProhibitSetContentViewDetector::class.java,
            "Prohibit setContentView(), use DataBindingUtil.setContentView() instead",
        )
    }

    override fun getApplicableMethodNames(): List<String> {
        return listOf(SET_CONTENT_VIEW_METHOD)
    }

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if(context.evaluator.isMemberInClass(method, DATA_BINDING_METHOD)) {
            return
        }

        context.report(
            issue = ISSUE,
            scope = node,
            location = context.getLocation(node),
            message = "Use DataBindingUtil.setContentView() instead"
        )
    }
}