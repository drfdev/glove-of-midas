package dev.drf.midas.glove.core.entity

import dev.drf.midas.glove.common.abs

class Vector3d(startPoint: Point3d, directionPoint: Point3d) {
    private val point: Point3d

    init {
        val x = abs(directionPoint.x - startPoint.x)
        val y = abs(directionPoint.y - startPoint.y)
        val z = abs(directionPoint.z - startPoint.z)

        point = Point3d(x, y, z)
    }
}