package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.DELTA
import dev.drf.midas.glove.common.math.util.abs
import dev.drf.midas.glove.core.entity.basic.Coordinate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathUtilTest {
    @Test
    fun shouldAbs_whenNegativeCoordinateValue() {
        // arrange
        val negative = Coordinate(-100.0)

        // act
        val absValue = abs(negative)

        // assert
        assertEquals(100.0, absValue.value, DELTA)
    }

    @Test
    fun shouldNotAbs_whenPositiveCoordinateValue() {
        // arrange
        val positive = Coordinate(100.0)

        // act
        val absValue = abs(positive)

        // assert
        assertEquals(100.0, absValue.value, DELTA)
    }

    @Test
    fun shouldNotAbs_whenZeroCoordinateValue() {
        // arrange
        val zero = Coordinate.ZERO

        // act
        val absValue = abs(zero)

        // assert
        assertEquals(0.0, absValue.value, DELTA)
    }
}