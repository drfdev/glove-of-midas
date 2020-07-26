package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.common.math.DELTA
import dev.drf.midas.glove.core.entity.basic.Coordinate

fun abs(x: Coordinate): Coordinate {
    return if (x.value < 0) -x else x
}

fun negative(x: Coordinate): Coordinate {
    return Coordinate(-1 * x.value)
}

fun doubleEquals(a: Double, b: Double): Boolean {
    // IBM formula
    return kotlin.math.abs(a / b - 1) < DELTA
}