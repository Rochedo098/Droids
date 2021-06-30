package com.github.rochedo.droids.api

interface DroidPlayerExtension {
    val droid: Boolean
    val modules: Array<Int>

    val artificial_heart: Boolean
    val artificial_lungs: Boolean
    val artificial_stomach: Boolean
}