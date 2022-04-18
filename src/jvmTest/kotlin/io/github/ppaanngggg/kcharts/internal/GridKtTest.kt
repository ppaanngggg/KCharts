package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Grid
import org.jetbrains.skia.Rect
import kotlin.test.Test
import kotlin.test.assertEquals

internal class GridKtTest {

  @Test
  fun getRect() {
    val rect = Grid().getRect(Rect(10f, 20f, 110f, 220f))
    assertEquals(20f, rect.left)
    assertEquals(40f, rect.top)
    assertEquals(100f, rect.right)
    assertEquals(200f, rect.bottom)
  }
}
