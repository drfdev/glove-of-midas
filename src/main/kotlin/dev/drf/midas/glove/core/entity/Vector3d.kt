package dev.drf.midas.glove.core.entity

class Vector3d(startPoint: Point3d, destinationPoint: Point3d) {
    val point: Point3d

    init {
        val x = destinationPoint.x - startPoint.x
        val y = destinationPoint.y - startPoint.y
        val z = destinationPoint.z - startPoint.z

        point = Point3d(x, y, z)
    }
}