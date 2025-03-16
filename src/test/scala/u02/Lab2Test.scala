package u02

import org.junit.Test
import org.junit.Assert.*

class Lab2Test:
  @Test def task3a() =
    assertEquals("positive", Lab2.positive(3))
    assertEquals("negative", Lab2.positive(-2))
    assertEquals("positive", Lab2.positive2(3))
    assertEquals("negative", Lab2.positive2(-2))


  @Test def task3b() =
    val empty: String => Boolean = _ == ""
    val notEmpty = Lab2.neg(empty)
    val notEmpty2 = Lab2.neg2(empty)
    assertTrue(notEmpty("hello"))
    assertTrue(notEmpty2("hello"))
    assertFalse(notEmpty(""))
    assertFalse(notEmpty2(""))


  @Test def task3c() =
    val pos: Int => Boolean = _ >= 0
    val neg = Lab2.genericNeg(pos)
    assertTrue(neg(-2))

  @Test def task4() =
    assertTrue(Lab2.p2(2, 3, 3))
    assertFalse(Lab2.p2(3, 3, 4))
    assertTrue(Lab2.p1(2)( 3, 3))
    assertFalse(Lab2.p1(3)(3, 4))
    assertTrue(Lab2.p3(2)(3)(3))
    assertFalse(Lab2.p3(3)(3)(4))

  @Test def task5() =
    assertEquals(9, Lab2.compose(_-1, _*2)(5))
    assertEquals("10", Lab2.genericCompose(_.toString, (x: Int) => x*2)(5))

  @Test def task6() =
    assertEquals("6!", Lab2.composeThree((x: String) => x+"!", _.toString, (x: Int) => x*2)(3))

  @Test def task7() =
   assertEquals(8 , Lab2.power(2, 3))