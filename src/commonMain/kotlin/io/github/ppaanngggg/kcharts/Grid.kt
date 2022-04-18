package io.github.ppaanngggg.kcharts

/**
 * [Grid] define an area to draw chart
 *
 * @param left, left margin, 0~1
 * @param top, top margin, 0~1
 * @param right, right margin, 0~1
 * @param bottom, bottom margin, 0~1
 */
data class Grid(
    val left: Float = 0.1f,
    val top: Float = 0.1f,
    val right: Float = 0.1f,
    val bottom: Float = 0.1f,
)
