package com.github.rochedo098.droidsapi;

import com.github.rochedo098.droidsapi.api.registry.ModificationRegistry;
import net.fabricmc.api.ModInitializer;

public class DroidsAPI implements ModInitializer {
    @Override
    public void onInitialize() {
        new ModificationRegistry().registerAll();
    }
}
