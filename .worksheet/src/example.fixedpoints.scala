package example

import math.abs

object fixedpoints {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("Welcome to the Scala worksheet");$skip(28); 
  
  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(75); 
  
  def isCloseEnough(x:Double, y:Double) =
  	abs((x-y)/x)/x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(238); 
  
  def fixedpoint(f: Double => Double)(firstguess: Double) = {
  	def iterate(guess: Double):Double = {
  		val next = f(guess)
  		if(isCloseEnough(guess,next))
  			next
  		else
  			iterate(next)
  	}
  	
  	iterate(firstguess)
  };System.out.println("""fixedpoint: (f: Double => Double)(firstguess: Double)Double""");$skip(33); val res$0 = 
  
  fixedpoint(x => 1 + x/2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(70); 
  
  def averagedamp(f: Double => Double)(x:Double) =
  	(x + f(x))/2;System.out.println("""averagedamp: (f: Double => Double)(x: Double)Double""");$skip(67); 
  	
  def sqrt(x:Double) =
  	fixedpoint(averagedamp(y => x/y))(1);System.out.println("""sqrt: (x: Double)Double""");$skip(14); val res$1 = 
  	
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1))}
  	
}
