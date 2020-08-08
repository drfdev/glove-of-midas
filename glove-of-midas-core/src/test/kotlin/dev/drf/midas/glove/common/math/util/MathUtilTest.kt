package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.DELTA
import dev.drf.midas.glove.core.entity.basic.Coordinate
import org.junit.jupiter.api.Assertions.*
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
    fun shouldCompare_whenPositiveDouble() {
        // arrange
        val double1 = 1.0
        val double2 = 2.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenEqualPositiveDouble() {
        // arrange
        val double1 = 3.5
        val double2 = 3.5

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenNegativeDouble() {
        // arrange
        val double1 = -4.0
        val double2 = -2.7

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenEqualNegativeDouble() {
        // arrange
        val double1 = -2.2
        val double2 = -2.2

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenDoubleNotEqualByDelta() {
        // arrange
        val double1 = 1.01
        val double2 = 1.02

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenDoubleEqualByDelta() {
        // arrange
        val double1 = 3.001
        val double2 = 3.002

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenCompareWithZero() {
        // arrange
        val double1 = 4.47
        val double2 = 0.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenZeroCompare() {
        // arrange
        val double1 = 0.0
        val double2 = 6.65

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenZeroEqualZero() {
        // arrange
        val double1 = 0.0
        val double2 = 0.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenZeroEqualZeroWithDelta() {
        // arrange
        val double1 = 0.0001
        val double2 = 0.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenZeroWithDeltaEqualZeroWithDelta() {
        // arrange
        val double1 = 0.0001
        val double2 = 0.0002

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenBigValuesNotEqual() {
        // arrange
        val double1 = 995595939543.0
        val double2 = 676575675675.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenBigValuesEqual() {
        // arrange
        val double1 = 995595939543.0
        val double2 = 995595939543.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenBigValuesEqualWithDelta() {
        // arrange
        val double1 = 995595939543.00001
        val double2 = 995595939543.00002

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }
}