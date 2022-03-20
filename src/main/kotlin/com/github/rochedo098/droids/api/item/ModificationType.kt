package com.github.rochedo098.droids.api.item

enum class ModificationType(private val id: String) {
    MODULE("Module"), MEMBER("Member"), ORGAN("Organ");

    override fun toString(): String {
        return id
    }
}