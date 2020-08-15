package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.common.math.SCALE
import dev.drf.midas.glove.core.entity.basic.Coordinate
import java.lang.Double.doubleToLongBits
import java.math.RoundingMode

fun abs(x: Coordinate): Coordinate {
    return if (x.value < 0) -x else x
}

fun negative(x: Coordinate): Coordinate {
    return Coordinate(-1 * x.value)
}

fun doubleEquals(a: Double, b: Double): Boolean {
    if (doubleToLongBits(a) == doubleToLongBits(b)) {
        return true;
    }
    val aConverted = a.toBigDecimal().setScale(SCALE, RoundingMode.HALF_EVEN)
    val bConverted = b.toBigDecimal().setScale(SCALE, RoundingMode.HALF_EVEN)

    return aConverted.compareTo(bConverted) == 0
}