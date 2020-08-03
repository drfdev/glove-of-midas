package dev.drf.midas.glove.core.entity.basic

import dev.drf.midas.glove.DELTA
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Point3dTest {

    @Test
    fun shouldEqualZero_whenAnotherZeroPoint() {
        // arrange
        val point = Point3d(Coordinate(0.0), Coordinate(0.0), Coordinate(0.0))

        // assert
        assertEquals(Point3d.ZERO_POINT, point)
    }

    @Test
    fun shouldBuildVersion_whenVectorFromStart() {
        // arrange
        val point = Point3d(1.0, 1.0, 1.0)

        // act
        val vector = point.toVectorFrom(Point3d(0.0, 0.0, 0.0))

        // assert
        assertEquals(1.0, vector.point.x.value, DELTA)
        assertEquals(1.0, vector.point.y.value, DELTA)
        assertEquals(1.0, vector.point.z.value, DELTA)
    }

    @Test
    fun shouldBuildVersion_whenVectorToDestination() {
        // arrange
        val point = Point3d(2.0, 2.0, 2.0)

        // act
        val vector = point.toVectorTo(Point3d(1.0, 1.0, 1.0))

        // assert
        assertEquals(-1.0, vector.point.x.value, DELTA)
        assertEquals(-1.0, vector.point.y.value, DELTA)
        assertEquals(-1.0, vector.point.z.value, DELTA)
    }

    @Test
    fun shouldEquals_whenEqualPoint() {
        // arrange
        val point1 = Point3d(12.0, -7.0, 1.5)
        val point2 = Point3d(12.0, -7.0, 1.5)

        // act
        val result = point1 == point2

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldEquals_whenEqualPointsValueByDelta() {
        // arrange
        val point1 = Point3d(12.00001, -7.00003, 1.50012)
        val point2 = Point3d(12.00002, -7.00005, 1.50015)

        // act
        val result = point1 == point2

        // assert
        assertTrue(result)
    }
}