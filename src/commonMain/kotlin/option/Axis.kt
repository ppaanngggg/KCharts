package option

enum class AxisType {
  VALUE,
  CATEGORY,
  TIME,
  LOG,
}

data class Axis(
    val type: AxisType,
)
