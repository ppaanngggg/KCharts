package io.github.ppaanngggg.kcharts

enum class SeriesType {
  LINE,
  BAR,
  SCATTER,
}

data class Encode(
    val x: List<String>,
    val y: List<String>,
)

data class Series(
    val type: SeriesType,
    val xAxisIndex: Int = 0,
    val yAxisIndex: Int = 0,
    val datasetIndex: Int = 0,
)
