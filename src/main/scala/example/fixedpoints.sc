package example

import math.abs

object fixedpoints {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  
  def isCloseEnough(x:Double, y:Double) =
  	abs((x-y)/x)/x < tolerance                //> isCloseEnough: (x: Double, y: Double)Boolean
  
  def fixedpoint(f: Double => Double)(firstguess: Double) = {
  	def iterate(guess: Double):Double = {
  		val next = f(guess)
  		if(isCloseEnough(guess,next))
  			next
  		else
  			iterate(next)
  	}
  	
  	iterate(firstguess)
  }                                               //> fixedpoint: (f: Double => Double)(firstguess: Double)Double
  
  fixedpoint(x => 1 + x/2)(1)                     //> res0: Double = 1.999755859375
  
  def averagedamp(f: Double => Double)(x:Double) =
  	(x + f(x))/2                              //> averagedamp: (f: Double => Double)(x: Double)Double
  	
  def sqrt(x:Double) =
  	fixedpoint(averagedamp(y => x/y))(1)      //> sqrt: (x: Double)Double
  	
  sqrt(2)                                         //> res1: Double = 1.4142135623746899
  	
}