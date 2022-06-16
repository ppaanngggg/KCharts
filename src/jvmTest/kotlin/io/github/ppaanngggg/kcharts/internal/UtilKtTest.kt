package io.github.ppaanngggg.kcharts.internal

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class UtilKtTest {

  @Test
  fun testAutoInterval() {
    assertEquals(1.0f, autoInterval(0.0f))
    assertEquals(0.2f, autoInterval(1.0f))
    assertEquals(0.2f, autoInterval(1.1f))
    assertEquals(0.3f, autoInterval(1.3f))
    assertEquals(0.03f, autoInterval(0.16f))
    assertEquals(2.0f, autoInterval(9.1f))
    assertEquals(20f, autoInterval(99f))
    assertEquals(2.0f, autoInterval(-9.7f))
  }

  @Test
  fun testAutoMinMaxInterval() {
    assertEquals(Triple(0f, 1f, 1f), autoMinMaxInterval(listOf()))
    assertEquals(Triple(0f, 1f, 1f), autoMinMaxInterval(listOf(0f, 0f)))
    assertEquals(Triple(-10f, 0f, 2f), autoMinMaxInterval(listOf(-9.9, -1.2)))
    assertEquals(Triple(-10f, 0f, 2f), autoMinMaxInterval(listOf(-10, -0)))
    assertEquals(Triple(0f, 10f, 2f), autoMinMaxInterval(listOf(9.9, 1.2)))
    assertEquals(Triple(0f, 10f, 2f), autoMinMaxInterval(listOf(10, -0)))
    assertEquals(Triple(-2f, 10f, 2f), autoMinMaxInterval(listOf(-1.2, 9.9)))
    assertEquals(Triple(-10f, 2f, 2f), autoMinMaxInterval(listOf(1.2, -9.9)))
    assertEquals(Triple(-10f, 2f, 2f), autoMinMaxInterval(listOf(2, -10)))
    assertEquals(Triple(-2f, 10f, 2f), autoMinMaxInterval(listOf(-2, 10)))
  }

  @Test
  fun testAnyFloat() {
    var any: Any

    any = "1.2"
    assertEquals(1.2f, any.float())
    any = 1L
    assertEquals(1f, any.float())
    any = 1.2
    assertEquals(1.2f, any.float())
    any = emptyList<Int>()
    assertFails { any.float() }
  }
}
