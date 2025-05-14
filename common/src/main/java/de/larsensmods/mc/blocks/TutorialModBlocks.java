package de.larsensmods.mc.blocks;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class TutorialModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(TutorialMod.MOD_ID, Registries.BLOCK);

    public static RegistrySupplier<Block> RUBY_BLOCK;
    public static RegistrySupplier<Block> RUBY_ORE;
    public static RegistrySupplier<Block> DEEPSLATE_RUBY_ORE;

    public static RegistrySupplier<Block> RUBY_CRATE;
    public static RegistrySupplier<Block> RUBY_FURNACE;

    public static RegistrySupplier<Block> GUI_BLOCK;

    public static void initBlocks(){
        RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(baseProperties("ruby_block").requiresCorrectToolForDrops().strength(3.5f)));
        RUBY_ORE = registerBlock("ruby_ore", () -> new Block(baseProperties("ruby_ore").requiresCorrectToolForDrops().strength(3.5f)));
        DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", () -> new Block(baseProperties("deepslate_ruby_ore").requiresCorrectToolForDrops().strength(3.5f)));

        RUBY_CRATE = registerBlock("ruby_crate", () -> new RubyCrateBlock(baseProperties("ruby_crate").requiresCorrectToolForDrops().strength(3.5f)));
        RUBY_FURNACE = registerBlock("ruby_furnace", () -> new RubyFurnaceBlock(baseProperties("ruby_furnace").requiresCorrectToolForDrops().strength(3.5f)));

        GUI_BLOCK = registerBlock("gui_block", () -> new GUIBlock(baseProperties("gui_block").requiresCorrectToolForDrops().strength(3.5f)));

        BLOCKS.register();
    }

    public static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> block){
        return BLOCKS.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), block);
    }

    public static BlockBehaviour.Properties baseProperties(String name){
        return BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name)));
    }

}
