package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

enum class YAxisPosition {
  LEFT,
  RIGHT,
}

/** [yAxis](https://echarts.apache.org/zh/option.html#yAxis) */
class YAxis(
    type: AxisType = AxisType.VALUE,
    gridIndex: Int = 0,
    private val position: YAxisPosition = YAxisPosition.LEFT,
    axisLine: AxisLine = AxisLine(false),
    splitLine: SplitLine = SplitLine(true),
) : Axis(type = type, gridIndex = gridIndex, axisLine = axisLine, splitLine = splitLine) {
  override fun draw(width: Float, height: Float, canvas: Canvas, option: Option) {
    val bbox = option.grids[gridIndex].getBBox(width, height)

    // draw axis line, https://echarts.apache.org/zh/option.html#xAxis.axisLine
    if (axisLine.show) {
      when (position) {
        YAxisPosition.LEFT ->
            canvas.drawLine(bbox.left, bbox.top, bbox.left, bbox.bottom, primaryPaint)
        YAxisPosition.RIGHT ->
            canvas.drawLine(bbox.right, bbox.top, bbox.right, bbox.bottom, primaryPaint)
      }

    }
  }
}
