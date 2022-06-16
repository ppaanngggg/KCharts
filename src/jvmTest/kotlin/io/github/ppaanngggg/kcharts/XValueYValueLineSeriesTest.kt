package io.github.ppaanngggg.kcharts

import java.io.File
import kotlin.test.Test
import org.jetbrains.skia.Color
import org.jetbrains.skia.Image
import org.jetbrains.skia.Rect

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
                    .dimension("value3")
                    .source(
                        listOf(
                            listOf(-0.1, 1, 1.2, 0.1),
                            listOf(1.1, 1, 1.2, 0.1),
                            listOf(2, 2, -0.2, 0.3),
                            listOf(3.9, 1, 0.8, 0.9),
                            listOf(5, 1.1, 0.6, -1.2),
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
            .series(
                Series(
                    type = SeriesType.LINE,
                    encode = Encode(x = listOf("second"), y = listOf("value3"))))
    canvas.drawOption(option, Rect(0f, 0f, width.toFloat(), height.toFloat()))

    Image.makeFromBitmap(bitmap).encodeToData()!!.bytes.apply {
      File("images/drawXValueYValueLineSeries.png").writeBytes(this)
    }
  }
}
