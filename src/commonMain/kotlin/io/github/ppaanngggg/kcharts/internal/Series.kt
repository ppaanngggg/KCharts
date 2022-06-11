package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Dataset
import io.github.ppaanngggg.kcharts.Series
import io.github.ppaanngggg.kcharts.SeriesType
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Point

fun Series.draw(xfun: (Any) -> Float?, yfun: (Any) -> Float?, dataset: Dataset, canvas: Canvas) {
  for (xDim in encode.x) {
    for (yDim in encode.y) {
      val xArr = dataset.getColumn(xDim)
      val yArr = dataset.getColumn(yDim)
      val points = Array(xArr.size) { i -> Point(xfun(xArr[i])!!, yfun(yArr[i])!!) }

      when (type) {
        SeriesType.LINE -> canvas.drawPolygon(points, Paint().also { it.color = this.color })
        else -> throw NotImplementedError(type.toString())
      }
    }
  }
}
