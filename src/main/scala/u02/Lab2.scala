package u02

import u02.Lab2.neg

object Lab2 extends App {
  //Task 1
  println("Hello, Scala!")

  //Task 2
  //a (ii)
  def positive(x: Int): String =
    val res = x match
      case n if n >= 0 => "positive"
      case _ => "negative"
    res


  //a (i)
  val positive2: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  //b
  def neg(pred: String => Boolean): (String => Boolean) =
    x => !pred(x)

  val neg2: (String => Boolean) => (String => Boolean) =
    g => (a => !g(a))
  

  //c
  def genericNeg[A](pred: A => Boolean): (A => Boolean) =
    x => !pred(x)

  val genericNeg2: [B] => (B => Boolean) => (B => Boolean) =
    [B] => (a: B => Boolean) => (b: B) => !a(b)
    
  
}