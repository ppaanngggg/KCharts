package io.github.ppaanngggg.kcharts.internal

class BBox(
    val lt: Point, // left top point of bounding box
    val rb: Point, // right bottom point of bounding box
) {
  val left = lt.x
  val top = lt.y
  val right = rb.x
  val bottom = rb.y
  val width: Float = right - left
  val height: Float = bottom - top
}
