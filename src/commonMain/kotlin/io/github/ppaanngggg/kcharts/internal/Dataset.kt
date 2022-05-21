package io.github.ppaanngggg.kcharts.internal

import io.github.ppaanngggg.kcharts.Dataset

fun Dataset.getColumn(dimension: String): List<Any> {
  val idx = this.dimensions.indexOfFirst { it.name == dimension }
  if (idx == -1) {
    return emptyList()
  }
  val ret = mutableListOf<Any>()
  for (row in this.source) {
    ret.add(row[idx])
  }
  return ret
}
