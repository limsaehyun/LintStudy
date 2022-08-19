package com.comit.checker.issue

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Severity

object ProhibitSetContentIssue : BaseLintIssue(
        id = "ProhibitSetContentView",
        briefDescription = "Prohibit setContentView()",
        category = Category.CORRECTNESS,
        priority = 5,
        severity = Severity.ERROR,
    )