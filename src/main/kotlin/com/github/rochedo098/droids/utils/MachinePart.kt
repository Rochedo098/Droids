package com.github.rochedo098.droids.utils

import net.minecraft.util.StringIdentifiable

enum class MachinePart(private val partName: String) : StringIdentifiable {
    UP("head"),
    DOWN("foot");

    override fun toString(): String = partName

    override fun asString(): String = partName
}