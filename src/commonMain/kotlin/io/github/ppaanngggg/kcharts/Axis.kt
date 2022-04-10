package io.github.ppaanngggg.kcharts

enum class AxisType {
  VALUE,
  CATEGORY,
  TIME,
  LOG,
}

abstract class Axis(
    val type: AxisType,
    val gridIndex: Int = 0,
)
