package pro.progr.flow.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import pro.progr.flow.dateFlow
import java.time.LocalDate

@Composable
fun VerticalDatesList(
    nestedScrollConnectionVert: NestedScrollConnection,
    verticalScrollState: LazyListState,
    content: @Composable (date : LocalDate) -> Unit
) {
    LazyColumn(
        state = verticalScrollState,
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnectionVert)
    ) {
        items(
            items = dateFlow,
        ) { listItem ->
            CalendarListItem(date = listItem, content = content)
        }
    }
}