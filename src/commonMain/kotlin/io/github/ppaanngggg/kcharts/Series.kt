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

data class Series(
    val type: SeriesType,
    val xAxisIndex: Int = 0,
    val yAxisIndex: Int = 0,
    val datasetIndex: Int = 0,
    val encode: Encode,
    val color: Int? = null,
)
