package dev.yeff.orbital.example.scenes

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.GameObject
import dev.yeff.orbital.ecs.builders.GameObjectBuilder
import dev.yeff.orbital.example.components.ColorChanger
import dev.yeff.orbital.example.components.PlayerMovement
import dev.yeff.orbital.graphics.Colors
import dev.yeff.orbital.graphics.Renderer
import dev.yeff.orbital.graphics.Shapes
import dev.yeff.orbital.io.Input
import dev.yeff.orbital.io.Keyboard
import dev.yeff.orbital.io.Keys
import dev.yeff.orbital.io.Mouse
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene
import dev.yeff.orbital.util.Log

class MainScene : Scene() {
    private lateinit var player: GameObject
    private lateinit var pos: Vector2f
    private var redOrBlue: Boolean = true
    

    override fun init(game: Game?) {
        Log.info(javaClass, "Initialize main scene")
        pos = game!!.screenCenter

        player = GameObjectBuilder()
            .withTransform(game.screenCenter, Vector2f(20.0f, 20.0f))
            .withShape(Shapes.CIRCLE, Colors.RED)
            .withComponents(PlayerMovement(), ColorChanger())
            .build()

        addGameObject(game, player)
    }

    override fun update(game: Game?, fps: Float) {
//        val kb: Keyboard = Input.getKeyboard()
//        val mouse: Mouse = Input.getMouse()
//
//        if (kb.isKeyDown(Keys.W)) pos.y -= SPEED
//        if (kb.isKeyDown(Keys.A)) pos.x -= SPEED
//        if (kb.isKeyDown(Keys.S)) pos.y += SPEED
//        if (kb.isKeyDown(Keys.D)) pos.x += SPEED
//        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE)) redOrBlue = !redOrBlue
//
//        Renderer.drawCircle(getColor(), pos, 20.0f)
    }

    override fun dispose(game: Game?) {
        Log.info(javaClass, "Dispose main scene")
    }
}