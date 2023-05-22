package pro.progr.flow.util

import androidx.compose.foundation.lazy.LazyListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Scroller {

    companion object {

        val scrollParentJob = Job()
        val scrollCoroutineScope = CoroutineScope(Dispatchers.Main + scrollParentJob)

        fun scroll(verticalScrollState: LazyListState, horizontalScrollState: LazyListState, index : Int) {

            scrollCoroutineScope.launch {
                verticalScrollState.scrollToItem(index)
                horizontalScrollState.scrollToItem(index)
            }
        }
    }

}