package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.*
import java.io.File
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class OptionKtTest {

  private val width = 400
  private val height = 300
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
    val option =
        Option()
            .grid(Grid())
            .xAxis(XAxis(AxisType.CATEGORY))
            .yAxis(YAxis(AxisType.VALUE, axisLine = AxisLine(true)))
            .dataset(
                Dataset()
                    .dimension("category")
                    .dimension("value")
                    .source(
                        listOf(listOf("cat1", 1), listOf("cat2", 2), listOf("cat3", 1)),
                    ))
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("category"), y = listOf("value"))))
    canvas.drawOption(option, Rect(0f, 0f, width.toFloat(), height.toFloat()))

    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply {
      File("images/drawXCategoryYValueOneLineSeries.png").writeBytes(this)
    }
  }
}
