package com.github.rochedo098.droids.api.script.classes

import com.github.rochedo098.droids.api.script.ScriptPath
import com.github.rochedo098.droids.api.script.classes.listeners.RobotListener
import dev.latvian.mods.rhino.ScriptableObject
import dev.latvian.mods.rhino.annotations.JSFunction
import dev.latvian.mods.rhino.annotations.JSGetter

class Robot : ScriptableObject() {
    private val listeners: MutableList<RobotListener> = ArrayList<RobotListener>()
    fun addListener(toAdd: RobotListener) { listeners.add(toAdd) }

    override fun getClassName(): String = "Robot"

    @JSFunction
    fun register(name: String?, fileLocation: String?) {
        for (rl in listeners) {
            rl.onRegister(name, fileLocation?.let { ScriptPath.getLocation(it) })
        }
    }

    @JSGetter
    operator fun get(identifier: String?): List<String> {
        val output: MutableList<String> = ArrayList()
        for (rl in listeners) {
            rl[identifier]?.let { output.add(it) }
        }
        return output
    }
}