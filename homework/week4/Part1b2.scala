
// Program 2:
def buggy(x: => Int): Int = {
  println(x);
  buggy(x - 1)
}

def foo(x: => Int, y: => Int): Int = {
  println(x)
  x+2
}

println(foo(1,buggy(10)))

// call-by-name, buggy(10) is not evaluated
// Should print:
// 1
// 3
