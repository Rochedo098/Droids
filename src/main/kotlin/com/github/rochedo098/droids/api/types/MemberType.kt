package com.github.rochedo098.droids.api.types

enum class MemberType(private val id: String, var status: String) {
    HEAD("head", "organic"), LEFT_ARM("left_arm", "organic"), RIGHT_ARM("right_arm", "organic"), LEFT_LEG(
        "left_leg",
        "organic"
    ),
    RIGHT_LEG("right_leg", "organic");

    override fun toString(): String {
        return id
    }
}