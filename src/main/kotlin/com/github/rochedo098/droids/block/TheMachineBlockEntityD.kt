package com.github.rochedo098.droids.block

import com.github.rochedo098.droids.Droids
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos

class TheMachineBlockEntityD(pos: BlockPos, state: BlockState):
    BlockEntity(Droids.THE_MACHINE_ENTITY_DOWN, pos, state), TheMachineInterface {

    override var owner: String = "null"

    fun setOwnerName(name: String) {
        this.owner = name
    }

    override fun writeNbt(nbt: NbtCompound): NbtCompound {
        nbt.putString("owner", this.owner)
        return nbt
    }

    override fun readNbt(nbt: NbtCompound) {
        this.owner = nbt.getString("owner")
    }
}