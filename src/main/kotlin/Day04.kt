import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class Day04 {
    companion object {
        fun solvePart1(shifts: List<String>): Int? {
            val startShift = """\[\d\d\d\d-\d\d-\d\d \d\d:\d\d] Guard #(\d+) begins shift""".toRegex()
            val sleep = """\[(\d\d\d\d-\d\d-\d\d \d\d:\d\d)] falls asleep""".toRegex()
            val wakeUp = """\[(\d\d\d\d-\d\d-\d\d \d\d:\d\d)] wakes up""".toRegex()
            val timestampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

            var id = 0
            var startSleep: LocalDateTime = LocalDateTime.now()

            val sleepsList = mutableListOf<Shift>()

            for (shift in shifts) {
                when {
                    shift matches startShift -> {
                        startShift.find(shift)?.let {
                            val (agentId) = it.destructured
                            id = agentId.toInt()
                        }
                    }
                    shift matches sleep -> {
                        sleep.find(shift)?.let {
                            val (timestamp) = it.destructured
                            startSleep = LocalDateTime.parse(timestamp, timestampFormatter)
                        }
                    }
                    shift matches wakeUp -> {
                        wakeUp.find(shift)?.let {
                            val (timestamp) = it.destructured
                            sleepsList.add(Shift(id, startSleep, LocalDateTime.parse(timestamp, timestampFormatter)))
                        }
                    }
                    else -> throw IllegalArgumentException("")
                }
            }

            val mostAsleepGuard = sleepsList.groupBy(Shift::id)
                .maxBy { it.value.sumBy { x -> x.sleepTime() } }


            val mostAsleepMinute = mostAsleepGuard?.value
                ?.flatMap { it.minutesAsleep() }
                ?.groupBy { it }
                ?.maxBy { it.value.size }
                ?.key

            return (mostAsleepGuard?.key ?: 0) * (mostAsleepMinute ?: 0)

        }
    }
}

data class Shift(val id: Int, val startSleep: LocalDateTime, val wakesUp: LocalDateTime) {

    fun sleepTime() = startSleep.until(wakesUp, ChronoUnit.MINUTES).toInt()

    fun minutesAsleep() = (startSleep.minute until wakesUp.minute).toList()
}