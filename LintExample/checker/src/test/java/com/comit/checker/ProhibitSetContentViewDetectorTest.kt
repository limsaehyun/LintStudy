package com.comit.checker

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import com.comit.checker.detector.ProhibitSetContentViewDetector
import org.junit.Test

class ProhibitSetContentViewDetectorTest : LintDetectorTest() {

    override fun getDetector(): Detector = ProhibitSetContentViewDetector()

    override fun getIssues(): MutableList<Issue> =
        mutableListOf(ProhibitSetContentViewDetector.ISSUE)

    @Test
    fun testProhibitSetContentViewDetector() {
        val stubFile = kotlin(
            """
package com.comit.lint

class SetContentViewStub {
    fun main() {
        setContentView(123)
    }
}
            """
        ).indented()

        lint()
            .files(stubFile)
            .allowMissingSdk(true)
            .run()
            .expectErrorCount(1)
    }
}