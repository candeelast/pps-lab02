package u02

import u02.Lab2.Expr.{Add, Literal, Multiply, evaluate, show}
import u02.Lab2.neg

object Lab2 extends App {
  //Task 1
  println("Hello, Scala!")

  //Task 2
  //a
  def positive(x: Int): String =
    val res = x match
      case n if n >= 0 => "positive"
      case _ => "negative"
    res

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
    [B] => (a: B => Boolean) => ((b: B) => !a(b))

//4
    //val & currying
  val p1: Int => (Int, Int) => Boolean = x => (y, z) => x <= y && y == z
    //val & no currying
  val p2: (Int, Int, Int) => Boolean = (x, y ,z) => x <= y && y == z

    //def & currying
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
    //def & no currying
  def p4(x: Int, y: Int, z:Int): Boolean = x <= y && y == z


//5
  def compose(f: Int => Int, g: Int => Int): (Int => Int) =
    x => f(g(x))
  //Constraint: the domain of g and codomain of f must be equal
  def genericCompose[A, B, C](f: B => C, g: A => B) : (A => C) =
  x => f(g(x))

//6
  def composeThree[A,B,C,D](f: C => D, g: B => C, h: A => B): A => D =
    x => f(g(h(x)))


//7
  def power(n: Int, e: Int): Int =
   e match
    case 1 => n
    case 0 => 1
    case _ => n*power(n, e-1)

//8
  def auxiliaryReverse(actual: Int, remains: Int): Int =
    val actual2 = actual.toString + (remains % 10).toString
    val res = remains match
      case n if n > 10 => auxiliaryReverse(actual2.toInt, remains / 10)
      case _ => actual2.toInt
    res

  def reverseNumber(n: Int): Int =
    auxiliaryReverse(n%10, n/10)

//9
enum Expr {
  case Literal(lit: Int)
  case Add(exp1: Expr, exp2: Expr)
  case Multiply(exp1: Expr, exp2: Expr)
}

  object Expr:

    def evaluate(expr: Expr): Int = expr match
      case Literal(value) => value
      case Add(left, right) => evaluate(left) + evaluate(right)
      case Multiply(left, right) => evaluate(left) * evaluate(right)


    def show(expr: Expr): String = expr match
      case Literal(value) => value.toString
      case Add(left, right) => show(left) + "+" + show(right)
      case Multiply(left, right) => show(left) + "*" + show(right)
  
}