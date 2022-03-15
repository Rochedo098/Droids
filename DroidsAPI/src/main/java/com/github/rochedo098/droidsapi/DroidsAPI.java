package com.github.rochedo098.droidsapi;

import com.github.rochedo098.droidsapi.api.script.ScriptPath;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DroidsAPI implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger("DroidsAPI");

    @Override
    public void onInitialize() {
        ScriptPath.addVariable("$CONFIG", FabricLoader.getInstance().getConfigDir().toString());
        ScriptPath.addVariable("$GAMEDIR", FabricLoader.getInstance().getGameDir().toString());

        /*
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            for (Command cmd : commands) {
                dispatcher.register(literal(cmd.getName()).executes(cmd::runCommon));
            }
        }));
        */
    }
}
