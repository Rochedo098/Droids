package com.github.rochedo098.droidsapi.api.render;


import net.minecraft.client.render.entity.EntityRendererFactory;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ApiStatus.Experimental
public enum EntityRenderHelper {;
    private static final List<Consumer<EntityRendererFactory.Context>> LISTENERS = new ArrayList<>();

    public static void registerContextListener(Consumer<EntityRendererFactory.Context> listener) {
        LISTENERS.add(listener);
    }

    public static void reload(EntityRendererFactory.Context ctx) {
        for (var l : LISTENERS) {
            l.accept(ctx);
        }
    }
}
