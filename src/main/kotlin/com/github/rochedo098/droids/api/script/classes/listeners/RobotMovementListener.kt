package com.github.rochedo098.droids.api.script.classes.listeners

interface RobotMovementListener {
    fun walk(blocks: Int, direction: String?) {}
    fun run(blocks: Int, direction: String?) {}
    fun teleport(pos: String?) {}
}