package com.github.rochedo098.droids.screen

import com.github.rochedo098.droids.Droids
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.math.BlockPos

class TheMachineUScreenHandler(syncId: Int, playerInventory: PlayerInventory): SimpleScreenHandler(syncId, playerInventory), ScreenHandlerHelper {
    override fun getType(): ScreenHandlerType<*> = Droids.SIMPLE_SCREEN_HANDLER

    override fun getPos(): BlockPos = BlockPos.ORIGIN
}