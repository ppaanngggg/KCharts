package option

enum class SeriesType {
  LINE,
  BAR,
  SCATTER,
}

abstract class Series(
    val type: SeriesType,
)
