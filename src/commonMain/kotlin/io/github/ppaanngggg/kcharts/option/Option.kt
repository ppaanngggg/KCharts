package io.github.ppaanngggg.kcharts.option

/**
 * refer from [ECharts](https://echarts.apache.org/), use [Option] to define how to draw the chart,
 * but there are some differences.
 * 1. less flexable, try best to use the full data struct from the beginning to avoid breaking
 * change in the future;
 * 2. more builder, use builder functions to simplify usage;
 *
 * [external url] https://echarts.apache.org/zh/option.html
 */
data class Option(
    val xAxis: List<Axis> = emptyList(),
    val yAxis: List<Axis> = emptyList(),
    val dataset: List<Dataset> = emptyList(),
    val series: List<Series> = emptyList(),
) {
  fun xAxis(axis: Axis): Option = copy(xAxis = this.xAxis + axis)
  fun yAxis(axis: Axis): Option = copy(yAxis = this.yAxis + axis)
  fun dataset(dataset: Dataset): Option = copy(dataset = this.dataset + dataset)
  fun series(series: Series): Option = copy(series = this.series + series)
}
