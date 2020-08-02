package dev.drf.midas.glove.core.time

data class TimePeriod(val tick: Int) {
    companion object {
        val SINGLE_TICK = TimePeriod(1)
    }

    operator fun plus(value: Int): TimePeriod {
        return TimePeriod(tick + value)
    }
    operator fun minus(value: Int): TimePeriod {
        return TimePeriod(tick - value)
    }
    operator fun times(value: Int): TimePeriod {
        return TimePeriod(tick * value)
    }
    operator fun div(value: Int): TimePeriod {
        return TimePeriod(tick / value)
    }
}