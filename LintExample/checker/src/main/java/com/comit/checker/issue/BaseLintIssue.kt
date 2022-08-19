package com.comit.checker.issue

import com.android.tools.lint.detector.api.*

sealed class BaseLintIssue(
    val id: String,
    val briefDescription: String,
    val category: Category,
    val priority: Int,
    val severity: Severity
) {
    fun toLintIssue(
        detectorCls: Class<out Detector>,
        description: String = briefDescription
    ): Issue =
        Issue.create(
            id = id,
            briefDescription = briefDescription,
            explanation = description,
            category = category,
            priority = priority,
            severity = severity,
            implementation = Implementation(
                detectorCls,
                Scope.JAVA_FILE_SCOPE
            )
        )
}