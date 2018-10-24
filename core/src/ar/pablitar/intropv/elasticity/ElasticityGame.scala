package ar.pablitar.intropv.elasticity

import com.badlogic.gdx.Game

class ElasticityGame extends Game {
  override def create(): Unit = this.setScreen(new ElasticityScreen())
}
