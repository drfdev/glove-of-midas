package dev.drf.midas.glove.core.entity.basic

import dev.drf.midas.glove.common.math.util.doubleEquals

data class Coordinate(val value: Double) {
    companion object {
        val ZERO = Coordinate(0.0)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass) {
            return false
        }

        other as Coordinate

        return doubleEquals(value, other.value)
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
