package com.github.rochedo098.droids.api.script.classes

import com.github.rochedo098.droids.api.script.classes.listeners.RobotMovementListener
import dev.latvian.mods.rhino.ScriptableObject
import dev.latvian.mods.rhino.annotations.JSFunction

class RobotMovement : ScriptableObject() {
    private val listeners: MutableList<RobotMovementListener> = ArrayList<RobotMovementListener>()
    fun addListener(toAdd: RobotMovementListener) {
        listeners.add(toAdd)
    }

    override fun getClassName(): String = "RobotMovement"

    @JSFunction
    fun walk(blocks: Int, direction: String?) {
        for (rml in listeners) {
            rml.walk(blocks, direction)
        }
    }

    @JSFunction
    fun run(blocks: Int, direction: String?) {
        for (rml in listeners) {
            rml.run(blocks, direction)
        }
    }

    @JSFunction
    fun teleport(pos: String?) {
        for (rml in listeners) {
            rml.teleport(pos)
        }
    }
}