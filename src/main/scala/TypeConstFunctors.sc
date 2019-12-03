import simulacrum._
//Collections share travesable gentravesable  trait to map over F[_] - type constructor
// takes a func A and change it to B using map

//trait Functor[ {
//  def map(fa: F[A]) = ???
//
//}
//
//[F_]]{
//  def map[A,B](fa:A ,f:A=>B):F[B]
//}
//
//trait FunctorLaws {
//
//  def identity [F[_] , A] (fa :F[A])(implicit Functor[F]) =
//    F.map(fa)(a =>a) == fa
//  }
//
//  def composition[F[_] , A,B,C] (fa: F[A] , f:A=>B, g:  B=>C) (implicit  Functor[F]) =
//    F.map(F.map(fa)(f))(g) == F.map
//}