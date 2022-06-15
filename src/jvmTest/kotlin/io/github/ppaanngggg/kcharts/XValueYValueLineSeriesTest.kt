package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Color
import org.jetbrains.skia.Image
import org.jetbrains.skia.Rect
import java.io.File
import kotlin.test.Test

class XValueYValueLineSeriesTest : BaseTest() {
  @Test
  fun draw() {
    canvas.clear(Color.WHITE)
    val option =
        Option()
            .grid(Grid())
            .xAxis(XAxis(AxisType.VALUE, splitLine = SplitLine(true)))
            .yAxis(YAxis(AxisType.VALUE, axisLine = AxisLine(true)))
            .dataset(
                Dataset()
                    .dimension("second")
                    .dimension("value1")
                    .dimension("value2")
                    .source(
                        listOf(
                            listOf(1, 1, 1.2),
                            listOf(2, 2, 0.2),
                            listOf(4, 1, 0.8),
                            listOf(5, 1.1, 0.6),
                        ),
                    ))
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("second"), y = listOf("value1"))))
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("second"), y = listOf("value2"))))
    canvas.drawOption(option, Rect(0f, 0f, width.toFloat(), height.toFloat()))

    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply {
      File("images/drawXValueYValueLineSeries.png").writeBytes(this)
    }
  }
}
