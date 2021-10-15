package com.github.rochedo098.droidsapi.api.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

/**
 * The class for input entry
 */
public class RegistryBase {
    public RegistryTypes type;
    public Identifier identifier;

    public Item entryAsItem;

    public <V, T extends V> RegistryBase(RegistryTypes type, Identifier identifier, T entry) {
        this.type = type;
        this.identifier = identifier;
        this.entryAsItem = (Item) entry;
    }
}
