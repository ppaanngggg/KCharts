package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.*
import kotlin.test.BeforeTest
import kotlin.test.assertTrue

abstract class BaseTest {
  val width = 400
  val height = 300
  lateinit var bitmap: Bitmap
  lateinit var canvas: Canvas

  @BeforeTest
  fun init() {
    bitmap = Bitmap()
    assertTrue {
      bitmap.allocPixels(ImageInfo(width, height, ColorType.RGBA_8888, ColorAlphaType.UNPREMUL))
    }
    canvas = Canvas(bitmap)
  }
}
