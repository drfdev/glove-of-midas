package dev.drf.midas.glove.core.entity

data class Box(val center: Point3d, val edge: Long) {
    fun isInside(point: Point3d): Boolean {
        // TODO проверка нахождения точки в кубе
        return false
    }

    fun hasCrossing(box: Box): Boolean {
        // TODO проверка есть ли пересечения между коробками
        return false
    }
}