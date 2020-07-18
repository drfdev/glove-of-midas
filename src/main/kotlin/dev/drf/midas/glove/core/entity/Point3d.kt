package dev.drf.midas.glove.core.entity

data class Point3d(val x: Coordinate, val y: Coordinate, val z: Coordinate) {
    companion object {
        val ZERO_POINT = Point3d(Coordinate.ZERO, Coordinate.ZERO, Coordinate.ZERO);
    }

    fun toVector(startPoint: Point3d): Vector3d {
        return Vector3d(startPoint, this);
    }
}