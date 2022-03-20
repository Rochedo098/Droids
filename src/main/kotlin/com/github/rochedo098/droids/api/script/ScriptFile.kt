package com.github.rochedo098.droids.api.script

import com.github.rochedo098.droids.Droids
import dev.latvian.mods.rhino.Context
import dev.latvian.mods.rhino.Scriptable
import org.apache.commons.io.IOUtils
import java.io.BufferedInputStream
import java.io.IOException
import java.nio.charset.StandardCharsets

class ScriptFile(var script: String) {
    private val context: Context = Context.enter()
    private val scope: Scriptable = context.initStandardObjects()

    private fun load() {
        try {
            ScriptManager.createStream(
                ScriptManager.getPath(
                    script
                )
            ).use { stream ->
                val script2 = String(IOUtils.toByteArray(BufferedInputStream(stream)), StandardCharsets.UTF_8)
                context.evaluateString(
                    scope, script2, ScriptManager.getPath(
                        script
                    ).toString(), 1, null
                )
            }
        } catch (e: IOException) {
            Droids.LOGGER.error(e)
        }
    }

    private fun load_all() {
        val files: List<String> = ScriptManager.getScripts()
        for (file in files) {
            ScriptFile(file).load()
        }
    }
}