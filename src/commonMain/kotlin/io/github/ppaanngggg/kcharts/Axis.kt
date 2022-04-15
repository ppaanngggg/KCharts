package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Color
import org.jetbrains.skia.Paint

enum class AxisType {
  VALUE,
  CATEGORY,
  TIME,
  LOG,
}

data class AxisLine(val show: Boolean)

data class SplitLine(val show: Boolean)

abstract class Axis(
    val type: AxisType,
    val gridIndex: Int,
    val axisLine: AxisLine,
    val splitLine: SplitLine,
) : Drawable {

  // index in list, set by option
  var index: Int = 0

  val primaryColor = Color.makeARGB(255, 110, 112, 121)
  val secondColor = Color.makeARGB(255, 224, 230, 241)
  val primaryPaint: Paint = Paint()
  val secondPaint: Paint = Paint()

  init {
    primaryPaint.isAntiAlias = false
    primaryPaint.color = primaryColor

    secondPaint.isAntiAlias = false
    secondPaint.color = secondColor
  }
}
