package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.DELTA
import dev.drf.midas.glove.core.entity.basic.Coordinate
import dev.drf.midas.glove.core.entity.basic.Point3d
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt
import kotlin.random.Random

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
    fun shouldCompare_whenDoubleNotEqualBySecondDigit() {
        // arrange
        val double1 = 1.01
        val double2 = 1.02

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenDoubleNotEqualByThirdDigit() {
        // arrange
        val double1 = 1.001
        val double2 = 1.002

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldCompare_whenDoubleEqualByDigitPlace() {
        // arrange
        val double1 = 3.0001
        val double2 = 3.0002

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
    fun shouldCompare_whenZeroEqualZeroWithDigitPlace() {
        // arrange
        val double1 = 0.0001
        val double2 = 0.0

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCompare_whenZeroWithDigitPlaceEqualZeroWithDigitPlace() {
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
    fun shouldCompare_whenBigValuesEqualWithDigitPlace() {
        // arrange
        val double1 = 995595939543.00001
        val double2 = 995595939543.00002

        // act
        val result = doubleEquals(double1, double2)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldCorrectCompare_whenEqualsWithRounding() {
        // arrange
        val d1 = 123.0011
        val d2 = 123.0017

        // act
        val result = doubleEquals(d1, d2)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldEquals_whenCeilRounding() {
        // arrange
        val ceil = arrayOf(12.0010, 12.0011, 12.0012, 12.0013, 12.0014)

        // act - assert
        for (i in ceil.indices) {
            for (j in 1 until ceil.size) {
                val d1 = ceil[i]
                val d2 = ceil[j]

                val result = doubleEquals(d1, d2)

                assertTrue(result)
            }
        }
    }

    @Test
    fun shouldEquals_whenFloorRounding() {
        // arrange
        val floor = arrayOf(12.0015, 12.0016, 12.0017, 12.0018, 12.0019)

        // act - assert
        for (i in floor.indices) {
            for (j in 1 until floor.size) {
                val d1 = floor[i]
                val d2 = floor[j]

                val result = doubleEquals(d1, d2)

                assertTrue(result, "Failed when equals [$d1, $d2]")
            }
        }
    }

    @Test
    fun shouldNotEquals_whenCeilAndFloorRounding() {
        // arrange
        val ceil = arrayOf(12.0010, 12.0011, 12.0012, 12.0013, 12.0014)
        val floor = arrayOf(12.0015, 12.0016, 12.0017, 12.0018, 12.0019)

        // act - assert
        for (i in ceil.indices) {
            for (j in floor.indices) {
                val d1 = ceil[i]
                val d2 = floor[j]

                val result = doubleEquals(d1, d2)

                assertFalse(result, "Failed when equals [$d1, $d2]")
            }
        }
    }

    @Test
    fun shouldEquals_whenCeilAndFloorRoundingWithDifferentBase() {
        // arrange
        val ceil = arrayOf(13.0010, 13.0011, 13.0012, 13.0013, 13.0014)
        val floor = arrayOf(12.0015, 12.0016, 12.0017, 12.0018, 12.0019)

        // act - assert
        for (i in ceil.indices) {
            for (j in floor.indices) {
                val d1 = floor[i]
                val d2 = floor[j]

                val result = doubleEquals(d1, d2)

                assertTrue(result, "Failed when equals [$d1, $d2]")
            }
        }
    }

    @Test
    fun shouldCalculateDistance_whenSimplePoints() {
        // arrange
        val first = Point3d.ZERO_POINT
        val second = Point3d(1.0, 0.0, 0.0)

        // act
        val dist = distance(first, second)

        // assert
        assertEquals(1.0, dist, DELTA)
    }

    @Test
    fun shouldCalculateDistance_whenEqualPoints() {
        // arrange
        val first = Point3d(1.0, 2.0, 3.0)
        val second = Point3d(1.0, 2.0, 3.0)

        // act
        val dist = distance(first, second)

        // assert
        assertEquals(0.0, dist, DELTA)
    }

    @Test
    fun shouldCalculateDistance_whenSomePoints() {
        // arrange
        val first = Point3d(1.0, 1.0, 1.0)
        val second = Point3d(3.0, 3.0, 3.0)
        val expected = sqrt(12.0)

        // act
        val dist = distance(first, second)

        // assert
        assertEquals(expected, dist, DELTA)
    }

    @Test
    fun shouldCalculateDistance_whenNegativeCoordinatePoints() {
        // arrange
        val first = Point3d(-1.0, -1.0, -1.0)
        val second = Point3d(-3.0, -3.0, -3.0)
        val expected = sqrt(12.0)

        // act
        val dist = distance(first, second)

        // assert
        assertEquals(expected, dist, DELTA)
    }

    @Test
    fun shouldCalculateDistance_whenRandomValuePoints() {
        repeat(10) {
            // arrange
            val x1 = rand()
            val y1 = rand()
            val z1 = rand()
            val x2 = rand()
            val y2 = rand()
            val z2 = rand()

            val first = Point3d(x1, y1, z1)
            val second = Point3d(x2, y2, z2)

            val expected = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2))

            // act
            val dist = distance(first, second)

            // assert
            assertEquals(expected, dist, DELTA)
        }
    }

    private fun rand(): Double {
        return Random.nextDouble(51.3257, 52.4557)
    }
}