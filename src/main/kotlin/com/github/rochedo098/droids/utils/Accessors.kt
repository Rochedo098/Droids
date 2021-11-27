package com.github.rochedo098.droids.utils

import com.github.rochedo098.droids.mixin.common.AccessorRecipeManager
import net.minecraft.inventory.Inventory
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeManager
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier

/* Code copied from Industrial Revolution */
@Suppress("UNCHECKED_CAST")
fun <T : Recipe<Inventory>> RecipeManager.getAllOfType(type: RecipeType<T>): Map<Identifier, T>
        = (this as AccessorRecipeManager).droids_getAllOfType(type) as Map<Identifier, T>