package pro.progr.flow

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import pro.progr.flow.composable.CalendarListItem


class CalendarListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calendarListItem_displays_correct_date_and_content() {
        // Arrange
        val date = "2023-04-13"
        val content: @Composable () -> Unit =  { Text(text = "Some content") }

        // Act
        composeTestRule.setContent {
            CalendarListItem(date = date, content = content)
        }

        // Assert
        composeTestRule.onNodeWithText(text = date).assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Some content").assertIsDisplayed()
    }
}