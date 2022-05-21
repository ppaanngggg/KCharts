package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Option
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Rect

fun Option.getValuesOnXAxis(xAxisIndex: Int): List<Any> {
  val values = mutableListOf<Any>()
  series
      .filter { it.xAxisIndex == xAxisIndex }
      .forEach { s ->
        val dataset = datasets[s.datasetIndex]
        s.encode.x.forEach { values.addAll(dataset.getColumn(it)) }
      }
  return values
}

fun Option.getValuesOnYAxis(yAxisIndex: Int): List<Any> {
  val values = mutableListOf<Any>()
  series
      .filter { it.yAxisIndex == yAxisIndex }
      .forEach { s ->
        val dataset = datasets[s.datasetIndex]
        s.encode.y.forEach { values.addAll(dataset.getColumn(it)) }
      }
  return values
}

fun Option.draw(rect: Rect, canvas: Canvas) {
  val gridRects = this.grids.map { it.getRect(rect) }

  this.xAxis.mapIndexed { index, xAxis ->
    xAxis.draw(getValuesOnXAxis(index), gridRects[xAxis.gridIndex], canvas)
  }
  this.yAxis.mapIndexed { index, yAxis ->
    yAxis.draw(getValuesOnYAxis(index), gridRects[yAxis.gridIndex], canvas)
  }
}
