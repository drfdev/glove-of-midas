package dev.drf.midas.glove.common.math.shape

/**
 * Matrix 3x3
 * First index: row, second: column
 */
data class Matrix3x3(
        val a11: Double, val a12: Double, val a13: Double,
        val a21: Double, val a22: Double, val a23: Double,
        val a31: Double, val a32: Double, val a33: Double
) {
    private val determinant: Double = calculateDeterminant()

    /**
     * See more info: {@link https://en.wikipedia.org/wiki/Determinant}
     */
    private fun calculateDeterminant(): Double {
        return (a11 * a22 * a33) - (a11 * a23 * a32) - (a12 * a21 * a33) + (a12 * a23 * a31) + (a13 * a21 * a32) - (a13 * a22 * a31)
    }

    fun determinant(): Double {
        return determinant
    }
}