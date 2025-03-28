package de.larsensmods.mc.items;

import de.larsensmods.mc.TutorialMod;
import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.tabs.TutorialModTabs;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class TutorialModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TutorialMod.MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Item> RUBY;
    public static RegistrySupplier<Item> RUBY_BLOCK;

    public static void initItems() {
        RUBY = registerItem("ruby", () -> new Item(baseProperties("ruby").arch$tab(TutorialModTabs.TUTORIAL_TAB)));
        RUBY_BLOCK = registerItem("ruby_block", () -> new BlockItem(TutorialModBlocks.RUBY_BLOCK.get(), baseProperties("ruby_block").arch$tab(TutorialModTabs.TUTORIAL_TAB)));

        ITEMS.register();
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item){
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), item);
    }

    public static Item.Properties baseProperties(String name){
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name)));
    }

}
