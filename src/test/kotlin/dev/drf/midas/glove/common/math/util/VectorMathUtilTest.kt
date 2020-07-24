package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.DELTA
import dev.drf.midas.glove.common.math.util.summation
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
    fun should_when() {
        // arrange
        // TODO дописать остальные тесты

        // act

        // assert

    }
}