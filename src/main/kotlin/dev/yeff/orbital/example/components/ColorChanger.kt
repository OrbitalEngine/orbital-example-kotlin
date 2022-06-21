package dev.yeff.orbital.example.components

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.Component
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent
import dev.yeff.orbital.graphics.Colors
import dev.yeff.orbital.io.Input
import dev.yeff.orbital.io.Keys
import dev.yeff.orbital.io.Mouse

class ColorChanger : Component() {
    private lateinit var shape: RenderShapeComponent

    override fun init(game: Game?) {
        shape = parent.getComponent(RenderShapeComponent::class.java)
    }

    override fun update(game: Game?) {
        val mouse: Mouse = Input.getMouse()

        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE) && shape.color == Colors.RED)
            shape.color = Colors.BLUE
        else
            shape.color = Colors.RED
    }
}