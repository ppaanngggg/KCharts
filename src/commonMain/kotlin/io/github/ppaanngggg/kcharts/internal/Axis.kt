package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.*
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Color
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Rect

private val primaryPaint: Paint =
    Paint().also {
      it.isAntiAlias = false
      it.color = Color.makeARGB(255, 110, 112, 121)
    }
private val secondPaint: Paint =
    Paint().also {
      it.isAntiAlias = false
      it.color = Color.makeARGB(255, 224, 230, 241)
    }

internal fun XAxis.draw(index: Int, rect: Rect, canvas: Canvas, option: Option) {
  val gridRect = option.grids[gridIndex].getRect(rect)

  if (axisLine.show) {
    when (position) {
      XAxisPosition.TOP ->
          canvas.drawLine(gridRect.left, gridRect.top, gridRect.right, gridRect.top, primaryPaint)
      XAxisPosition.BOTTOM ->
          canvas.drawLine(
              gridRect.left, gridRect.bottom, gridRect.right, gridRect.bottom, primaryPaint)
    }
  }
}

internal fun YAxis.draw(index: Int, rect: Rect, canvas: Canvas, option: Option) {
  val gridRect = option.grids[gridIndex].getRect(rect)

  // draw axis line, https://echarts.apache.org/zh/option.html#xAxis.axisLine
  if (axisLine.show) {
    when (position) {
      YAxisPosition.LEFT ->
          canvas.drawLine(gridRect.left, gridRect.top, gridRect.left, gridRect.bottom, primaryPaint)
      YAxisPosition.RIGHT ->
          canvas.drawLine(
              gridRect.right, gridRect.top, gridRect.right, gridRect.bottom, primaryPaint)
    }
  }
}
