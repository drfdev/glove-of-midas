package dev.drf.midas.glove.core.motion

import dev.drf.midas.glove.core.entity.basic.Point3d

class Path {
    private val points = ArrayList<Point3d>()

    fun nextPoint(next: Point3d) {
        points.add(next)
    }
}