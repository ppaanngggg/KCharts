package io.github.ppaanngggg.kcharts.internal

import kotlin.math.*

/**
 * find adaptive interval for max value
 * @param value: max value, can be negative
 * @param bin: number of intervals, keep around `bin`, not exactly `bin`
 * @return: adaptive interval
 */
fun autoInterval(value: Float, bin: UInt = 5u): Float {
  var base = value / bin.toFloat()
  if (base == 0f) {
    return 1f
  }
  if (base < 0f) {
    base = -base
  }
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

/**
 * find adaptive min, max and interval for a series values
 * @param values: values used to plot
 * @return: triple of `min`, `max` and `interval`
 */
fun autoMinMaxInterval(values: List<Any>): Triple<Float, Float, Float> {
  if (values.isEmpty()) {
    return Triple(0f, 1f, 1f)
  }
  val numbers = values.map { it.float() }
  val min = numbers.minOrNull()!!
  val max = numbers.maxOrNull()!!

  if (min == 0f && max == 0f) {
    return Triple(0f, 1f, 1f)
  }

  // all values lte 0
  if (max <= 0) {
    val interval = autoInterval(min)
    return Triple(floor(min / interval) * interval, 0f, interval)
  }

  // all values gte 0
  if (min >= 0) {
    val interval = autoInterval(max)
    return Triple(0f, ceil(max / interval) * interval, interval)
  }

  // some lt 0 and some gt 0
  val interval = max(autoInterval(min), autoInterval(max))
  return Triple(floor(min / interval) * interval, ceil(max / interval) * interval, interval)
}

/**
 * force turn `Any` to `Float`
 * @return: float from str or number type
 * @exception: not implemented error with string of `Any`
 */
fun Any.float(): Float =
    when (this) {
      is String -> this.toFloat()
      is Number -> this.toFloat()
      else -> throw NotImplementedError(this.toString())
    }
