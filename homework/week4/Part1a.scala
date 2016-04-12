//(a - 3 pts)
// Consider the following scala programs.
// For each program state what the program outputs assuming all parameters are call-by-value.
// Write a short explanation for the output.
// Program 1:
def bob(x: Int): Int = {
  println("Bob"); x + 1
}

def joe(x: Int,y: Int): Int = {
  println("Joe");
  val a = x; val b = y; println(a+b);
  a+b
}

def ron(x: Int, y: Int, z: Int) {
  println("Ron")
  println(x + y)
  println(x + y + z)
}

ron(bob(joe(bob(1),2)),3,4)
// This is because call-by-value functions compute the passed-in expression's value before calling the function,
// thus the same value is accessed every time.
// However, call-by-name functions recompute the passed-in expression's value every time it is accessed.


// Since it is call-by-value, parameters are evaluated before passing into the function.
// Should print:
// Bob
// Joe
// Bob
// Ron



// Program 2:
def buggy(x: Int): Int = {
  println(x);
  buggy(x - 1)
}

def foo(x: Int, y: Int): Int = {
  println(x)
  x+2
}

println(foo(1,buggy(10)))
// call-by-value, buggy(10) is recursively evaluated, which results in dead recursion.
// Should print:
// 10
// 9
// 8
// ... dead recursion to -Infinte
