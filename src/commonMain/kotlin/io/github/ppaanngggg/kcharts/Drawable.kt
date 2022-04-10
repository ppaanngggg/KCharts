package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

interface Drawable {
  fun draw(width: Int, height: Int, canvas: Canvas, option: Option)
}
