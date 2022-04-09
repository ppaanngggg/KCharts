package io.github.ppaanngggg.kcharts

import io.github.ppaanngggg.kcharts.option.Axis
import io.github.ppaanngggg.kcharts.option.AxisType
import io.github.ppaanngggg.kcharts.option.Dataset
import io.github.ppaanngggg.kcharts.option.Option
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue
import org.jetbrains.skia.*

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
            Option().xAxis(Axis(AxisType.CATEGORY)).yAxis(Axis(AxisType.VALUE)).dataset(Dataset()),
    )
  }
}
