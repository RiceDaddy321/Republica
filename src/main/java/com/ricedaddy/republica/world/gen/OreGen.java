package com.ricedaddy.republica.world.gen;

import com.ricedaddy.republica.Republica;
import com.ricedaddy.republica.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Republica.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {
    //creats a new filler block type
    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone",new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for(Biome biome : ForgeRegistries.BIOMES)   {
            //Nether generation
            if(biome.getCategory() == Biome.Category.NETHER)    {
                genOre(biome, 30, 8, 5, 80, OreFeatureConfig.FillerBlockType.NETHERRACK,
                        RegistryHandler.RUBY_ORE.get().getDefaultState(), 5);
                //end generation
            } else if(biome.getCategory() == Biome.Category.THEEND) {
                genOre(biome, 18, 3, 5, 70, END_STONE,
                        RegistryHandler.RUBY_ORE.get().getDefaultState(), 20);
            //world generation
            } else  {
                genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        RegistryHandler.RUBY_ORE.get().getDefaultState(), 8);
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max,
                               OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
