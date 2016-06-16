package example

object lexicalscope {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  println("Welcome to the Scala worksheet");$skip(13); 
  
  val x=0;System.out.println("""x  : Int = """ + $show(x ));$skip(21); 
  def f(y:Int) = y+1;System.out.println("""f: (y: Int)Int""");$skip(47); 
  
  val result = {
  	val x=f(3)
  	x*x
  }+x;System.out.println("""result  : Int = """ + $show(result ))}
}
