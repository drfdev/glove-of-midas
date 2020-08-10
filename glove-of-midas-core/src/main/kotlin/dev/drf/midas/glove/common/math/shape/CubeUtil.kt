package dev.drf.midas.glove.common.math.shape

import dev.drf.midas.glove.common.math.util.*
import dev.drf.midas.glove.core.entity.shape.Cube
import dev.drf.midas.glove.core.motion.Motion
import dev.drf.midas.glove.core.motion.Path
import dev.drf.midas.glove.core.motion.Rotation
import dev.drf.midas.glove.core.time.TimePeriod

fun moveCube(cube: Cube, motion: Motion, period: TimePeriod): Cube {
    val center = cube.center;
    val sideLength = cube.sideLength;
    val forward = cube.forward;
    val top = cube.top;

    val movedCenter = movePoint(center, motion, period)

    return Cube(movedCenter, sideLength, forward, top)
}

fun rotateCube(cube: Cube, rotate: Rotation, period: TimePeriod): Cube {
    val center = cube.center;
    val sideLength = cube.sideLength;
    val forward = cube.forward;
    val top = cube.top;

    val rotatedForward = rotateVector(forward, rotate, period)
    val rotatedTop = rotateVector(top, rotate, period)

    return Cube(center, sideLength, rotatedForward, rotatedTop)
}

fun detectMove(start: Cube, end: Cube, period: TimePeriod): Motion {
    val startPoint = start.center
    val endPoint = end.center

    return detectPointMove(startPoint, endPoint, period)
}

fun detectRotate(start: Cube, end: Cube, period: TimePeriod): Rotation {
    val forwardRotate = detectVectorRotate(start.forward, end.forward, period)
    val topRotate = detectVectorRotate(start.top, end.top, period)

    return combineRotation(forwardRotate, topRotate)
}

fun moveByPath(cube: Cube, path: Path): Cube {
    // TODO
    return cube
}