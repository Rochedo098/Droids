package com.github.rochedo098.droids.blocks

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleSidedEnergyContainer

// TODO: FINISH THIS
abstract class EnergyAcceptorBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState): BlockEntity(type, pos, state) {
    private var energyContainer = object : SimpleSidedEnergyContainer() {
        override fun getCapacity(): Long = getMaxEnergyStorage()

        override fun getMaxInsert(side: Direction?): Long {
            if (canAcceptEnergy(side)) return getMaxEnergyInsert()
            return 0
        }

        override fun getMaxExtract(side: Direction?): Long {
            if (canProvideEnergy(side)) return getMaxEnergyExtract()
            return 0
        }
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        val data = nbt.getCompound("PowerAcceptor")
        energyContainer.amount = data.getLong("energy")
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        val data = NbtCompound()
        data.putLong("energy", energyContainer.amount)
        nbt.put("PowerAcceptor", data)
    }

    fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: Thread) {

    }

    abstract fun canAcceptEnergy(side: Direction?): Boolean

    abstract fun canProvideEnergy(side: Direction?): Boolean

    abstract fun getMaxEnergyStorage(): Long

    fun getMaxEnergyInsert(): Long = 100

    fun getMaxEnergyExtract(): Long = 100
}