package ar.pablitar.intropv.elasticity

import ar.com.pablitar.libgdx.commons.rendering.Renderers
import ar.com.pablitar.libgdx.commons.extensions.ShapeRendererExtensions._
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType

object BallRenderer {
  def render(ball: Ball, renderers: Renderers): Unit = {
    renderers.withShapes(ShapeType.Filled) { sr =>
      sr.circleWithBorder(5, Color.GOLD, ball.radius, Color.LIGHT_GRAY)(ball.x, ball.y)
    }
  }

}
