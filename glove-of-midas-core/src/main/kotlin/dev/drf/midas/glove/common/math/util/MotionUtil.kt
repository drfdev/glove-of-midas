package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.core.entity.basic.Point3d
import dev.drf.midas.glove.core.entity.basic.Vector3d
import dev.drf.midas.glove.core.motion.Motion
import dev.drf.midas.glove.core.motion.Rotation
import dev.drf.midas.glove.core.motion.Velocity
import dev.drf.midas.glove.core.time.TimePeriod

fun movePoint(point: Point3d, motion: Motion, period: TimePeriod): Point3d {
    // TODO

    return point
}

fun rotateVector(vector: Vector3d, rotate: Rotation, period: TimePeriod): Vector3d {
    // TODO

    return vector
}

fun detectPointMove(start: Point3d, end: Point3d, period: TimePeriod): Motion {
    // TODO

    return Motion(Vector3d.ZERO_VECTOR, Velocity(0.0))
}

fun detectVectorRotate(start: Vector3d, end: Vector3d, period: TimePeriod): Rotation {
    // TODO

    return Rotation(Vector3d.ZERO_VECTOR, Vector3d.ZERO_VECTOR, Velocity(0.0), Velocity(0.0))
}

fun combineRotation(first: Rotation, second: Rotation): Rotation {
    // TODO

    return Rotation(Vector3d.ZERO_VECTOR, Vector3d.ZERO_VECTOR, Velocity(0.0), Velocity(0.0))
}