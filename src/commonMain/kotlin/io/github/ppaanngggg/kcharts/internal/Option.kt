package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Option
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Rect

fun Option.draw(rect: Rect, canvas: Canvas) {
  this.xAxis.forEachIndexed { index, xAxis -> xAxis.draw(index, rect, canvas, this) }
  this.yAxis.forEachIndexed { index, yAxis -> yAxis.draw(index, rect, canvas, this) }
}
