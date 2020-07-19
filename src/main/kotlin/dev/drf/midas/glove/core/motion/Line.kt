package dev.drf.midas.glove.core.motion

import dev.drf.midas.glove.core.entity.Point3d
import dev.drf.midas.glove.core.entity.Vector3d

data class Line(val start: Point3d, val end: Point3d) {
    fun toForwardVector(): Vector3d {
        return Vector3d(start, end)
    }

    fun toBackwardVector(): Vector3d {
        return Vector3d(end, start)
    }
}