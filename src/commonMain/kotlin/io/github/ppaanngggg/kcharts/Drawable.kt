package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

interface Drawable {
  fun draw(width: Float, height: Float, canvas: Canvas, option: Option)
}
