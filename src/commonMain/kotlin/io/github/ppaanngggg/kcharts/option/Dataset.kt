package io.github.ppaanngggg.kcharts.option

data class Dimension(val name: String)

data class Dataset(
    val dimensions: List<Dimension> = emptyList(),
    val source: List<List<Any>> = emptyList()
) {
  fun dimension(name: String): Dataset = copy(dimensions = dimensions + Dimension(name = name))
  fun source(row: List<Any>): Dataset {
    val mutable = source.toMutableList()
    mutable.add(row)
    return copy(source = mutable)
  }
}
