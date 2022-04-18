package io.github.ppaanngggg.kcharts

enum class AxisType {
  VALUE,
  CATEGORY,
  TIME,
  LOG,
}

data class AxisLine(val show: Boolean)

data class SplitLine(val show: Boolean)

enum class XAxisPosition {
  TOP,
  BOTTOM,
}

/** [xAxis](https://echarts.apache.org/zh/option.html#xAxis) */
data class XAxis(
    val type: AxisType = AxisType.CATEGORY,
    val gridIndex: Int = 0,
    val position: XAxisPosition = XAxisPosition.BOTTOM,
    val axisLine: AxisLine = AxisLine(true),
    val splitLine: SplitLine = SplitLine(false),
)

enum class YAxisPosition {
  LEFT,
  RIGHT,
}

/** [yAxis](https://echarts.apache.org/zh/option.html#yAxis) */
data class YAxis(
    val type: AxisType = AxisType.VALUE,
    val gridIndex: Int = 0,
    val position: YAxisPosition = YAxisPosition.LEFT,
    val axisLine: AxisLine = AxisLine(false),
    val splitLine: SplitLine = SplitLine(true),
)
