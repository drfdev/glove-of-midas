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

    @Test
    fun shouldConvertCoordinate_whenPositiveValue() {
        // arrange
        val coordinate = Coordinate(5.0)

        // act
        val negative = negative(coordinate)

        // assert
        assertEquals(-5.0, negative.value, DELTA)
    }

    @Test
    fun shouldConvertCoordinate_whenNegativeValue() {
        // arrange
        val coordinate = Coordinate(-4.0)

        // act
        val negative = negative(coordinate)

        // assert
        assertEquals(4.0, negative.value, DELTA)
    }

    @Test
    fun shouldBeEqual_whenZeroValue() {
        // arrange
        val zero = Coordinate.ZERO

        // act
        val negative = negative(zero)

        // assert
        assertEquals(0.0, negative.value, DELTA)
        assertEquals(zero.value, negative.value, DELTA)
    }

    @Test
    fun should_when() {
        // arrange
        // TODO дописать остальные тесты

        // act

        // assert

    }
}