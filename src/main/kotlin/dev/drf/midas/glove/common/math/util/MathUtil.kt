package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.core.entity.basic.Coordinate

fun abs(x: Coordinate): Coordinate {
    return if (x.value < 0) -x else x
}