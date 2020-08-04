package dev.drf.midas.glove.core.motion

import dev.drf.midas.glove.core.entity.basic.Vector3d

data class Rotation(
        val direction: Vector3d,
        val rotate: Vector3d,
        val speed: Velocity,
        val rotateSpeed: Velocity)