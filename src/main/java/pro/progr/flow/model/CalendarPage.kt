package pro.progr.flow.model


import java.time.LocalDate

class CalendarPage(var displayDate: LocalDate, selectedDate : LocalDate) {
    val yearName : String
    val month : CalendarMonth

    init {
        yearName = displayDate.year.toString()
        month = CalendarMonth(displayDate, selectedDate)
    }
}