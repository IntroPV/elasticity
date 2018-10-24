package ar.pablitar.intropv.elasticity

import ar.com.pablitar.libgdx.commons.extensions.VectorExtensions._

class SpringJoint(val from: Ball, val to: Ball, stiffness: Float, dampening: Float) {
  val MAX_FORCE: Float = 10000
  val naturalLength = currentLength

  def currentLength = {
    (from.position - to.position).len()
  }

  def force = {
    val notDampened = (currentLength - naturalLength) * stiffness

    notDampened - (from.speed - to.speed).len() * dampening * notDampened.signum
  }

  def update(delta: Float): Unit = {
    val fromForce = (to.position - from.position).versor * force.min(MAX_FORCE).max(-MAX_FORCE)
    from.applyForce(delta, fromForce)
    to.applyForce(delta, -fromForce)
  }
}
