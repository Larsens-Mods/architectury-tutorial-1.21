package de.larsensmods.mc.recipe;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

public class TutorialModRecipeType {

    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(TutorialMod.MOD_ID, Registries.RECIPE_TYPE);

    public static RegistrySupplier<RecipeType<RubyCookingRecipe>> RUBY_SMELTING;

    public static void initRecipeTypes(){
        RUBY_SMELTING = RECIPE_TYPES.register("ruby_smelting", () -> new RecipeType<>() {
            @Override
            public String toString() {
                return "ruby_smelting";
            }
        });

        RECIPE_TYPES.register();
    }

}
