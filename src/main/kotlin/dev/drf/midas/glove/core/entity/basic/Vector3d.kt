package dev.drf.midas.glove.core.entity.basic

class Vector3d(startPoint: Point3d, destinationPoint: Point3d) {
    val point: Point3d
    val x: Coordinate
        get() = point.x
    val y: Coordinate
        get() = point.y
    val z: Coordinate
        get() = point.z

    companion object {
        val ZERO_VECTOR = Vector3d(Point3d.ZERO_POINT, Point3d.ZERO_POINT)
        val X_NORMAL = Vector3d(Point3d.ZERO_POINT, Point3d(1.0, 0.0, 0.0))
        val Y_NORMAL = Vector3d(Point3d.ZERO_POINT, Point3d(0.0, 1.0, 0.0))
        val Z_NORMAL = Vector3d(Point3d.ZERO_POINT, Point3d(0.0, 0.0, 1.0))
    }

    init {
        val x = destinationPoint.x - startPoint.x
        val y = destinationPoint.y - startPoint.y
        val z = destinationPoint.z - startPoint.z

        point = Point3d(x, y, z)
    }
}