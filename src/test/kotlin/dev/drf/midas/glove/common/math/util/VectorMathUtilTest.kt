package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.DELTA
import dev.drf.midas.glove.core.entity.basic.Point3d
import dev.drf.midas.glove.core.entity.basic.Vector3d
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VectorMathUtilTest {
    @Test
    fun shouldCorrectSum_whenTwoSimpleVector() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(2.0, 0.0, 0.0))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(0.0, 2.0, 0.0))

        // act
        val sum = summation(value1, value2)

        // assert
        assertEquals(2.0, sum.x.value, DELTA)
        assertEquals(2.0, sum.y.value, DELTA)
        assertEquals(0.0, sum.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSum_whenZeroAndSimpleVector() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(1.0, 2.0, 3.0))

        // act
        val sum = summation(Vector3d.ZERO_VECTOR, value1)

        // assert
        assertEquals(1.0, sum.x.value, DELTA)
        assertEquals(2.0, sum.y.value, DELTA)
        assertEquals(3.0, sum.z.value, DELTA)
    }

    @Test
    fun shouldEqualsSum_whenSwitchTerms() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(2.0, 1.5, 0.3))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(1.0, 4.0, 2.1))

        // act
        val sum1 = summation(value1, value2)
        val sum2 = summation(value2, value1)

        // assert
        assertEquals(3.0, sum1.x.value, DELTA)
        assertEquals(5.5, sum1.y.value, DELTA)
        assertEquals(2.4, sum1.z.value, DELTA)

        assertEquals(3.0, sum2.x.value, DELTA)
        assertEquals(5.5, sum2.y.value, DELTA)
        assertEquals(2.4, sum2.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSum_whenVectorHasNegativeValues() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(-1.0, 2.5, 0.7))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(2.4, -1.3, -0.2))

        // act
        val sum = summation(value1, value2)

        // assert
        assertEquals(1.4, sum.x.value, DELTA)
        assertEquals(1.2, sum.y.value, DELTA)
        assertEquals(0.5, sum.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSum_whenNegativeValueBigger() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(-3.5, -3.5, -4.5))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(2.0, 1.5, 2.5))

        // act
        val sum = summation(value1, value2)

        // assert
        assertEquals(-1.5, sum.x.value, DELTA)
        assertEquals(-2.0, sum.y.value, DELTA)
        assertEquals(-2.0, sum.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSum_whenFractionValue() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(0.02, 0.01, 0.03))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(0.03, 0.07, 0.11))

        // act
        val sum = summation(value1, value2)

        // assert
        assertEquals(0.05, sum.x.value, DELTA)
        assertEquals(0.08, sum.y.value, DELTA)
        assertEquals(0.14, sum.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSubstract_whenTwoPositiveVector() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(4.0, 4.0, 4.0))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(1.5, 2.0, 2.5))

        // act
        val result = subtraction(value1, value2)

        // assert
        assertEquals(2.5, result.x.value, DELTA)
        assertEquals(2.0, result.y.value, DELTA)
        assertEquals(1.5, result.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSubstract_whenZeroFromVector() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(1.7, 1.9, 2.1))
        val value2 = Vector3d.ZERO_VECTOR

        // act
        val result = subtraction(value1, value2)

        // assert
        assertEquals(1.7, result.x.value, DELTA)
        assertEquals(1.9, result.y.value, DELTA)
        assertEquals(2.1, result.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSubstract_whenZeroToVector() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(1.7, 1.9, 2.1))
        val value2 = Vector3d.ZERO_VECTOR

        // act
        val result = subtraction(value2, value1)

        // assert
        assertEquals(-1.7, result.x.value, DELTA)
        assertEquals(-1.9, result.y.value, DELTA)
        assertEquals(-2.1, result.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSubstract_whenZeroToZero() {
        // arrange
        val value1 = Vector3d.ZERO_VECTOR
        val value2 = Vector3d.ZERO_VECTOR

        // act
        val result = subtraction(value1, value2)

        // assert
        assertEquals(0.0, result.x.value, DELTA)
        assertEquals(0.0, result.y.value, DELTA)
        assertEquals(0.0, result.z.value, DELTA)
    }

    @Test
    fun shouldCorrectSubstract_whenFractionValue() {
        // arrange
        val value1 = Vector3d(Point3d.ZERO_POINT, Point3d(0.02, 0.13, 0.09))
        val value2 = Vector3d(Point3d.ZERO_POINT, Point3d(0.01, 0.04, 0.07))

        // act
        val result = subtraction(value1, value2)

        // assert
        assertEquals(0.01, result.x.value, DELTA)
        assertEquals(0.09, result.y.value, DELTA)
        assertEquals(0.02, result.z.value, DELTA)
    }

    @Test
    fun shouldUnitVector_whenNormalVector() {
        // arrange
        val value = Vector3d.X_NORMAL

        // act
        val result = toUnitVector(value)

        // assert
        assertEquals(1.0, result.x.value, DELTA)
        assertEquals(0.0, result.y.value, DELTA)
        assertEquals(0.0, result.z.value, DELTA)
    }

    @Test
    fun shouldUnitVector_whenLongVector() {
        // arrange
        val value = Vector3d(Point3d.ZERO_POINT, Point3d(5.0, 5.0, 5.0))

        // act
        val result = toUnitVector(value)

        // assert
        val len = vectorLength(result)
        assertEquals(1.0, len, DELTA)
    }

    @Test
    fun shouldUnitVector_whenLongNormalVector() {
        // arrange
        val value = Vector3d(Point3d.ZERO_POINT, Point3d(0.0, 0.0, 7.0))

        // act
        val result = toUnitVector(value)

        // assert
        assertEquals(0.0, result.x.value, DELTA)
        assertEquals(0.0, result.y.value, DELTA)
        assertEquals(1.0, result.z.value, DELTA)
    }

    @Test
    fun shouldUnitVector_whenFractionValue() {
        // arrange
        val value = Vector3d(Point3d.ZERO_POINT, Point3d(0.2, 0.3, 0.5))

        // act
        val result = toUnitVector(value)

        // assert
        val len = vectorLength(result)
        assertEquals(1.0, len, DELTA)
    }
}