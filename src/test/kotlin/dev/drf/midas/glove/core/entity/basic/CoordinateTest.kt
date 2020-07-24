package dev.drf.midas.glove.core.entity.basic

import dev.drf.midas.glove.core.entity.basic.Coordinate
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

class CoordinateTest {

    @Test
    fun shouldNotEquals_whenCoordinateHasDifferentValues() {
        // arrange
        val x = Coordinate(10.0)
        val y = Coordinate(20.0)

        // act
        val result = Objects.equals(x, y)

        // assert
        assertFalse(result)
    }

    @Test
    fun shouldEquals_whenCoordinateHasEqualsValues() {
        // arrange
        val x = Coordinate(15.0)
        val y = Coordinate(15.0)

        // act
        val result = Objects.equals(x, y)

        // assert
        assertTrue(result)
    }
}