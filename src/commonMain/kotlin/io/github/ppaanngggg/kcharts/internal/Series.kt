package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Dataset
import io.github.ppaanngggg.kcharts.Series
import io.github.ppaanngggg.kcharts.SeriesType
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Color
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Point

private val paintBucket =
    object {
      var idx = -1
      val paints =
          arrayOf(
              Paint().also { it.color = Color.makeARGB(255, 116, 139, 209) },
              Paint().also { it.color = Color.makeARGB(255, 145, 204, 117) },
              Paint().also { it.color = Color.makeARGB(255, 250, 200, 88) },
              Paint().also { it.color = Color.makeARGB(255, 238, 102, 102) },
              Paint().also { it.color = Color.makeARGB(255, 115, 192, 222) },
          )

      fun pop(): Paint {
        idx += 1
        return paints[idx % paints.size]
      }
    }

fun Series.draw(xfun: (Any) -> Float?, yfun: (Any) -> Float?, dataset: Dataset, canvas: Canvas) {
  for (xDim in encode.x) {
    for (yDim in encode.y) {
      val xArr = dataset.getColumn(xDim)
      val yArr = dataset.getColumn(yDim)
      val points = Array(xArr.size) { i -> Point(xfun(xArr[i])!!, yfun(yArr[i])!!) }

      when (type) {
        SeriesType.LINE -> canvas.drawPolygon(points, paintBucket.pop())
      }
    }
  }
}
