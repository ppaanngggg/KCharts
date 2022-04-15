package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

enum class XAxisPosition {
  TOP,
  BOTTOM,
}

/** [xAxis](https://echarts.apache.org/zh/option.html#xAxis) */
class XAxis(
    type: AxisType = AxisType.CATEGORY,
    gridIndex: Int = 0,
    private val position: XAxisPosition = XAxisPosition.BOTTOM,
    axisLine: AxisLine = AxisLine(true),
    splitLine: SplitLine = SplitLine(false),
) : Axis(type = type, gridIndex = gridIndex, axisLine = axisLine, splitLine = splitLine) {
  override fun draw(width: Float, height: Float, canvas: Canvas, option: Option) {
    val bbox = option.grids[gridIndex].getBBox(width, height)

    when (position) {
      XAxisPosition.TOP -> canvas.drawLine(bbox.left, bbox.top, bbox.right, bbox.top, primaryPaint)
      XAxisPosition.BOTTOM ->
          canvas.drawLine(bbox.left, bbox.bottom, bbox.right, bbox.bottom, primaryPaint)
    }
  }
}
