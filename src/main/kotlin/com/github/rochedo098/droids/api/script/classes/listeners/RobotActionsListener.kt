package com.github.rochedo098.droids.api.script.classes.listeners

import org.jetbrains.annotations.ApiStatus

interface RobotActionsListener {
    fun toUse(blockPos: String?) {}
    fun toBreak(blockPos: String?) {}

    @ApiStatus.Experimental
    fun checkBlock(blockPos: String?): String? {
        return "null"
    }
}