package com.github.rochedo098.droidsapi.api.script;

import java.util.ArrayList;
import java.util.List;

public class ScriptPath {
    public static class Variable {
        public String variable;
        public String value;

        public Variable(String variable, String value) {
            this.variable = variable;
            this.value = value;
        }
    }

    public static List<Variable> variables = new ArrayList<>();

    public static String getLocation(String input) {
        String output = input;
        for (Variable v : variables) {
            output = output.replace(v.variable, v.value);
        }
        return output;
    }

    public static void addVariable(String variable, String value) {
        variables.add(new Variable(variable, value));
    }
}
