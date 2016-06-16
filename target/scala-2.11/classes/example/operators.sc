package example

object operators {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val x = new Rational(1, 2)                      //> x  : example.Rational = 1/2
  val y = new Rational(2, 3)                      //> y  : example.Rational = 2/3
  val z = new Rational(3, 2)                      //> z  : example.Rational = 3/2

  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2

  x - y - z                                       //> res2: example.Rational = -5/3

  x + y                                           //> res3: example.Rational = 7/6

  x < y                                           //> res4: Boolean = true
  x max y                                         //> res5: example.Rational = 2/3
  new Rational(2)                                 //> res6: example.Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator should not be zero")

  def this(x: Int) = this(x, 1)
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def - (that: Rational) = this + -that

  override def toString = numer + "/" + denom
  
}