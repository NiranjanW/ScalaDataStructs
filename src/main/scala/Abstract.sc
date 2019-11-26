trait Functor[F[_]]
trait Monad[F[_]] extends Functor[F]
trait Traverse  [F[_]] extends Functor[F]

def map[A, B, F[_]:Functor](x:F[A], f:A=>B):F[B] = ???

def