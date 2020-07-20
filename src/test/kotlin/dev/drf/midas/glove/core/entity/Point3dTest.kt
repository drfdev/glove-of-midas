package dev.drf.midas.glove.core.entity

import org.junit.jupiter.api.Assertions.assertEquals
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
        assertEquals(1.0, vector.point.x.value, 0.001)
        assertEquals(1.0, vector.point.y.value, 0.001)
        assertEquals(1.0, vector.point.z.value, 0.001)
    }

    @Test
    fun shouldBuildVersion_whenVectorToDestination() {
        // arrange
        val point = Point3d(2.0, 2.0, 2.0)

        // act
        val vector = point.toVectorTo(Point3d(1.0, 1.0, 1.0))

        // assert
        assertEquals(-1.0, vector.point.x.value, 0.001)
        assertEquals(-1.0, vector.point.y.value, 0.001)
        assertEquals(-1.0, vector.point.z.value, 0.001)
    }
}