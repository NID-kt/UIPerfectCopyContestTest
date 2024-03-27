package com.github.nidroid.uiperfectcopycontesttest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.github.nidroid.uiperfectcopycontesttest.ui.theme.UIPerfectCopyContestTestTheme
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun yourAnswerTest() {
        composeRule.setContent {
            UIPerfectCopyContestTestTheme {
                Box(Modifier.width(answerWidth.dp)) {
                    YourAnswer()
                }
            }
        }

        composeRule
            .onRoot()
            .assertExists()
            .captureRoboImage()
    }
}