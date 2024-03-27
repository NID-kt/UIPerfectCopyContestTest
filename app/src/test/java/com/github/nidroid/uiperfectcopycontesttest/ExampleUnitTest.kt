package com.github.nidroid.uiperfectcopycontesttest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
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
            YourAnswer()
        }

        composeRule
            .onRoot()
            .assertExists()
            .captureRoboImage()
    }
}