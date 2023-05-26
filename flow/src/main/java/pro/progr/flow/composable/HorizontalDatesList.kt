package pro.progr.flow.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import pro.progr.flow.calendarViewModel
import pro.progr.flow.dateFlow
import pro.progr.flow.getDateByIndex
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun HorizontalDatesList(
    horizontalScrollState: LazyListState,
    verticalScrollState: LazyListState
) {
    val lazyRowWidth = LocalConfiguration.current.screenWidthDp.dp - 40.dp

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            var blocked = false

            override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
                if (!blocked) {
                    blocked = true

                    val requredIndex = if(consumed.x >= 0) {
                                            horizontalScrollState.firstVisibleItemIndex
                                        } else {
                                            horizontalScrollState.firstVisibleItemIndex + 1
                                        }

                    calendarViewModel.updateSelectedDate(getDateByIndex(requredIndex))
                    horizontalScrollState.scrollToItem(requredIndex)

                    blocked = false

                    verticalScrollState.scrollToItem(requredIndex)
                }

                return super.onPostFling(consumed, available)
            }
        }
    }

    LazyRow(
        state = horizontalScrollState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .nestedScroll(nestedScrollConnection)
    ) {
        items(dateFlow) { date ->
            Text(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .width(lazyRowWidth),
                text = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}