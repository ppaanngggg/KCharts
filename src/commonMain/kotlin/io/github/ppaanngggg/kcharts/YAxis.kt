package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Color
import org.jetbrains.skia.Paint

enum class YAxisPosition {
  LEFT,
  RIGHT,
}

/** [yAxis](https://echarts.apache.org/zh/option.html#yAxis) */
class YAxis(
    type: AxisType,
    gridIndex: Int = 0,
    val position: YAxisPosition = YAxisPosition.LEFT,
) : Axis(type = type, gridIndex = gridIndex) {
  override fun draw(width: Float, height: Float, canvas: Canvas, option: Option) {
    val bbox = option.grids[gridIndex].getBBox(width, height)
    val paint = Paint().setStroke(true).setARGB(255, 0, 0, 0)
    paint.isAntiAlias = false

    when (position) {
      YAxisPosition.LEFT -> canvas.drawLine(bbox.left, bbox.top, bbox.left, bbox.bottom, paint)
      YAxisPosition.RIGHT -> canvas.drawLine(bbox.right, bbox.top, bbox.right, bbox.bottom, paint)
    }
  }
}
