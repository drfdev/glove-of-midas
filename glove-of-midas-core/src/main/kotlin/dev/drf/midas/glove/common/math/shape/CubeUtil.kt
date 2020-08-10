package dev.drf.midas.glove.common.math.shape

import dev.drf.midas.glove.core.entity.basic.Vector3d
import dev.drf.midas.glove.core.entity.shape.Cube
import dev.drf.midas.glove.core.motion.Motion
import dev.drf.midas.glove.core.motion.Path
import dev.drf.midas.glove.core.motion.Rotation
import dev.drf.midas.glove.core.motion.Velocity
import dev.drf.midas.glove.core.time.TimePeriod

fun moveCube(cube: Cube, motion: Motion, period: TimePeriod): Cube {
    val center = cube.center;
    val sideLength = cube.sideLength;
    val forward = cube.forward;
    val top = cube.top;

    // TODO

    return cube
}

fun rotateCube(cube: Cube, rotate: Rotation, period: TimePeriod): Cube {
    val center = cube.center;
    val sideLength = cube.sideLength;
    val forward = cube.forward;
    val top = cube.top;

    // TODO

    return cube
}

fun detectMove(start: Cube, end: Cube, period: TimePeriod): Motion {
    // TODO
    return Motion(Vector3d.ZERO_VECTOR, Velocity(0.0))
}

fun detectRotate(start: Cube, end: Cube, period: TimePeriod): Rotation {
    // TODO
    return Rotation(Vector3d.ZERO_VECTOR, Vector3d.ZERO_VECTOR, Velocity(0.0), Velocity(0.0))
}

fun moveByPath(cube: Cube, path: Path): Cube {
    // TODO
    return cube
}