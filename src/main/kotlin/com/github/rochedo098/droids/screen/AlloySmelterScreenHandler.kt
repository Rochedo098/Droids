package com.github.rochedo098.droids.screen

import com.github.rochedo098.droids.Droids
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.math.BlockPos

class AlloySmelterScreenHandler(syncId: Int, playerInventory: PlayerInventory): SimpleScreenHandler(syncId, playerInventory), ScreenHandlerHelper {
    override fun getPos(): BlockPos = BlockPos.ORIGIN

    override fun getType(): ScreenHandlerType<*> = Droids.ALLOY_SMELTER_SCREEN_HANDLER
}