
type IntList = List[Integer]
type T <: Comparable[T]
type Two[A] = Tuple2[A, A]
type MyCollection[+X] <: Iterable[X]

//Monoid

trait Monoid[A] {
  // an identity element
  def id: A
  // an associative operation
  def op(x: A, y: A): A
}

object Monoid {
  //easy to define for strings
  implicit val stringMonoid = new Monoid[String] {
    def id = ""
    def op(x: String, y: String) = x + y
  }

  // here's where things start to get more interesting, this says "I
  // can give you a monoid for any Option[A] if you can give me a
  // monoid for A"
  implicit def optionMonoid[A](implicit am: Monoid[A]): Monoid[Option[A]] =
    new Monoid[Option[A]] {
      def id = None

      def op(x: Option[A], y: Option[A]): Option[A] = (x,y) match {
        case (x, None) => x
        case (None, y) => y
        case (Some(x),Some(y)) => Some(am.op(x,y)) // here we use the A monoid to add two As
      }
    }

  // given an monoid for B, I can give you a monoid for functions
  // returning B, by running the functions on the input and adding the
  // results
  implicit def functionMonoid[A,B](implicit bm: Monoid[B]): Monoid[A => B] = new Monoid[A => B] {
    def id = A => bm.id
    def op(x: A => B, y: A => B): A => B = { a =>
      bm.op(x(a), y(a))
    }
  }

  // we can use a monoid to collapse a bunch of values, here we take a
  // list and function that takes us to a value for which we have a
  // Monoid, and we can then collapse the list into a single value.
  implicit def fold[A](la: List[A])(implicit am: Monoid[A]): A =
    la.foldLeft(am.id)(am.op)
}
