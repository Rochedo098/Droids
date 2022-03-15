package com.github.rochedo098.droidsapi.api.script;

import com.github.rochedo098.droidsapi.DroidsAPI;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ScriptManager {
    public File scriptsFolder = new File(FabricLoader.getInstance().getConfigDir().toString() + "droids/scripts");

    public static List<String> getScripts() {
        File scriptsFolder = new File(FabricLoader.getInstance().getConfigDir().toString() + "droids/scripts");
        List<String> allowedFiles = new ArrayList<>();
        File[] listOfFiles = scriptsFolder.listFiles();

        if (listOfFiles != null)
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().endsWith(".js")) { allowedFiles.add(file.getName()); }
                else { DroidsAPI.LOGGER.error("The file '" + file.getName() + "' not have the .js extension"); }
            } else if (file.isDirectory()) { DroidsAPI.LOGGER.error("Directory's not allowed"); }
        }
        return allowedFiles;
    }

    public static Path getPath(String file) {
        File scriptsFolder = new File(FabricLoader.getInstance().getConfigDir().toString() + "droids/scripts");
        return new File(scriptsFolder + "/" + file).toPath();
    }

    public static InputStream createStream(Path path) throws IOException {
        return Files.newInputStream(path);
    }
}
