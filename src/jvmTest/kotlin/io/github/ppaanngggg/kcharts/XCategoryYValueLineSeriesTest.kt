package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Color
import org.jetbrains.skia.Image
import org.jetbrains.skia.Rect
import java.io.File
import kotlin.test.Test

class XCategoryYValueLineSeriesTest : BaseTest() {
  @Test
  fun draw() {
    canvas.clear(Color.WHITE)
    val option =
        Option()
            .grid(Grid())
            .xAxis(XAxis(AxisType.CATEGORY))
            .yAxis(YAxis(AxisType.VALUE, axisLine = AxisLine(true)))
            .dataset(
                Dataset()
                    .dimension("category")
                    .dimension("value1")
                    .dimension("value2")
                    .source(
                        listOf(
                            listOf("cat1", 1, 1.2), listOf("cat2", 2.1, 0.2), listOf("cat3", 1, 0.8)),
                    ))
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("category"), y = listOf("value1"))))
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("category"), y = listOf("value2"))))
    canvas.drawOption(option, Rect(0f, 0f, width.toFloat(), height.toFloat()))

    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply {
      File("images/drawXCategoryYValueLineSeries.png").writeBytes(this)
    }
  }
}
