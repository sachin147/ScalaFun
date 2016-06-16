package example

object manifest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def inspect[T](l: List[T])(implicit manifest: scala.reflect.Manifest[T]) = manifest.toString()
                                                  //> inspect: [T](l: List[T])(implicit manifest: scala.reflect.Manifest[T])String
                                                  //| 
  val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil         //> list  : List[Int] = List(1, 2, 3, 4, 5)
  inspect(list)                                   //> res0: String = Int
}