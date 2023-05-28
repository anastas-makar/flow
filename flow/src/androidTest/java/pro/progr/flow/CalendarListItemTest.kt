package pro.progr.flow

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import pro.progr.flow.composable.CalendarListItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class CalendarListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calendarListItem_displays_correct_date_and_content() {
        // Arrange
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        formatter =
            formatter.withLocale(Locale.getDefault()) // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH

        val date = LocalDate.parse("2023-04-13", formatter)
        val content: @Composable (d : LocalDate) -> Unit =  { Text(text = "Some content") }

        // Act
        composeTestRule.setContent {
            CalendarListItem(date = date, content = content)
        }

        // Assert
        composeTestRule.onNodeWithText(text = date.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Some content").assertIsDisplayed()
    }
}