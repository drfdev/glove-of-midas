package dev.drf.midas.glove.core.entity.shape

import dev.drf.midas.glove.core.entity.Point3d
import dev.drf.midas.glove.core.entity.Vector3d

data class Cube(
        val center: Point3d,
        val sideLength: Double,
        val forward: Vector3d,
        val top: Vector3d
) {
    // TODO
}