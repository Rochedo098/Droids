package com.github.rochedo.droids.config

import com.github.rochedo.droids.config.formats.CompatibilityLevel
import com.github.rochedo.droids.config.formats.ModuleConfig
import com.github.rochedo.droids.config.formats.OreConfig
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

object DroidsConfigs {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    lateinit var modules: Modules
    lateinit var ores: Ores
    lateinit var cores: COres
    lateinit var clevel: CLevel

    private fun generateConfigs(file: String, write: Any) {
        val folder = File(FabricLoader.getInstance().configDir.toFile(), "droids")
        if(!folder.exists()) {
            try {
                folder.mkdirs()
            } catch (e: Exception) {
                println("Could not create configs, future crash is possible")
            }
        }
        val fi = File(folder, file)
        if (!fi.exists()) {
            fi.createNewFile()
            fi.writeText(gson.toJson(write))
        }
    }

    init {
        modules = Modules()
        cores = COres()
        ores = Ores()
        clevel = CLevel()

        // Compatibility Level
        if(FabricLoader.getInstance().isModLoaded("pas")) {
            println("Planets And Stars detected, loading compatibility level")
            generateConfigs("compatibility_level.json", clevel)
            generateConfigs("ores.json", cores)
        } else {
            generateConfigs("ores.json", ores)
        }

        generateConfigs("modules.json", modules)
    }
}

class CLevel {
    private val no_oxygen_module: ModuleConfig = ModuleConfig(true, 1)
    val compatibility_level: CompatibilityLevel = CompatibilityLevel(true, arrayOf(no_oxygen_module))
}

class COres {
    val tin_ore: OreConfig = OreConfig(false, 9)
    val deepslate_tin_ore: OreConfig = OreConfig(false, 4)
}

class Ores {
    val tin_ore: OreConfig = OreConfig(true, 9)
    val deepslate_tin_ore: OreConfig = OreConfig(true, 4)
}

class Modules {
    val water_resistence: ModuleConfig = ModuleConfig(true, 2)
    val fire_resistence: ModuleConfig = ModuleConfig(true, 1)
}