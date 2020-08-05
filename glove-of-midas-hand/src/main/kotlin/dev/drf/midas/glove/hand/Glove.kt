package dev.drf.midas.glove.hand

import dev.drf.midas.glove.hand.glove.Finger
import dev.drf.midas.glove.hand.glove.GloveBase
import dev.drf.midas.glove.hand.glove.GloveType

data class Glove(
        private val thumb: Finger,
        private val index: Finger,
        private val middle: Finger,
        private val ring: Finger,
        private val pinky: Finger,

        private val base: GloveBase,

        private val type: GloveType
)
// TODO