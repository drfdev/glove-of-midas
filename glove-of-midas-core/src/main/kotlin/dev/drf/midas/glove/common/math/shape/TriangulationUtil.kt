package dev.drf.midas.glove.common.math.shape

import dev.drf.midas.glove.core.entity.basic.Point3d
import kotlin.math.pow

/**
 * Result: the point of intersection of the three spheres centered at the base points
 * Sphere equation: (x - x0)^2 + (y - y0)^2 + (z - z0)^2 = R^2
 * where R - radius and (x0, y0, z0) - center of sphere
 *
 * Triangulation calculation:
 * Get 3 sphere:
 * (x - x1)^2 + (y - y1)^2 + (z - z1)^2 = len1^2
 * (x - x2)^2 + (y - y2)^2 + (z - z2)^2 = len2^2
 * (x - x3)^2 + (y - y3)^2 + (z - z3)^2 = len3^2
 *
 * Combine all equations into system of equations
 * Solution - triangulation point
 *
 * b^2 = x0^2 + y0^2 + z0^2
 *
 * System of equations:
 * (x1 - x2)*X + (y1 - y2)*Y + (z1 - z2)*Z = (R2^2 - R1^2 + b1^2 - b2^2) / 2
 * (x1 - x3)*X + (y1 - y3)*Y + (z1 - z3)*Z = (R3^2 - R1^2 + b1^2 - b3^2) / 2
 * (x2 - x3)*X + (y2 - y3)*Y + (z2 - z3)*Z = (R3^2 - R2^2 + b2^2 - b3^2) / 2
 *
 * T(1,2) = (R2^2 - R1^2 + b1^2 - b2^2) / 2
 *
 * (x1 - x2)*X + (y1 - y2)*Y + (z1 - z2)*Z = T(1,2)
 * (x1 - x3)*X + (y1 - y3)*Y + (z1 - z3)*Z = T(1,3)
 * (x2 - x3)*X + (y2 - y3)*Y + (z2 - z3)*Z = T(2,3)
 *
 * Cramer rule:
 * https://en.wikipedia.org/wiki/Cramer%27s_rule
 */
fun triangulation(basePoint1: Point3d, basePoint2: Point3d, basePoint3: Point3d,
                  length1: Double, length2: Double, length3: Double): Point3d {
    val a11 = basePoint1.x.value - basePoint2.x.value
    val a12 = basePoint1.y.value - basePoint2.y.value
    val a13 = basePoint1.z.value - basePoint2.z.value

    val a21 = basePoint1.x.value - basePoint3.x.value
    val a22 = basePoint1.y.value - basePoint3.y.value
    val a23 = basePoint1.z.value - basePoint3.z.value

    val a31 = basePoint2.x.value - basePoint3.x.value
    val a32 = basePoint2.y.value - basePoint3.y.value
    val a33 = basePoint2.z.value - basePoint3.z.value

    val t12 = calculateT(basePoint1, basePoint2, length1, length2)
    val t13 = calculateT(basePoint1, basePoint3, length1, length3)
    val t23 = calculateT(basePoint2, basePoint3, length2, length3)

    val det = Matrix3x3(a11, a12, a13,
                        a21, a22, a23,
                        a31, a32, a33)
            .determinant()

    val det1 = Matrix3x3(t12, a12, a13,
                         t13, a22, a23,
                         t23, a32, a33)
            .determinant()
    val det2 = Matrix3x3(a11, t12, a13,
                         a21, t13, a23,
                         a31, t23, a33)
            .determinant()
    val det3 = Matrix3x3(a11, a12, t12,
                         a21, a22, t13,
                         a31, a32, t23)
            .determinant()

    val x1 = det1 / det
    val x2 = det2 / det
    val x3 = det3 / det

    return Point3d(x1, x2, x3)
}

/**
 * b^2 = x0^2 + y0^2 + z0^2
 * T(1,2) = (R2^2 - R1^2 + b1^2 - b2^2) / 2
 */
private fun calculateT(point1: Point3d, point2: Point3d,
                       length1: Double, length2: Double): Double {
    val b1 = calculateB(point1)
    val b2 = calculateB(point2)

    return ( length2.pow(2) - length1.pow(2) + b1.pow(2) - b2.pow(2) ) / 2
}

private fun calculateB(point: Point3d): Double {
    return point.x.value.pow(2) + point.y.value.pow(2) + point.z.value.pow(2)
}