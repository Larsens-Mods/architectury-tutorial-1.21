package de.larsensmods.mc.items;

import de.larsensmods.mc.TutorialMod;
import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.items.equipment.TutorialModArmorMaterials;
import de.larsensmods.mc.tabs.TutorialModTabs;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Supplier;

public class TutorialModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TutorialMod.MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Item> RUBY;

    public static RegistrySupplier<Item> RUBY_AXE;
    public static RegistrySupplier<Item> RUBY_HOE;
    public static RegistrySupplier<Item> RUBY_PICKAXE;
    public static RegistrySupplier<Item> RUBY_SHOVEL;
    public static RegistrySupplier<Item> RUBY_SWORD;

    public static RegistrySupplier<Item> RUBY_HELMET;
    public static RegistrySupplier<Item> RUBY_CHESTPLATE;
    public static RegistrySupplier<Item> RUBY_LEGGINGS;
    public static RegistrySupplier<Item> RUBY_BOOTS;

    public static RegistrySupplier<Item> RUBY_BLOCK;
    public static RegistrySupplier<Item> RUBY_ORE;
    public static RegistrySupplier<Item> DEEPSLATE_RUBY_ORE;

    public static RegistrySupplier<Item> RUBY_CRATE;
    public static RegistrySupplier<Item> RUBY_FURNACE;

    public static void initItems() {
        RUBY = registerItem("ruby", () -> new Item(baseProperties("ruby").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        RUBY_AXE = registerItem("ruby_axe", () -> new AxeItem(TutorialModToolMaterials.RUBY, 6.0f, -3.0f, baseProperties("ruby_axe").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_HOE = registerItem("ruby_hoe", () -> new HoeItem(TutorialModToolMaterials.RUBY, 0.0f, -2.0f, baseProperties("ruby_hoe").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_PICKAXE = registerItem("ruby_pickaxe", () -> new PickaxeItem(TutorialModToolMaterials.RUBY, 4.5f, -2.5f, baseProperties("ruby_pickaxe").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_SHOVEL = registerItem("ruby_shovel", () -> new ShovelItem(TutorialModToolMaterials.RUBY, 1.5f, -3.0f, baseProperties("ruby_shovel").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_SWORD = registerItem("ruby_sword", () -> new SwordItem(TutorialModToolMaterials.RUBY, 3.0f, -2.4f, baseProperties("ruby_sword").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        RUBY_HELMET = registerItem("ruby_helmet", () -> new ArmorItem(TutorialModArmorMaterials.RUBY, ArmorType.HELMET, baseProperties("ruby_helmet").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", () -> new ArmorItem(TutorialModArmorMaterials.RUBY, ArmorType.CHESTPLATE, baseProperties("ruby_chestplate").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_LEGGINGS = registerItem("ruby_leggings", () -> new ArmorItem(TutorialModArmorMaterials.RUBY, ArmorType.LEGGINGS, baseProperties("ruby_leggings").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_BOOTS = registerItem("ruby_boots", () -> new ArmorItem(TutorialModArmorMaterials.RUBY, ArmorType.BOOTS, baseProperties("ruby_boots").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        RUBY_BLOCK = registerItem("ruby_block", () -> new BlockItem(TutorialModBlocks.RUBY_BLOCK.get(), baseProperties("ruby_block").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_ORE = registerItem("ruby_ore", () -> new BlockItem(TutorialModBlocks.RUBY_ORE.get(), baseProperties("ruby_ore").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        DEEPSLATE_RUBY_ORE = registerItem("deepslate_ruby_ore", () -> new BlockItem(TutorialModBlocks.DEEPSLATE_RUBY_ORE.get(), baseProperties("deepslate_ruby_ore").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        RUBY_CRATE = registerItem("ruby_crate", () -> new BlockItem(TutorialModBlocks.RUBY_CRATE.get(), baseProperties("ruby_crate").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_FURNACE = registerItem("ruby_furnace", () -> new BlockItem(TutorialModBlocks.RUBY_FURNACE.get(), baseProperties("ruby_furnace").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        ITEMS.register();
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item){
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), item);
    }

    public static Item.Properties baseProperties(String name){
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name)));
    }

}
