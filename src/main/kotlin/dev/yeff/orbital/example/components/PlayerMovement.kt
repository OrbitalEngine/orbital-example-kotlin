package dev.yeff.orbital.example.components

import dev.yeff.orbital.Game
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.components.TransformComponent
import dev.yeff.orbital.io.Input
import dev.yeff.orbital.io.Keyboard
import dev.yeff.orbital.io.Keys

class PlayerMovement : Component() {
    private lateinit var transform: TransformComponent

    private val SPEED = 13

    override fun init(game: Game?) {
        transform = parent.getComponent(TransformComponent::class.java)
    }

    override fun update(game: Game?) {
        val kb: Keyboard = Input.getKeyboard()

        if (kb.isKeyDown(Keys.W)) transform.position.y -= SPEED
        if (kb.isKeyDown(Keys.A)) transform.position.x -= SPEED
        if (kb.isKeyDown(Keys.S)) transform.position.y += SPEED
        if (kb.isKeyDown(Keys.D)) transform.position.x += SPEED
    }
}