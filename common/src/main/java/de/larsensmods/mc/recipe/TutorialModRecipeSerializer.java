package de.larsensmods.mc.recipe;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class TutorialModRecipeSerializer {

    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(TutorialMod.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static RegistrySupplier<RecipeSerializer<RubyCookingRecipe>> RUBY_SMELTING;

    public static void initRecipeSerializers() {
        RUBY_SMELTING = RECIPE_SERIALIZERS.register("ruby_smelting", () -> new AbstractCookingRecipe.Serializer<>(RubyCookingRecipe::new, 70));

        RECIPE_SERIALIZERS.register();
    }

}
