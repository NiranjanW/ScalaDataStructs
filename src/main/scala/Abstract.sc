trait Functor[F[_]]
trait Monad[F[_]] extends Functor[F]
trait Traverse  [F[_]] extends Functor[F]

def map[A, B, F[_]:Functor](x:F[A], f:A=>B):F[B] = ???

def f[A,B,F[_]:Monad:Traverse](x:F[A],f:A => B):F[B] = {
  implicit  val ev:Functor[F] = implicitly[Monad[F]]
  map(x,f) // error ambiguos
}

// implicit conversion
type T
type U
implicit def a(x:T) :U  //conversion

//vs

implicit def a (implicit x: T) :U //conditional


//implicit conversion
//we cannot extend C with T after the fact mtd of T is demanded but C is found, a wrapper
trait T1
class C

def c2t (x:C) : T1 = new T {???}


//2. implicit parameter , with this typeclass if free , typeclass is implicitily passed dict
//Can combine normal and implicit parameters , but implicit comes last

trait Monoid[A] {
  // an identity element
  def id: A
  // an associative operation
  def op(x: A, y: A): A
}


def sum[a](xs :List[a])(implicit m:Monoid[a]) :a =
  if(xs.isEmpty) m.unit
  else m.add(xs.head, sum(xs.tail)(m))


