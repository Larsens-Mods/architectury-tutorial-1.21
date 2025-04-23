package de.larsensmods.mc.blocks.entities;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class TutorialModBlockEntityTypes {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(TutorialMod.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<RubyCrateEntity>> RUBY_CRATE;
    public static RegistrySupplier<BlockEntityType<RubyFurnaceEntity>> RUBY_FURNACE;

    public static void writeRegister(){
        BLOCK_ENTITIES.register();
    }

    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(String name, Supplier<T> blockEntity){
        return BLOCK_ENTITIES.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), blockEntity);
    }

}
