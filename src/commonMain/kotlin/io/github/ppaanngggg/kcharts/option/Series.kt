package io.github.ppaanngggg.kcharts.option

enum class SeriesType {
  LINE,
  BAR,
  SCATTER,
}

abstract class Series(
    val type: SeriesType,
)
