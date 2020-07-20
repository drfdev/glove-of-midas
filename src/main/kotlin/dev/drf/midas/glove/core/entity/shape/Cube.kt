package dev.drf.midas.glove.core.entity.shape

import dev.drf.midas.glove.core.entity.Point3d
import dev.drf.midas.glove.core.entity.Vector3d
import dev.drf.midas.glove.core.entity.common.NormalType

data class Cube(
        val center: Point3d,
        val sideLength: Double,
        val left: Vector3d,
        val right: Vector3d,
        val normal: NormalType
) {
    // TODO
}