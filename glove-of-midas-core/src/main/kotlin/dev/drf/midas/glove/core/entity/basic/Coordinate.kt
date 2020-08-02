package dev.drf.midas.glove.core.entity.basic

data class Coordinate(val value: Double) {
    companion object {
        val ZERO = Coordinate(0.0);
    }

    constructor(v: Long) : this(v.toDouble())

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
