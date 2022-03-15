package com.github.rochedo098.droidsapi.api.script;

import com.github.rochedo098.droidsapi.DroidsAPI;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.Scriptable;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.github.rochedo098.droidsapi.api.script.ScriptManager.createStream;
import static com.github.rochedo098.droidsapi.api.script.ScriptManager.getPath;


public class ScriptFile {
    private final Context context = Context.enter();
    private final Scriptable scope = context.initStandardObjects();

    public String script;

    public ScriptFile(String script) {
        this.script = script;
    }

    public void load() {
        try(InputStream stream = createStream(getPath(this.script))) {
            String script2 = new String(IOUtils.toByteArray(new BufferedInputStream(stream)), StandardCharsets.UTF_8);
            context.evaluateString(scope, script2, getPath(script).toString(), 1, null);
        } catch (IOException e) {
            DroidsAPI.LOGGER.error(e);
        }
    }

    public void load_all() {
        List<String> files = ScriptManager.getScripts();
        for (String file : files) {
            new ScriptFile(file).load();
        }
    }
}
