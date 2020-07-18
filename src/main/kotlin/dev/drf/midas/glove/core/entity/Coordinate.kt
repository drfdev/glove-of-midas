package dev.drf.midas.glove.core.entity

data class Coordinate(val value: Long) {
    companion object {
        val ZERO = Coordinate(0);
    }

    operator fun unaryMinus(): Coordinate {
        return Coordinate(-value)
    }

    operator fun plus(item: Coordinate): Coordinate {
        return Coordinate(value + item.value)
    }
    operator fun minus(item: Coordinate): Coordinate {
        return Coordinate(value - item.value)
    }
    operator fun times(item: Coordinate): Coordinate {
        return Coordinate(value * item.value)
    }
    operator fun div(item: Coordinate): Coordinate {
        return Coordinate(value / item.value)
    }
}
