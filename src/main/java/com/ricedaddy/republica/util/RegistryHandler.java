package com.ricedaddy.republica.util;

import com.ricedaddy.republica.Republica;
import com.ricedaddy.republica.armor.ModArmorMaterial;
import com.ricedaddy.republica.blocks.BlockItemBase;
import com.ricedaddy.republica.blocks.RubyBlock;
import com.ricedaddy.republica.items.ItemBase;
import com.ricedaddy.republica.items.PoisonApple;
import com.ricedaddy.republica.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Republica.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Republica.MOD_ID);

    public static void init()   {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items only (DeferredRegisters can only hold registryobjects)
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    //Food
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple", PoisonApple::new));
    //Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4f, new Item.Properties().group( Republica.TAB)));
    public static final RegistryObject<SwordItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4f, new Item.Properties().group( Republica.TAB)));
    public static final RegistryObject<SwordItem> RUBY_HOE = ITEMS.register("ruby_hoe", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4f, new Item.Properties().group( Republica.TAB)));
    public static final RegistryObject<SwordItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4f, new Item.Properties().group( Republica.TAB)));
    public static final RegistryObject<SwordItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4f, new Item.Properties().group( Republica.TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Republica.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Republica.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Republica.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Republica.TAB)));

    //Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));

}
