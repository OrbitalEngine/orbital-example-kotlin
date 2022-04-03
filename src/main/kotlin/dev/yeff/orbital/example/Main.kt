package dev.yeff.orbital.example

import dev.yeff.orbital.Game
import dev.yeff.orbital.example.scenes.MainScene
import dev.yeff.orbital.math.Vector2f
import dev.yeff.orbital.scenes.Scene

fun main(args: Array<String>) {
    val scenes = mapOf<String, Scene>(
        "Main" to MainScene()
    )

    val game = Game(
        Vector2f(700.0f, 700.0f),
        "Hello World",
        scenes
    )

    game.start("Main")
}