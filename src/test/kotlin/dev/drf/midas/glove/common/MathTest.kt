package dev.drf.midas.glove.common

import dev.drf.midas.glove.core.entity.Coordinate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathTest {
    @Test
    fun shouldAbs_whenNegativeCoordinateValue() {
        // arrange
        val negative = Coordinate(-100.0)

        // act
        val absValue = abs(negative)

        // assert
        assertEquals(100.0, absValue.value, 0.001)
    }

    @Test
    fun shouldNotAbs_whenPositiveCoordinateValue() {
        // arrange
        val positive = Coordinate(100.0)

        // act
        val absValue = abs(positive)

        // assert
        assertEquals(100.0, absValue.value, 0.001)
    }

    @Test
    fun shouldNotAbs_whenZeroCoordinateValue() {
        // arrange
        val zero = Coordinate.ZERO

        // act
        val absValue = abs(zero)

        // assert
        assertEquals(0.0, absValue.value, 0.001)
    }
}