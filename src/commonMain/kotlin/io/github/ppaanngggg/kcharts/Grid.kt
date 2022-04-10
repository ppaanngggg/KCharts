package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.internal.Point

data class Grid(
    val left: Float = 0.1f,
    val top: Float = 0.1f,
    val right: Float = 0.1f,
    val bottom: Float = 0.1f,
) {
  fun anchor(width: Int, height: Int): Point {
    return Point(0, 0)
  }
}
