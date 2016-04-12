def compose(f: Int =>Int, g:Int=>Int):Int=>Int = { x=>
  f(g(x))
}


val square=(x: Int)=> x*x

val inc = (x:Int) => x+1

val squareinc = compose(square, inc)
squareinc(10)

/**
  * Repeat function f n times to x
  * @param f
  * @param n
  * @return
  */
def repeat(f: Int=>Int, n: Int): Int=>Int ={x=>
  (1 to n).fold(x){(result, i)=>
    f(result)
  }
}

/**
  * Version 2: use recursion.
  * @param f
  * @param n
  * @return
  */
def repeat2(f: Int=>Int, n: Int): Int=>Int ={x=>
  if(n==1) f(x)
  else f(repeat(f, n-1)(x))

}

/**
  * Version 3: Re-use compose
  * @param f
  * @param n
  * @return
  */
def repeat3(f: Int=>Int, n: Int): Int=>Int ={x=>
  val r = if(n>2) repeat3(f, n-1) else f
  compose(f, r)(x)
}

// test code 
val square4 = repeat3(square, 4)
square4(2)
