package dev.drf.midas.glove.common

import dev.drf.midas.glove.core.entity.Point3d
import dev.drf.midas.glove.core.entity.Vector3d
import kotlin.math.sqrt

fun summation(left: Vector3d, right: Vector3d): Vector3d {
    val point = Point3d(
            left.point.x + right.point.x,
            left.point.y + right.point.y,
            left.point.z + right.point.z
    )
    return point.toVectorFrom(Point3d.ZERO_POINT)
}

fun subtraction(left: Vector3d, right: Vector3d): Vector3d {
    val point = Point3d(
            left.point.x - right.point.x,
            left.point.y - right.point.y,
            left.point.z - right.point.z
    )
    return point.toVectorFrom(Point3d.ZERO_POINT)
}

fun toUnitVector(vector: Vector3d): Vector3d {
    val len = vectorLength(vector)

    val point = Point3d(
            vector.x.value / len,
            vector.y.value / len,
            vector.z.value / len
    )
    return point.toVectorFrom(Point3d.ZERO_POINT)
}

fun vectorLength(vector: Vector3d): Double {
    val x = vector.x.value
    val y = vector.y.value
    val z = vector.z.value

    return sqrt((x * x) + (y * y) + (z * z))
}

// TODO Добавить метод 1) параллельные 2) ортогональные 3) на одной линии