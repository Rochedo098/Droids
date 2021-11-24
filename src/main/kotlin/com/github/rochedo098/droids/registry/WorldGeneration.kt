package com.github.rochedo098.droids.registry

import com.github.rochedo098.droids.Droids.myIdentifier
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.heightprovider.UniformHeightProvider


object WorldGeneration {
    // Tin Ore
    private val TIN_ORE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                DroidsBlocks.TIN_ORE!!.defaultState,
                6
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(20)

    private val TIN_ORE_DEEPSLATE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                DroidsBlocks.DEEPSLATE_TIN_ORE!!.defaultState,
                4
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(15)

    // Lead Ore
    private val LEAD_ORE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                DroidsBlocks.LEAD_ORE!!.defaultState,
                5
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(15)

    private val LEAD_ORE_DEEPSLATE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                DroidsBlocks.DEEPSLATE_LEAD_ORE!!.defaultState,
                4
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(13)

    // Silver Ore
    private val SILVER_ORE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                DroidsBlocks.SILVER_ORE!!.defaultState,
                5
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(15)

    private val SILVER_ORE_DEEPSLATE: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                DroidsBlocks.DEEPSLATE_SILVER_ORE!!.defaultState,
                4
            )
        ) // Vein size
        .range(
            RangeDecoratorConfig(
                UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
            )
        ) // Inclusive min and max height
        .spreadHorizontally()
        .repeat(13)


    fun register() {
        // Tin Ore
        val tinOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("tin_ore_overworld")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOreOverworld.value, TIN_ORE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            tinOreOverworld
        )

        val tinOreDeepslate: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("tin_ore_deepslate")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOreDeepslate.value, TIN_ORE_DEEPSLATE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            tinOreDeepslate
        )

        // Lead Ore
        val leadOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("lead_ore_overworld")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreOverworld.value, LEAD_ORE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            leadOreOverworld
        )

        val leadOreDeepslate: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("lead_ore_deepslate")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreDeepslate.value, LEAD_ORE_DEEPSLATE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            leadOreDeepslate
        )

        // Silver Ore
        val silverOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("silver_ore_overworld")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, silverOreOverworld.value, SILVER_ORE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            silverOreOverworld
        )

        val silverOreDeepslate: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_KEY,
            myIdentifier("silver_ore_deepslate")
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, silverOreDeepslate.value, SILVER_ORE_DEEPSLATE)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            silverOreDeepslate
        )
    }
}