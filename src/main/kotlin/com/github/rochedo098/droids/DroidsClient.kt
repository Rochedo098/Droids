package com.github.rochedo098.droids

import com.github.rochedo098.droids.screen.AlloySmelterScreen
import com.github.rochedo098.droids.screen.TheMachineUScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

@Environment(EnvType.CLIENT)
object DroidsClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.register(Droids.THE_MACHINE_SCREEN_HANDLER, ::TheMachineUScreen)
        ScreenRegistry.register(Droids.ALLOY_SMELTER_SCREEN_HANDLER, ::AlloySmelterScreen)
    }
}