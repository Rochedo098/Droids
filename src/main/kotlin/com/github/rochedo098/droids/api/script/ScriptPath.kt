package com.github.rochedo098.droids.api.script

object ScriptPath {
    var variables: MutableList<Variable> = ArrayList()
    fun getLocation(input: String): String {
        var output = input
        for (v in variables) {
            output = output.replace(v.variable!!, v.value!!)
        }
        return output
    }

    fun addVariable(variable: String?, value: String?) {
        variables.add(Variable(variable, value))
    }

    class Variable(var variable: String?, var value: String?)
}