package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.option.*
import org.jetbrains.skia.*
import java.io.File
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class CanvasKtTest {

  private val width = 120
  private val height = 80
  private lateinit var bitmap: Bitmap
  private lateinit var canvas: Canvas

  @BeforeTest
  fun init() {
    bitmap = Bitmap()
    assertTrue {
      bitmap.allocPixels(ImageInfo(width, height, ColorType.RGBA_8888, ColorAlphaType.UNPREMUL))
    }
    canvas = Canvas(bitmap)
  }

  @Test
  fun drawXCategoryYValueOneLineSeries() {
    canvas.clear(Color.WHITE)
    canvas.draw(
        width = this.width,
        height = this.height,
        option =
            Option()
                .xAxis(Axis(AxisType.CATEGORY))
                .yAxis(Axis(AxisType.VALUE))
                .dataset(
                    Dataset()
                        .dimension("category")
                        .dimension("value")
                        .source(
                            listOf(listOf("cat1", 1), listOf("cat2", 2)),
                        ),
                )
                .series(LineSeries()),
    )
    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply {
      File("images/drawXCategoryYValueOneLineSeries.png").writeBytes(this)
    }
  }
}
