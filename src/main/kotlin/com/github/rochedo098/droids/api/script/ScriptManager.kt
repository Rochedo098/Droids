package com.github.rochedo098.droids.api.script

import com.github.rochedo098.droids.Droids
import net.fabricmc.loader.api.FabricLoader
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path

object ScriptManager {
    var scriptsFolder = File(FabricLoader.getInstance().configDir.toString() + "droids/scripts")

    fun getScripts(): List<String> {
        val scriptsFolder = File(FabricLoader.getInstance().configDir.toString() + "droids/scripts")
        val allowedFiles: MutableList<String> = ArrayList()
        val listOfFiles = scriptsFolder.listFiles()
        if (listOfFiles != null) for (file in listOfFiles) {
            if (file.isFile) {
                if (file.name.endsWith(".js")) {
                    allowedFiles.add(file.name)
                } else {
                    Droids.LOGGER.error("The file '" + file.name + "' not have the .js extension")
                }
            } else if (file.isDirectory) {
                Droids.LOGGER.error("Directory's not allowed")
            }
        }
        return allowedFiles
    }

    fun getPath(file: String): Path {
        val scriptsFolder = File(FabricLoader.getInstance().configDir.toString() + "droids/scripts")
        return File("$scriptsFolder/$file").toPath()
    }

    fun createStream(path: Path): InputStream {
        return Files.newInputStream(path)
    }
}