package de.larsensmods.mc.entities;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class TutorialModEntityTypes {

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(TutorialMod.MOD_ID, Registries.ENTITY_TYPE);

    public static RegistrySupplier<EntityType<Bull>> BULL;

    public static void initEntityTypes(){
        BULL = registerEntityType("bull", () -> EntityType.Builder.of(Bull::new, MobCategory.CREATURE)
                .sized(0.9f, 1.4f)
                .eyeHeight(1.3f)
                .passengerAttachments(1.36875f)
                .clientTrackingRange(10)
                .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bull"))));

        ENTITIES.register();
    }

    private static <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> entityType){
        return ENTITIES.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), entityType);
    }

}
