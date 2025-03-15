package u02

import org.junit.Test
import org.junit.Assert.*

class Lab2Test:
  @Test def task2a() =
    assertEquals("positive", Lab2.positive(3))
    assertEquals("negative", Lab2.positive(-2))
    assertEquals("positive", Lab2.positive2(3))
    assertEquals("negative", Lab2.positive2(-2))


  @Test def task2b() =
    val empty: String => Boolean = _ == ""
    val notEmpty = Lab2.neg(empty)
    val notEmpty2 = Lab2.neg2(empty)
    assertTrue(notEmpty("hello"))
    assertTrue(notEmpty2("hello"))
    assertFalse(notEmpty(""))
    assertFalse(notEmpty2(""))


  @Test def task2c() =
    val pos: Int => Boolean = _ >= 0
    val neg = Lab2.genericNeg(pos)
    assertTrue(neg(-2))

