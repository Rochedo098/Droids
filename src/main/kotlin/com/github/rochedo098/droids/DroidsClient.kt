package com.github.rochedo098.droids

import com.github.rochedo098.droids.registry.block.TheMachineGUI
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text

object DroidsClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.register<TheMachineGUI, CottonInventoryScreen<TheMachineGUI>>(
            Droids.THE_MACHINE_SCREEN,
            ScreenRegistry.Factory<TheMachineGUI, CottonInventoryScreen<TheMachineGUI>> { desc: TheMachineGUI, inventory: PlayerInventory, title: Text? ->
                CottonInventoryScreen(
                    desc,
                    inventory.player,
                    title
                )
            }
        )
    }
}