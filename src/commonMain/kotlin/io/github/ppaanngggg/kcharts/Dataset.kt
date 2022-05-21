package io.github.ppaanngggg.kcharts

/**
 * [Dimension] defines the column of dataset
 * [ref](https://echarts.apache.org/zh/option.html#dataset.dimensions)
 *
 * @param name: name of column
 */
data class Dimension(val name: String)

/**
 * [Dataset] defines the data to show [ref](https://echarts.apache.org/zh/option.html#dataset)
 *
 * @param dimensions: column definitions of this dataset
 * @param source: 2-D table of data
 */
data class Dataset(
    val dimensions: List<Dimension> = emptyList(),
    val source: List<List<Any>> = emptyList()
) {
  fun dimension(name: String): Dataset = copy(dimensions = dimensions + Dimension(name = name))
  @JvmName("sourceList") fun source(row: List<Any>): Dataset = copy(source = source + listOf(row))
  @JvmName("sourceListList")
  fun source(rows: List<List<Any>>): Dataset = copy(source = source + rows)
}
