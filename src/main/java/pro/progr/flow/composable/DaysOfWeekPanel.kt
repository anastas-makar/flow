package pro.progr.flow.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import pro.progr.flow.R

@Composable
fun DaysOfWeekPanel() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.monday),
            Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.tuesday),
            Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.wednesday),
            Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.thursday),
            Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.friday),
            Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.saturday), Modifier.weight(1f), style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        )
        Text(
            text = stringResource(id = R.string.sunday), Modifier.weight(1f), style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        )
    }
}