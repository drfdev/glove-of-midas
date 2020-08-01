package dev.drf.midas.glove.common.math.util

import dev.drf.midas.glove.core.entity.basic.Point3d
import dev.drf.midas.glove.core.entity.basic.Vector3d
import kotlin.math.abs
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

fun isParallel(vector1: Vector3d, vector2: Vector3d): Boolean {
    if (vector1.isZero() || vector2.isZero()) {
        return false
    }
    val cos = calculateCos(vector1, vector2)
    return doubleEquals(abs(cos), 1.0)
}

fun isOrthogonal(vector1: Vector3d, vector2: Vector3d): Boolean {
    if (vector1.isZero() || vector2.isZero()) {
        return false
    }
    val cos = calculateCos(vector1, vector2)
    return doubleEquals(cos, 0.0)
}

private fun calculateCos(vector1: Vector3d, vector2: Vector3d): Double {
    val len1 = vectorLength(vector1)
    val len2 = vectorLength(vector2)

    if (doubleEquals(len1, 0.0) || doubleEquals(len2, 0.0)) {
        throw ArithmeticException("Division by zero")
    }

    val calcX = vector1.x * vector2.x
    val calcY = vector1.y * vector2.y
    val calcZ = vector1.z * vector2.z

    val calcSum = (calcX + calcY + calcZ).value

    return calcSum / (len1 * len2)
}