//Implement a version of each program in which all parameters are call-by-name.
//What does each program print? Write a short explanation for the output of each program.
def bob(x: => Int): Int = {
  println("Bob"); x + 1
}

def joe(x: => Int,y:  => Int): Int = {
  println("Joe");
  val a = x; val b = y; println(a+b);
  a+b
}

def ron(x: => Int, y: => Int, z: => Int) {
  println("Ron")
  println(x + y)
  println(x + y + z)
}

bob(joe(bob(1),2)



// Since it is call-by-name, parameters are evaluated before passing into the function.
// Should print:
// Ron
// Bob
// Joe
// Bob
// 4
// 8
// Bob
// Joe
// Bob
// 4
// 12
