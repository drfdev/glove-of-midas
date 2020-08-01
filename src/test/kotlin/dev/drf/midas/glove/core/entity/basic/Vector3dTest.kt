package dev.drf.midas.glove.core.entity.basic

import dev.drf.midas.glove.core.entity.basic.Point3d
import dev.drf.midas.glove.core.entity.basic.Vector3d
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Vector3dTest {
    @Test
    fun shouldCreateVector_whenStartToDestination() {
        // arrange
        val start = Point3d(1.0, 1.0, 1.0)
        val end = Point3d(2.0, 2.0, 2.0)

        // act
        val vector = Vector3d(start, end)

        // assert
        assertEquals(1.0, vector.point.x.value)
        assertEquals(1.0, vector.point.y.value)
        assertEquals(1.0, vector.point.z.value)
    }

    @Test
    fun shouldCreateVector_whenDestinationToStart() {
        // arrange
        val start = Point3d(1.0, 1.0, 1.0)
        val end = Point3d(2.0, 2.0, 2.0)

        // act
        val vector = Vector3d(end, start)

        // assert
        assertEquals(-1.0, vector.point.x.value)
        assertEquals(-1.0, vector.point.y.value)
        assertEquals(-1.0, vector.point.z.value)
    }

    @Test
    fun shouldBeZero_whenZeroVector() {
        // arrange
        val vector = Vector3d.ZERO_VECTOR

        // act
        val result = vector.isZero()

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldNotBeZero_whenNonZeroVector() {
        // arrange
        val vector = Vector3d(Point3d.ZERO_POINT, Point3d(1.0, 2.0, 3.0))

        // act
        val result = vector.isZero()

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldBeZero_whenEqualZeroVector() {
        // arrange
        val vector = Vector3d(Point3d.ZERO_POINT, Point3d(0.0, 0.0, 0.0))

        // act
        val result = vector.isZero()

        // assert
        assertTrue(result)
    }
}