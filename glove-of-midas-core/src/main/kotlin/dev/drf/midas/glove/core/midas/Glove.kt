package dev.drf.midas.glove.core.midas

data class Glove(
        private val thumb: Finger,
        private val index: Finger,
        private val middle: Finger,
        private val ring: Finger,
        private val pinky: Finger,

        private val base: GloveBase
)
// TODO