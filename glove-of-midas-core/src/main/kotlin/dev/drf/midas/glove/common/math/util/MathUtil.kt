package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.common.math.SCALE
import dev.drf.midas.glove.core.entity.basic.Coordinate
import dev.drf.midas.glove.core.entity.basic.Point3d
import java.lang.Double.doubleToLongBits
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt

const val SQUARE: Int = 2

fun abs(x: Coordinate): Coordinate {
    return if (x.value < 0) -x else x
}

fun negative(x: Coordinate): Coordinate {
    return Coordinate(-1 * x.value)
}

fun doubleEquals(a: Double, b: Double): Boolean {
    if (doubleToLongBits(a) == doubleToLongBits(b)) {
        return true
    }
    val aConverted = a.toBigDecimal().setScale(SCALE, RoundingMode.HALF_EVEN)
    val bConverted = b.toBigDecimal().setScale(SCALE, RoundingMode.HALF_EVEN)

    return aConverted.compareTo(bConverted) == 0
}

fun distance(first: Point3d, second: Point3d): Double {
    val xSquare: Double = square(first.x.value - second.x.value)
    val ySquare: Double = square(first.y.value - second.y.value)
    val zSquare: Double = square(first.z.value - second.z.value)

    return sqrt(xSquare + ySquare + zSquare)
}

private fun square(value: Double): Double {
    return value.pow(SQUARE)
}