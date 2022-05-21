package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.*
import org.jetbrains.skia.*

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

internal fun XAxis.draw(values: List<Any>, rect: Rect, canvas: Canvas, option: Option) {
  val y =
      when (position) {
        XAxisPosition.TOP -> rect.top
        XAxisPosition.BOTTOM -> rect.bottom
      }

  if (axisLine.show) {
    canvas.drawLine(rect.left, y, rect.right, y, primaryPaint)
  }

  when (type) {
    AxisType.CATEGORY -> {
      // remove duplicated values
      val categories = values.distinct()
      if (axisLine.show) {
        var start = rect.left
        canvas.drawLine(start, y, start, y + 5, primaryPaint)
        val interval = rect.width / values.size
        for (category in categories) {
          val textLine = TextLine.Companion.make(category.toString(), Font())
          canvas.drawTextLine(
              textLine, start + (interval - textLine.height) / 2, y + textLine.height, primaryPaint)
          start += interval
          canvas.drawLine(start, y, start, y + 5, primaryPaint)
        }
      }
    }
    AxisType.VALUE -> {}
    else -> {
      throw NotImplementedError(type.toString())
    }
  }
}

internal fun YAxis.draw(values: List<Any>, rect: Rect, canvas: Canvas, option: Option) {
  val x =
      when (position) {
        YAxisPosition.LEFT -> rect.left
        YAxisPosition.RIGHT -> rect.right
      }

  if (axisLine.show) {
    canvas.drawLine(x, rect.top, x, rect.bottom, primaryPaint)
  }
}
