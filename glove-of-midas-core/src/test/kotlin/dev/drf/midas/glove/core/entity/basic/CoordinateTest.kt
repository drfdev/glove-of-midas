package dev.drf.midas.glove.core.entity.basic

import dev.drf.midas.glove.DELTA
import org.junit.jupiter.api.Assertions.*
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

    @Test
    fun shouldCorrectConvert_whenUsedLongConstructor() {
        // arrange
        val coordinate = Coordinate(5)

        // assert
        assertEquals(5.0, coordinate.value, DELTA)
    }

    @Test
    fun shouldEquals_whenCoordinateEqualWithDelta() {
        // arrange
        val x = Coordinate(7.00001)
        val y = Coordinate(7.00002)

        // act
        val result = Objects.equals(x, y)

        // assert
        assertTrue(result)
    }

    @Test
    fun shouldEqualsByMethod_whenCoordinateEqualWithDelta() {
        // arrange
        val x = Coordinate(12.02031)
        val y = Coordinate(12.02032)

        // act
        val result = x == y

        // assert
        assertTrue(result)
    }
}