package ar.pablitar.intropv.elasticity

import ar.com.pablitar.libgdx.commons.DragableController
import ar.com.pablitar.libgdx.commons.rendering.Renderers
import ar.com.pablitar.libgdx.commons.traits.Dragable
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.math.Vector2

class ElasticityScreen extends ScreenAdapter {

  val renderers = new Renderers()

  val balls = List(new Ball(new Vector2(640, 200)), new Ball(new Vector2(640, 500)))
  val spring = new SpringJoint(balls(0), balls(1), 200, 5)

  val dragController = new DragableController {
    override def dragables: Seq[Dragable] = balls
  }

  override def render(delta: Float): Unit = {
    dragController.update(delta)

    spring.update(delta)
    balls.foreach(_.update(delta))

    renderers.withRenderCycle(0.1f, 0.1f, 0.1f) {
      JointRenderer.render(spring, renderers)
      balls.foreach(BallRenderer.render(_, renderers))
    }
  }
}
