package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Paint

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
    private val position: XAxisPosition = XAxisPosition.BOTTOM,
) : Axis(type = type, gridIndex = gridIndex) {
  override fun draw(width: Float, height: Float, canvas: Canvas, option: Option) {
    val bbox = option.grids[gridIndex].getBBox(width, height)
    val paint = Paint().setStroke(true).setARGB(255, 0, 0, 0)
    paint.isAntiAlias = false

    // 1. line
    when (position) {
      XAxisPosition.TOP -> canvas.drawLine(bbox.left, bbox.top, bbox.right, bbox.top, paint)
      XAxisPosition.BOTTOM ->
          canvas.drawLine(bbox.left, bbox.bottom, bbox.right, bbox.bottom, paint)
    }
    // 2.
  }
}
