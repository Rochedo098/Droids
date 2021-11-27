package com.github.rochedo098.droids.recipe

import com.google.gson.Gson
import com.google.gson.JsonObject
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class AlloySmelterRecipe(
    val identifier: Identifier,
    val inputA: Ingredient,
    val inputB: Ingredient,
    val result: ItemStack
): Recipe<Inventory> {
    override fun matches(inventory: Inventory, world: World?): Boolean {
        if (inventory.size() < 2) return false
        return this.inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1))
    }

    override fun craft(inventory: Inventory?): ItemStack {
        return this.output.copy()
    }

    override fun fits(width: Int, height: Int): Boolean {
        return false
    }

    override fun getOutput(): ItemStack {
        return this.result
    }

    override fun getId(): Identifier {
        return this.identifier
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return Serializer
    }

    override fun getType(): RecipeType<*> {
        return Type
    }

    class JsonFormat (
        val inputA: JsonObject,
        val inputB: JsonObject,
        val outputItem: String,
        val outputAmount: Int
    )

    object Type: RecipeType<AlloySmelterRecipe> {
        val ID: String = "alloy_smelter"
    }

    object Serializer: RecipeSerializer<AlloySmelterRecipe> {
        override fun read(id: Identifier, json: JsonObject): AlloySmelterRecipe {
            val recipe = Gson().fromJson(json, JsonFormat::class.java)

            val inputA = Ingredient.fromJson(recipe.inputA)
            val inputB = Ingredient.fromJson(recipe.inputB)
            val outputItem = Registry.ITEM.getOrEmpty(Identifier(recipe.outputItem)).get()
            val output = ItemStack(outputItem, recipe.outputAmount)

            return AlloySmelterRecipe(id, inputA, inputB, output)
        }

        override fun write(buf: PacketByteBuf, recipe: AlloySmelterRecipe) {
            recipe.inputA.write(buf)
            recipe.inputB.write(buf)
            buf.writeItemStack(recipe.output)
        }

        override fun read(id: Identifier, buf: PacketByteBuf): AlloySmelterRecipe {
            val inputA = Ingredient.fromPacket(buf)
            val inputB = Ingredient.fromPacket(buf)
            val output = buf.readItemStack()
            return AlloySmelterRecipe(id, inputA, inputB, output)
        }

        val ID: String = "alloy_smelter_recipe"
    }
}