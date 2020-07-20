package dev.drf.midas.glove.common

import dev.drf.midas.glove.core.entity.Coordinate

fun abs(x: Coordinate): Coordinate {
    return if (x.value < 0) -x else x
}