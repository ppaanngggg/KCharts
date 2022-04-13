package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.internal.BBox
import io.github.ppaanngggg.kcharts.internal.Point

data class Grid(
    val left: Float = 0.1f,
    val top: Float = 0.1f,
    val right: Float = 0.1f,
    val bottom: Float = 0.1f,
) {
  fun getBBox(width: Float, height: Float): BBox {
    return BBox(
        lt = Point(width * left, height * top),
        rb = Point(width * (1 - right), height * (1 - bottom)),
    )
  }
}
