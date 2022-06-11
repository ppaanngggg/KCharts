package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Color

enum class SeriesType {
  LINE,
  BAR,
  SCATTER,
}

/**
 * [Encode] define how to map from [Dataset],
 * [ref](https://echarts.apache.org/zh/option.html#series-line.encode)
 *
 * @param x: which dimensions map to x-axis
 * @param y: which dimensions map to y-axis
 */
data class Encode(
    val x: List<String>,
    val y: List<String>,
)

private val colorBucket =
    object {
      var idx = -1
      val colors =
          arrayOf(
              Color.makeARGB(255, 116, 139, 209),
              Color.makeARGB(255, 145, 204, 117),
              Color.makeARGB(255, 250, 200, 88),
              Color.makeARGB(255, 238, 102, 102),
              Color.makeARGB(255, 115, 192, 222),
          )

      fun pop(): Int {
        idx += 1
        return colors[idx % colors.size]
      }
    }

data class Series(
    val type: SeriesType,
    val xAxisIndex: Int = 0,
    val yAxisIndex: Int = 0,
    val datasetIndex: Int = 0,
    val encode: Encode,
    var color: Int = colorBucket.pop(),
)
