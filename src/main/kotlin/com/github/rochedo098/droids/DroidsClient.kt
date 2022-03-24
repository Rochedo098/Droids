@file:Suppress("DEPRECATION")

package com.github.rochedo098.droids

import com.github.rochedo098.droids.screens.machines.AlloySmelterScreen.AlloySmelterScreen
import com.github.rochedo098.droids.screens.machines.CircuitsAssemblerScreen.CircuitsAssemblerScreen
import com.github.rochedo098.droids.screens.machines.CrusherScreen.CrusherScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

object DroidsClient: ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.register(Droids.ALLOY_SMELTER_SCREEN_HANDLER, ::AlloySmelterScreen)
        ScreenRegistry.register(Droids.CRUSHER_SCREEN_HANDLER, ::CrusherScreen)
        ScreenRegistry.register(Droids.CIRCUITS_ASSEMBLER_SCREEN_HANDLER, ::CircuitsAssemblerScreen)
    }
}