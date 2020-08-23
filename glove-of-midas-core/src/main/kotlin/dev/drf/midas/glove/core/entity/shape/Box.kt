package dev.drf.midas.glove.core.entity.shape

import dev.drf.midas.glove.core.entity.Shape
import dev.drf.midas.glove.core.entity.basic.Point3d

data class Box(
        val basePoint: Point3d,
        val height: Double,
        val width: Double,
        val length: Double
): Shape