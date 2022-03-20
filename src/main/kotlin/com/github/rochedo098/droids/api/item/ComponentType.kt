package com.github.rochedo098.droids.api.item

enum class ComponentType(private val id: String) {
    PROCESSING_UNIT("Processing Unit (PU)"), TEMPORARY_MEMORY("Temporary Memory (TM)"), DISK_DRIVE("Disk Drive (DD)");

    override fun toString(): String {
        return id
    }
}