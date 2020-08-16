package dev.drf.midas.glove.common.math.shape

import dev.drf.midas.glove.core.entity.basic.Point3d

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
    // TODO

    return Point3d.ZERO_POINT
}