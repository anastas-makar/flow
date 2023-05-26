package pro.progr.flow.vm

import androidx.compose.runtime.mutableStateOf
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
}