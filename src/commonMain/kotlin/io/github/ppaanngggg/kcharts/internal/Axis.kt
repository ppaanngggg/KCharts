package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.*
import org.jetbrains.skia.*
import kotlin.math.round

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
private val textPaint: Paint = Paint().also { it.color = Color.makeARGB(255, 110, 112, 121) }

internal fun XAxis.draw(values: List<Any>, rect: Rect, canvas: Canvas): (Any) -> Float? {
  val y =
      when (position) {
        XAxisPosition.TOP -> rect.top
        XAxisPosition.BOTTOM -> rect.bottom
      }

  val func: (Any) -> Float?
  when (type) {
    AxisType.CATEGORY -> {
      // remove duplicated values
      val categories = values.distinct()
      // map from category to location
      val m = mutableMapOf<Any, Float>()

      if (axisLine.show) {
        canvas.drawLine(rect.left, y, rect.left, y + 5, primaryPaint)
      }
      val interval = rect.width / categories.size
      categories.forEachIndexed { index, any ->
        m[any] = rect.left + (index + 0.5f) * interval
        if (axisLine.show) {
          val textLine = TextLine.Companion.make(any.toString(), Font())
          canvas.drawTextLine(
              textLine,
              rect.left + index * interval + (interval - textLine.height) / 2,
              y + textLine.height,
              textPaint)
          canvas.drawLine(
              rect.left + (1 + index) * interval,
              y,
              rect.left + (1 + index) * interval,
              y + 5,
              primaryPaint)
        }
      }
      func = { m[it] }
    }
    AxisType.VALUE -> {
      val triple = autoMinMaxInterval(values)
      val numMin = triple.first
      val numMax = triple.second
      val numInterval = triple.third
      val slot = round((numMax - numMin) / numInterval).toInt()

      val interval = rect.width / slot
      for (i in 0..slot) {
        val x = rect.left + i * interval
        if (axisLine.show) {
          canvas.drawLine(x, y, x, y + 5, primaryPaint)
          val textLine =
              TextLine.Companion.make(
                  (numMin.toBigDecimal() + numInterval.toBigDecimal() * i.toBigDecimal())
                      .toString(),
                  Font(),
              )
          canvas.drawTextLine(textLine, x - textLine.width / 2, y + 5 + textLine.height, textPaint)
        }
        if (splitLine.show && i > 0) {
          canvas.drawLine(x, rect.top, x, rect.bottom, secondPaint)
        }
      }
      func = { (it.float() - numMin) / (numMax - numMin) * rect.width + rect.left }
    }
    else -> {
      throw NotImplementedError(type.toString())
    }
  }

  if (axisLine.show) {
    canvas.drawLine(rect.left, y, rect.right, y, primaryPaint)
  }
  return func
}

internal fun YAxis.draw(values: List<Any>, rect: Rect, canvas: Canvas): (Any) -> Float? {
  val x =
      when (position) {
        YAxisPosition.LEFT -> rect.left
        YAxisPosition.RIGHT -> rect.right
      }

  val func: (Any) -> Float?
  when (type) {
    AxisType.VALUE -> {
      val triple = autoMinMaxInterval(values)
      val numMin = triple.first
      val numMax = triple.second
      val numInterval = triple.third
      val slot = round((numMax - numMin) / numInterval).toInt()

      val interval = rect.height / slot
      for (i in 0..slot) {
        val y = rect.bottom - i * interval
        if (axisLine.show) {
          canvas.drawLine(x - 5, y, x, y, primaryPaint)
          val textLine =
              TextLine.Companion.make(
                  (numMin.toBigDecimal() + numInterval.toBigDecimal() * i.toBigDecimal())
                      .toString(),
                  Font(),
              )
          canvas.drawTextLine(textLine, x - 5 - textLine.width, y + textLine.height / 2, textPaint)
        }
        if (splitLine.show && i > 0) {
          canvas.drawLine(rect.left, y, rect.right, y, secondPaint)
        }
      }
      func = { rect.bottom - (it.float() - numMin) / (numMax - numMin) * rect.height }
    }
    else -> {
      throw NotImplementedError(type.toString())
    }
  }

  if (axisLine.show) {
    canvas.drawLine(x, rect.top, x, rect.bottom, primaryPaint)
  }
  return func
}
