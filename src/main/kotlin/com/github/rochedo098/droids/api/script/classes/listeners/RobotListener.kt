package com.github.rochedo098.droids.api.script.classes.listeners

interface RobotListener {
    fun onRegister(name: String?, fileLocation: String?) {}
    operator fun get(identifier: String?): String?
}