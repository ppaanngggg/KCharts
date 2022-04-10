package io.github.ppaanngggg.kcharts

enum class YAxisPosition {
  LEFT,
  RIGHT,
}

/**
 * [yAxis](https://echarts.apache.org/zh/option.html#yAxis)
 */
class YAxis(
    type: AxisType,
    gridIndex: Int = 0,
    val position: YAxisPosition = YAxisPosition.LEFT,
) : Axis(type = type, gridIndex = gridIndex)
