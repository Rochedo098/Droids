package com.github.rochedo098.droids.api.types

enum class OrganType(private val id: String, var status: String) {
    BRAIN("brain", "organic"), EYES("eyes", "organic"), HEART("heart", "organic"), LUNGS("lungs", "organic");

    override fun toString(): String {
        return id
    }
}