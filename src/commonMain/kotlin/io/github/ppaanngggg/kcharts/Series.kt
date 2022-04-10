package io.github.ppaanngggg.kcharts

enum class SeriesType {
  LINE,
  BAR,
  SCATTER,
}

abstract class Series(
  val type: SeriesType,
)
