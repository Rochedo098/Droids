@file:Suppress("DEPRECATION")

package com.github.rochedo098.droids

import com.github.rochedo098.droids.screens.machines.basic.AlloySmelterScreen.AlloySmelterScreen
import com.github.rochedo098.droids.screens.machines.basic.CrusherScreen.CrusherScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

object DroidsClient: ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.register(Droids.ALLOY_SMELTER_SCREEN_HANDLER, ::AlloySmelterScreen)
        ScreenRegistry.register(Droids.CRUSHER_SCREEN_HANDLER, ::CrusherScreen)
    }
}