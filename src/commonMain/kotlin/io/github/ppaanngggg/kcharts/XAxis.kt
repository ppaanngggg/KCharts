package io.github.ppaanngggg.kcharts

enum class XAxisPosition {
  TOP,
  BOTTOM,
}

class XAxis(
    type: AxisType,
    gridIndex: Int = 0,
    val position: XAxisPosition = XAxisPosition.TOP,
) : Axis(type = type, gridIndex = gridIndex)
