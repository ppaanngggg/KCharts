package io.github.ppaanngggg.kcharts.option

data class LineSeries(
    val xAxisIndex: Int = 0,
    val yAxisIndex: Int = 0,
    val datasetIndex: Int = 0,
) : Series(SeriesType.LINE)
