package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.*
import java.io.File
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class KChartsTest {

  private val width = 100
  private val height = 100
  private lateinit var bitmap: Bitmap
  lateinit var canvas: Canvas

  @BeforeTest
  fun init() {
    bitmap = Bitmap()
    assertTrue {
      bitmap.allocPixels(ImageInfo(width, height, ColorType.RGBA_8888, ColorAlphaType.UNPREMUL))
    }
    canvas = Canvas(bitmap)
  }

  @Test
  fun draw() {
    canvas.drawLine(0f, 0f, 99f, 99f, Paint().setARGB(255, 255, 255, 255))
    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply { File("test.png").writeBytes(this) }
  }
}
