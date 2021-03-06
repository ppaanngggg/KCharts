package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Color

private val colorBucket =
    object {
      val colors =
          arrayOf(
              Color.makeARGB(255, 116, 139, 209),
              Color.makeARGB(255, 145, 204, 117),
              Color.makeARGB(255, 250, 200, 88),
              Color.makeARGB(255, 238, 102, 102),
              Color.makeARGB(255, 115, 192, 222),
          )

      fun pick(idx: Int): Int = colors[idx % colors.size]
    }

/**
 * refer from [ECharts](https://echarts.apache.org/zh/option.html), use [Option] to define how to
 * draw the chart, but there are some differences.
 * 1. less flexable, try best to use the full data struct from the beginning to avoid breaking
 * change in the future;
 * 2. more builder, use builder functions to simplify usage;
 */
data class Option(
    val grids: List<Grid> = emptyList(),
    val xAxis: List<XAxis> = emptyList(),
    val yAxis: List<YAxis> = emptyList(),
    val datasets: List<Dataset> = emptyList(),
    val series: List<Series> = emptyList(),
) {

  fun grid(grid: Grid): Option = copy(grids = this.grids + grid)
  fun xAxis(xAxis: XAxis): Option = copy(xAxis = this.xAxis + xAxis)
  fun yAxis(axis: YAxis): Option = copy(yAxis = this.yAxis + axis)
  fun dataset(dataset: Dataset): Option = copy(datasets = this.datasets + dataset)
  fun series(series: Series): Option {
    if (series.color == null) {
      // pick a color if series not set
      return copy(
          series = this.series + series.copy(color = colorBucket.pick(this.series.size)),
      )
    }
    return copy(series = this.series + series)
  }

  fun validate() {
    check(grids.isNotEmpty())
    check(xAxis.isNotEmpty())
    check(yAxis.isNotEmpty())
    check(datasets.isNotEmpty())
    check(series.isNotEmpty())
  }
}
