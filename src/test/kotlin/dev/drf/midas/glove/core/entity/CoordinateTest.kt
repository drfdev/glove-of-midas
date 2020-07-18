package dev.drf.midas.glove.core.entity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

class CoordinateTest {

    @Test
    fun shouldNotEquals_whenCoordinateHasDifferentValues() {
        // arrange
        val x = Coordinate(10L)
        val y = Coordinate(20L)

        // act
        val result = Objects.equals(x, y)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldEquals_whenCoordinateHasEqualsValues() {
        // arrange
        val x = Coordinate(15L)
        val y = Coordinate(15L)

        // act
        val result = Objects.equals(x, y);

        // assert
        assertTrue(result)
    }
}