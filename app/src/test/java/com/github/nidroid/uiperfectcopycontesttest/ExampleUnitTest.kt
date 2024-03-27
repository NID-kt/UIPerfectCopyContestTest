package com.github.nidroid.uiperfectcopycontesttest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTextInput
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

    // TODO yourAnswerCaptureとかに変えたいけど差分取るところとかに影響出そうなので一旦このまま
    @Test
    fun yourAnswerTest() {
        composeRule.setContent {
            UIPerfectCopyContestTestTheme {
                Box(Modifier.width(answerWidth.dp)) {
                    YourAnswer()
                }
            }
        }

        // キャプチャ
        composeRule
            .onRoot()
            .assertExists()
            .captureRoboImage()
    }

    @Test
    fun yourAnswerRequirementsCheck() {
        composeRule.setContent {
            UIPerfectCopyContestTestTheme {
                Box(Modifier.width(answerWidth.dp)) {
                    YourAnswer()
                }
            }
        }

        // 各Composableの機能要件
        composeRule
            .assertOkButton()
        composeRule
            .assertNameTextField()
    }

    private fun ComposeContentTestRule.assertOkButton() =
        onNodeWithTag(Tags.OK_BUTTON).apply {
            // ボタンをクリックできるか
            assertExists("ボタンがないか、`.testTag(Tags.OK_BUTTON)` Modifierが正しく設定されていません。")
            assertHasRole(Role.Button) { "`.testTag(Tags.OK_BUTTON)` Modifierが設定されているComposableがボタンではありません。" }
            assert(hasClickAction()) { "`.testTag(Tags.OK_BUTTON)` Modifierが設定されているComposableにclickableが設定されていません。" }
        }

    private fun ComposeContentTestRule.assertNameTextField() {
        // abcdefg と入力してTextFieldの値がその通りになるか
        val input = "abcdefg"
        onNodeWithTag(Tags.NAME_TEXT_FIELD).apply {
            assertExists("nameテキストフィールドがないか、`.testTag(Tags.NAME_TEXT_FIELD)` Modifierが正しく設定されていません。")
            performTextInput(input)
            assert(hasText(input)) { "`.testTag(Tags.OK_BUTTON)` Modifierが設定されているComposableに正しく入力できません。テキストフィールドか確認してください。" }
        }
    }
}

private fun SemanticsNodeInteraction.assertHasRole(
    role: Role,
    messagePrefixOnError: (() -> String)? = null,
) =
    assert(
        SemanticsMatcher("${role}Roleが付与されているか") { node ->
            val nodeRole = node.config.getOrElse(
                key = SemanticsProperties.Role,
                defaultValue = { if (role == Role.Checkbox) Role.Button else Role.Checkbox },
            )
            nodeRole == role
        },
        messagePrefixOnError = messagePrefixOnError,
    )
