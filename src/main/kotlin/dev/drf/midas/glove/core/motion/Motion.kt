package dev.drf.midas.glove.core.motion

import dev.drf.midas.glove.core.entity.basic.Point3d
import dev.drf.midas.glove.core.entity.basic.Vector3d
import dev.drf.midas.glove.core.time.TimePeriod

data class Motion(val direction: Vector3d, val speed: Velocity) {
    fun movePoint(point: Point3d, period: TimePeriod): Point3d {
        // TODO сместить точку
        return point
    }
}