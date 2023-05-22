package pro.progr.flow.model

import pro.progr.flow.CALENDAR_INITIAL_LOAD_SIZE
import pro.progr.flow.START_POSITION
import pro.progr.flow.startDate
import java.time.LocalDate

class DateFlow : List<LocalDate> {

    override fun get(index: Int): LocalDate {
        return startDate.plusDays((index - START_POSITION).toLong())
    }

    override val size: Int
        get() = CALENDAR_INITIAL_LOAD_SIZE

    override fun contains(element: LocalDate): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<LocalDate>): Boolean {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: LocalDate): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun iterator(): Iterator<LocalDate> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: LocalDate): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<LocalDate> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<LocalDate> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<LocalDate> {
        TODO("Not yet implemented")
    }

    override fun equals(other: Any?): Boolean {
        return other is DateFlow
    }

    override fun hashCode(): Int {
        return "version: 1".hashCode()
    }
}
