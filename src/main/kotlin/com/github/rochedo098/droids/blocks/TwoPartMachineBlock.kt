package com.github.rochedo098.droids.blocks

import com.github.rochedo098.droids.utils.Properties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class TwoPartMachineBlock(settings: Settings): MachineBase.MachineBlock(settings) {
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(MACHINE_PART)
    }

    companion object {
        val MACHINE_PART = Properties.MACHINE_PART
    }
}