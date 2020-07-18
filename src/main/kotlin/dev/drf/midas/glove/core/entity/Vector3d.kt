package dev.drf.midas.glove.core.entity

class Vector3d(startPoint: Point3d, directionPoint: Point3d) {
    private val point: Point3d

    init {
        val x = directionPoint.x - startPoint.x
        val y = directionPoint.y - startPoint.y
        val z = directionPoint.z - startPoint.z

        point = Point3d(x, y, z)
    }
}