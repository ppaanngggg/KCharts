**lets-plot-koltin now support skia backend**, refer to https://github.com/JetBrains/lets-plot-kotlin

# KCharts

Kotlin charts library, based on [skiko](https://github.com/JetBrains/skiko), using `Option`
as [ECharts](https://echarts.apache.org/zh/option.html)

## Purpose

Want to draw Charts in [compose-jb](https://github.com/JetBrains/compose-jb)

```kotlin
val option = Option()
Canvas(modifier = Modifier.fillMaxSize()) {
  val size = this.drawContext.size
  val canvas = this.drawContext.canvas.nativeCanvas
  option.draw(Rect.Companion.makeWH(size.width, size.height), canvas)
}
```

## Pre-Alpha Usage

1. push to maven local
2. import from maven local in your own project

## Examples

[Category XAxis and Line Series](./src/jvmTest/kotlin/io/github/ppaanngggg/kcharts/XCategoryYValueLineSeriesTest.kt)

![](./images/drawXCategoryYValueLineSeries.png)

[Value XAxis and Line Series](./src/jvmTest/kotlin/io/github/ppaanngggg/kcharts/XValueYValueLineSeriesTest.kt)

![](./images/drawXValueYValueLineSeries.png)
