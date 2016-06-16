package example

object operators {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(32); 
  
  val x = new Rational(1, 2);System.out.println("""x  : example.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(2, 3);System.out.println("""y  : example.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : example.Rational = """ + $show(z ));$skip(11); val res$0 = 

  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(13); val res$2 = 

  x - y - z;System.out.println("""res2: example.Rational = """ + $show(res$2));$skip(9); val res$3 = 

  x + y;System.out.println("""res3: example.Rational = """ + $show(res$3));$skip(9); val res$4 = 

  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(10); val res$5 = 
  x max y;System.out.println("""res5: example.Rational = """ + $show(res$5));$skip(18); val res$6 = 
  new Rational(2);System.out.println("""res6: example.Rational = """ + $show(res$6))}
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
