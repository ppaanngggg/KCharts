package io.github.ppaanngggg.kcharts

data class Dimension(val name: String)

data class Dataset(
  val dimensions: List<Dimension> = emptyList(),
  val source: List<List<Any>> = emptyList()
) {
  fun dimension(name: String): Dataset = copy(dimensions = dimensions + Dimension(name = name))
  @JvmName("sourceList")
  fun source(row: List<Any>): Dataset = copy(source = source + listOf(row))
  @JvmName("sourceListList")
  fun source(rows: List<List<Any>>): Dataset = copy(source = source + rows)
}
