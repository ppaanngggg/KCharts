package io.github.ppaanngggg.kcharts.internal

import kotlin.math.pow
import kotlin.math.round

fun autoInterval(value: Float): Float {
  var base = value / 5
  var exp = 0
  while (base > 10) {
    base /= 10
    exp += 1
  }
  while (base < 1) {
    base *= 10
    exp -= 1
  }
  return round(base) * 10f.pow(exp)
}

fun Any.float(): Float =
    when (this) {
      is String -> this.toFloat()
      is Number -> this.toFloat()
      else -> throw NotImplementedError(this.toString())
    }
