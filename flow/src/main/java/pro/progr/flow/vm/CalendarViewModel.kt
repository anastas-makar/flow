package pro.progr.flow.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import pro.progr.flow.getIndex
import pro.progr.flow.model.CalendarPage
import pro.progr.flow.startDate
import java.time.LocalDate

class CalendarViewModel {

    private var displayDate = startDate

    var selectedDate = startDate

    val calendarPage = mutableStateOf(CalendarPage(displayDate, selectedDate))

    fun monthBefore() {
        displayDate = displayDate.minusMonths(1)
        calendarPage.value = CalendarPage(displayDate, selectedDate)
    }

    fun monthAfter() {
        displayDate = displayDate.plusMonths(1)
        calendarPage.value = CalendarPage(displayDate, selectedDate)
    }

    fun updateDayOfMonth(item : Int) {
        selectedDate = displayDate.withDayOfMonth(item)
        calendarPage.value = CalendarPage(displayDate, selectedDate)
    }

    fun updateSelectedDate(date : LocalDate) {
        selectedDate = date
        calendarPage.value = CalendarPage(displayDate, selectedDate)
    }

    fun updateYear(yearName: String) {
        displayDate = displayDate.withYear(yearName.toInt())
        calendarPage.value = CalendarPage(displayDate, selectedDate)
    }

    private val _selectedGridIndex = MutableStateFlow(getIndex(LocalDate.now()))
    val selectedGridIndex : Flow<Int> = _selectedGridIndex

    private val _selectedDates = mutableStateOf(listOf(LocalDate.now()))
    val selectedDates : State<List<LocalDate>> = _selectedDates

    fun selectGridDate(date : LocalDate) {
        _selectedGridIndex.value = getIndex(date)
        _selectedDates.value = listOf(date)
    }
}