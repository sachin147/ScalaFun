package example

object manifest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(100); 
  
  def inspect[T](l: List[T])(implicit manifest: scala.reflect.Manifest[T]) = manifest.toString();System.out.println("""inspect: [T](l: List[T])(implicit manifest: scala.reflect.Manifest[T])String""");$skip(42); 
  val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil;System.out.println("""list  : List[Int] = """ + $show(list ));$skip(16); val res$0 = 
  inspect(list);System.out.println("""res0: String = """ + $show(res$0))}
}
