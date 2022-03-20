package com.github.rochedo098.droids.api.script.classes

import com.github.rochedo098.droids.api.script.classes.listeners.RobotActionsListener
import dev.latvian.mods.rhino.ScriptableObject
import dev.latvian.mods.rhino.annotations.JSFunction
import dev.latvian.mods.rhino.annotations.JSGetter
import org.jetbrains.annotations.ApiStatus

class RobotActions : ScriptableObject() {
    private val listeners: MutableList<RobotActionsListener> = ArrayList<RobotActionsListener>()
    fun addListener(toAdd: RobotActionsListener) {
        listeners.add(toAdd)
    }

    override fun getClassName(): String = "RobotActions"

    @JSFunction
    fun toUse(blockPos: String?) {
        for (ral in listeners) {
            ral.toUse(blockPos)
        }
    }

    @JSFunction
    fun toBreak(blockPos: String?) {
        for (ral in listeners) {
            ral.toBreak(blockPos)
        }
    }

    @ApiStatus.Experimental
    @JSGetter
    fun checkBlock(blockPos: String?): String? {
        for (ral in listeners) {
            return ral.checkBlock(blockPos)
        }
        return "null"
    }
}