package ar.pablitar.intropv.elasticity

import ar.com.pablitar.libgdx.commons.extensions.ShapeRendererExtensions._
import ar.com.pablitar.libgdx.commons.rendering.Renderers
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType

object JointRenderer {
  def render(joint: SpringJoint, renderers: Renderers): Unit = {
    renderers.withShapes(ShapeType.Filled) { sr =>
      sr.rectLine(joint.from.position, joint.to.position, (5 * joint.naturalLength / joint.currentLength).min(60).max(1))
    }
  }

}
