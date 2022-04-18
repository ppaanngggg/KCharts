package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Grid
import org.jetbrains.skia.Rect

/**
 * where this grid on the canvas
 *
 * @param rect: [Rect] of the whole area on canvas
 *
 * @return: [Rect] of this grid on the canvas
 */
fun Grid.getRect(rect: Rect): Rect =
    Rect(
        left = rect.left + rect.width * this.left,
        right = rect.right - rect.width * this.right,
        top = rect.top + rect.height * this.top,
        bottom = rect.bottom - rect.height * this.bottom,
    )
