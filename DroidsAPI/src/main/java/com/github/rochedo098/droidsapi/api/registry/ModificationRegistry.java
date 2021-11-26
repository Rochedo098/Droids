package com.github.rochedo098.droidsapi.api.registry;

import com.github.rochedo098.droidsapi.api.events.EventHandler;
import com.github.rochedo098.droidsapi.api.events.Events;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

@ApiStatus.Experimental
public class ModificationRegistry {
    public static List<RegistryBase> registryModules = new ArrayList<>();
    public static List<RegistryBase> registryMembers = new ArrayList<>();
    public static List<RegistryBase> registryOrgans = new ArrayList<>();

    /**
     * A method for register your Module/Member/Organ
     * @param type A type of your item
     * @param identifier A Identifier for your item
     * @param entry The class of your item
     */
    public static <V, T extends V> void register(RegistryTypes type, Identifier identifier, T entry) {
        if (type == RegistryTypes.MODULE) registryModules.add(new RegistryBase(type, identifier, entry));
        if (type == RegistryTypes.MEMBER) registryMembers.add(new RegistryBase(type, identifier, entry));
        if (type == RegistryTypes.ORGAN) registryOrgans.add(new RegistryBase(type, identifier, entry));
    }

    /**
     * This method is a loop for registry all things
     * This method is for internal use.
     */
    @ApiStatus.Internal
    public void registerAll() {
        if (!registryModules.isEmpty()) {
            for (RegistryBase registry : registryModules) {
                Registry.register(Registry.ITEM, registry.identifier, registry.entryAsItem);
                new EventHandler().settingEvent(Events.onRegistry, registryModules, null);
            }
        }
        if (!registryMembers.isEmpty()) {
            for (RegistryBase registry : registryMembers) {
                Registry.register(Registry.ITEM, registry.identifier, registry.entryAsItem);
                new EventHandler().settingEvent(Events.onRegistry, registryMembers, null);
            }
        }
        if (!registryOrgans.isEmpty()) {
            for (RegistryBase registry : registryOrgans) {
                Registry.register(Registry.ITEM, registry.identifier, registry.entryAsItem);
                new EventHandler().settingEvent(Events.onRegistry, registryOrgans, null);
            }
        }
    }
}
