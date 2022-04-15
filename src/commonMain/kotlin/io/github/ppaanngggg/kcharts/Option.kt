package io.github.ppaanngggg.kcharts

import org.jetbrains.skia.Canvas

/**
 * refer from [ECharts](https://echarts.apache.org/zh/option.html), use [Option] to define how to
 * draw the chart, but there are some differences.
 * 1. less flexable, try best to use the full data struct from the beginning to avoid breaking
 * change in the future;
 * 2. more builder, use builder functions to simplify usage;
 */
class Option {
  val grids: List<Grid> = emptyList()
  val xAxis: List<XAxis> = emptyList()
  val yAxis: List<YAxis> = emptyList()
  val datasets: List<Dataset> = emptyList()
  val series: List<Series> = emptyList()

  fun grid(grid: Grid): Option = copy(grids = this.grids + grid)
  fun xAxis(xAxis: XAxis): Option = copy(xAxis = this.xAxis + xAxis)
  fun yAxis(axis: YAxis): Option = copy(yAxis = this.yAxis + axis)
  fun dataset(dataset: Dataset): Option = copy(datasets = this.datasets + dataset)
  fun series(series: Series): Option = copy(series = this.series + series)

  private fun validate() {
    check(grids.isNotEmpty())
    check(xAxis.isNotEmpty())
    check(yAxis.isNotEmpty())
    check(datasets.isNotEmpty())
    check(series.isNotEmpty())
  }

  /**
   * @param width the max width of canvas
   * @param height the max height of canvas
   * @param canvas where to draw
   */
  fun draw(width: Float, height: Float, canvas: Canvas) {
    validate()

    xAxis.forEach { it.draw(width, height, canvas, this) }
    yAxis.forEach { it.draw(width, height, canvas, this) }
  }
}
