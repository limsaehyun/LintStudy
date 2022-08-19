package com.comit.checker

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.comit.checker.detector.ProhibitSetContentViewDetector

@Suppress("unused")
class CustomIssueRegistry: IssueRegistry() {

    override val api: Int = CURRENT_API

    override val issues: List<Issue> = listOf(
        ProhibitSetContentViewDetector.ISSUE
    )

}