import org.omg.PortableInterceptor.NON_EXISTENT
object sorting {


  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2

    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case (nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)

        }

      val (left, right) = xs splitAt (n)
      merge(mergeSort(left), mergeSort(right))
    }
  }
    def bubbleSort(xs:Array[Int]) :Array [Int] = {
      for( i <- 0 until xs.length -1; j <- 0 until xs.length -i -i ) {

        if (xs(j) >  xs (j+1)) {
          val temp = xs (j)
          xs (j) = xs (j+1)
          xs (j+1) = temp
        }
      }

      xs

    }

    def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

    def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)


    def insertNew(x : Int, xs : List[Int]) : List[Int] = {

      xs match{
        case Nil => List(x)
        case y :: xs1 =>
          if(y >= x) x :: xs
      else y :: insert(x,  xs1)
      }

    }

    def inSort(xs : List[Int]) : List[Int] = {
      xs match{
        case Nil => Nil
        case x :: xs1 => insertNew(x, isort(xs1))

      }


   }



  object main extends  App{


    val arry = Array (2,4,1,6,2,8)
    print(bubbleSort(arry))

  }


}


