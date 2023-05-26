package pro.progr.flow.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MonthAndYearPanel() {
    val editYear = remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        ChangeMonth()

        if (editYear.value) {
            EditYear(editYear = editYear)
        } else {
            ShowYear(editYear = editYear)
        }

        Spacer(modifier = Modifier.width(8.dp))

    }
}