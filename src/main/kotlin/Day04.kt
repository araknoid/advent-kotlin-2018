class Day04 {

    companion object {

        private val startShift = """\[\d\d\d\d-\d\d-\d\d \d\d:\d\d] Guard #(\d+) begins shift""".toRegex()
        private val sleep = """\[\d\d\d\d-\d\d-\d\d \d\d:(\d\d)] falls asleep""".toRegex()
        private val wakeUp = """\[\d\d\d\d-\d\d-\d\d \d\d:(\d\d)] wakes up""".toRegex()

        fun solvePart1(shifts: List<String>): Int {

            val mostAsleepGuard = shifts.asShiftList()
                .groupBy(Shift::id)
                .maxBy { it.value.sumBy(Shift::sleepTime) }

            val mostAsleepMinute = mostAsleepGuard!!.value
                .flatMap { it.minutesAsleep() }
                .groupBy { it }
                .maxBy { it.value.size }!!.key

            return mostAsleepGuard.key * mostAsleepMinute
        }

        fun solvePart2(shifts: List<String>): Int {

            val mostAsleepGuardAtAMinute = shifts.asShiftList()
                .groupBy(Shift::id)
                .mapValues { shift ->
                    shift.value
                        .flatMap(Shift::minutesAsleep)
                        .groupBy { it }
                        .maxBy { minutes -> minutes.value.size }
                }
                .maxBy { it.value!!.value.size }

            return mostAsleepGuardAtAMinute!!.key * mostAsleepGuardAtAMinute.value!!.key
        }

        private fun List<String>.asShiftList(): List<Shift> {
            var guard = 0
            var sleepStart = 0

            val sleepsList = mutableListOf<Shift>()

            for (shift in this.sorted()) {
                when {
                    shift matches startShift -> guard = startShift.first(shift)
                    shift matches sleep -> sleepStart = sleep.first(shift)
                    else -> sleepsList.add(Shift(guard, sleepStart, wakeUp.first(shift)))
                }
            }

            return sleepsList
        }

        private fun Regex.first(from: String) = this.find(from)!!.destructured.component1().toInt()
    }
}

data class Shift(val id: Int, val sleepStart: Int, val sleepEnd: Int) {

    fun sleepTime() = sleepEnd - sleepStart

    fun minutesAsleep() = (sleepStart until sleepEnd).toList()
}
