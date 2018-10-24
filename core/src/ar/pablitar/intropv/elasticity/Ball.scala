package ar.pablitar.intropv.elasticity

import ar.com.pablitar.libgdx.commons.traits.{AcceleratedSpeedBehaviour, DragBehaviour, Dragable}
import com.badlogic.gdx.math.{Circle, Shape2D, Vector2}
import ar.com.pablitar.libgdx.commons.extensions.VectorExtensions._

class Ball(initialPosition: Vector2, val mass: Float = 1) extends Dragable with DragBehaviour {
  this.position = initialPosition

  val radius = 30

  override def shape: Shape2D = new Circle(this.position, radius)

  var activeAcceleration: Option[Vector2] = None
  override def drag: Float = 300

  def update(delta: Float): Unit = {
    if(!dragging)
      updateValues(delta)
  }

  def applyForce(delta: Float, force: Vector2) = activeAcceleration = Some(force / mass)

  override def applyDrag(currentAcceleration: Vector2): Vector2 = currentAcceleration + dragAcceleration
}
