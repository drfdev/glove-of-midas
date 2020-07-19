package dev.drf.midas.glove.core.entity

import org.junit.jupiter.api.Assertions.assertEquals
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
}