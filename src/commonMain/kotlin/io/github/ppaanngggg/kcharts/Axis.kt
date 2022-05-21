package io.github.ppaanngggg.kcharts

enum class AxisType {
  VALUE,
  CATEGORY,
  TIME,
  LOG,
}

/**
 * [AxisLine] defines the axis line draw config
 * [ref](https://echarts.apache.org/zh/option.html#xAxis.axisLine)
 *
 * @param show: whether to show
 */
data class AxisLine(val show: Boolean)

/**
 * [SplitLine] defines the split line draw config
 * [ref](https://echarts.apache.org/zh/option.html#xAxis.splitArea)
 *
 * @param show: whether to show
 */
data class SplitLine(val show: Boolean)

enum class XAxisPosition {
  TOP,
  BOTTOM,
}

/**
 * [XAxis] defines the x-axis of a plot [ref](https://echarts.apache.org/zh/option.html#xAxis)
 *
 * @param type: axis data type
 * @param gridIndex: which grid to set this axis
 * @param position: draw on top or bottom of plot
 * @param axisLine: how to draw axis line
 * @param splitLine: how to draw split line
 */
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

/**
 * [YAxis] defines the y-axis of a plot [ref](https://echarts.apache.org/zh/option.html#yAxis)
 *
 * @param type: axis data type
 * @param gridIndex: which grid to set this axis
 * @param position: draw on left or right of plot
 * @param axisLine: how to draw axis line
 * @param splitLine: how to draw split line
 */
data class YAxis(
    val type: AxisType = AxisType.VALUE,
    val gridIndex: Int = 0,
    val position: YAxisPosition = YAxisPosition.LEFT,
    val axisLine: AxisLine = AxisLine(false),
    val splitLine: SplitLine = SplitLine(true),
)
