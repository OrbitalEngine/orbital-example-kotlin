package dev.yeff.orbital.example.scenes

import dev.yeff.orbital.Game
import dev.yeff.orbital.graphics.Colors
import dev.yeff.orbital.graphics.Renderer
import dev.yeff.orbital.io.Input
import dev.yeff.orbital.io.Keyboard
import dev.yeff.orbital.io.Keys
import dev.yeff.orbital.io.Mouse
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene
import dev.yeff.orbital.util.Log

class MainScene : Scene {
    private lateinit var pos: Vector2f
    private var redOrBlue: Boolean = true
    
    private val SPEED = 13

    override fun init(game: Game?) {
        Log.info(javaClass, "Initialize main scene")
        pos = game!!.screenCenter
    }

    override fun update(game: Game?, fps: Float) {
        val kb: Keyboard = Input.getKeyboard()
        val mouse: Mouse = Input.getMouse()
        
        if (kb.isKeyDown(Keys.W)) pos.y -= SPEED
        if (kb.isKeyDown(Keys.A)) pos.x -= SPEED
        if (kb.isKeyDown(Keys.S)) pos.y += SPEED
        if (kb.isKeyDown(Keys.D)) pos.x += SPEED
        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE)) redOrBlue = !redOrBlue

        Renderer.drawCircle(getColor(), pos, 20.0f)
    }

    override fun dispose(game: Game?) {
        Log.info(javaClass, "Dispose main scene")
    }

    private fun getColor(): Colors {
        return when {
            redOrBlue -> Colors.RED
            else -> Colors.BLUE
        };
    }
}