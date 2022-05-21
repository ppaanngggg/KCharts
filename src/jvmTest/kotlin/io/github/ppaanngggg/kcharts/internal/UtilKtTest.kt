package io.github.ppaanngggg.kcharts.internal

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class UtilKtTest {

  @Test
  fun testAutoInterval() {
    assertEquals(0.2f, autoInterval(1.0f))
    assertEquals(0.2f, autoInterval(1.1f))
    assertEquals(0.3f, autoInterval(1.3f))
    assertEquals(0.03f, autoInterval(0.16f))
    assertEquals(2.0f, autoInterval(9.1f))
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
