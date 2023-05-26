package pro.progr.flow.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@Composable
fun CalendarListItem(date : LocalDate, content: @Composable (date : LocalDate) -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.LightGray,/*colorResource(id = R.color.opaque_grey),*/
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(bottom = 10.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(10.dp)
                .wrapContentHeight()
                .align(Alignment.CenterHorizontally),
            text = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
            style = MaterialTheme.typography.body1
        )

        content(date)
    }
}