package example

object currying {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def mapreduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a:Int, b:Int) : Int =
  if(a>b)
  	zero
  else
  	combine(f(a), mapreduce(f, combine, zero)(a+1,b))
                                                  //> mapreduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  
  def product(f: Int => Int)(a:Int, b:Int):Int = mapreduce(f, (x,y) => x*y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x*x)(3,4)                          //> res0: Int = 144
  
  def fact(n:Int) = product(x=>x)(1,n)            //> fact: (n: Int)Int
  fact(5)                                         //> res1: Int = 120
    
}