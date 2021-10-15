package com.github.rochedo098.droidsapi.impl.templates;

import com.github.rochedo098.droidsapi.api.registry.ModificationRegistry;
import com.github.rochedo098.droidsapi.api.registry.RegistryTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

/**
 * Is this a registry template using ModificationRegistry class
 * Not extends, Please
 */
public class RegistryTemplate implements ModInitializer {
    public static Item MODULE = new ModuleTemplate(new Item.Settings());

    @Override
    public void onInitialize() {
        ModificationRegistry.register(RegistryTypes.MODULE, new Identifier("droidsapi:test_registyr"), MODULE);
    }
}
