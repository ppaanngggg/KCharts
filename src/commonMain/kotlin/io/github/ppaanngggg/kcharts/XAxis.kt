package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

enum class XAxisPosition {
  TOP,
  BOTTOM,
}

/**
 * [xAxis](https://echarts.apache.org/zh/option.html#xAxis)
 *
 * @param type axis type, line, bar, etc...
 * @param gridIndex apply to which grid
 * @property position on grid top or bottom
 */
class XAxis(
    type: AxisType,
    gridIndex: Int = 0,
    private val position: XAxisPosition = XAxisPosition.TOP,
) : Axis(type = type, gridIndex = gridIndex) {
  override fun draw(width: Int, height: Int, canvas: Canvas, option: Option) {
    val grid = option.grids[gridIndex]
    grid.anchor(width, height)
  }
}
