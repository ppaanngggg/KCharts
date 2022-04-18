package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.internal.draw
import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Image
import org.jetbrains.skia.Rect

/**
 * draw option on canvas
 *
 * @param option: [Option], user define option to draw
 * @param rect: [Rect], where to draw on canvas
 */
fun Canvas.drawOption(option: Option, rect: Rect) {
  option.draw(rect, this)
}
