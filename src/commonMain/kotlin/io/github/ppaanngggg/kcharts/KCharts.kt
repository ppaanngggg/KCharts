package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.option.Option
import org.jetbrains.skia.Canvas

class KCharts(
    val width: Int,
    val height: Int,
    val canvas: Canvas,
) {
  fun draw(option: Option) {
    println(canvas)
  }
}
