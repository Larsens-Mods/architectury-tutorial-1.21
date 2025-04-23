package de.larsensmods.mc.recipe;

import de.larsensmods.mc.items.TutorialModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class RubyCookingRecipe extends AbstractCookingRecipe {

    public RubyCookingRecipe(String group, CookingBookCategory category, Ingredient input, ItemStack result, float experience, int cookingTime) {
        super(group, category, input, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return TutorialModRecipeSerializer.RUBY_SMELTING.get();
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return TutorialModRecipeType.RUBY_SMELTING.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case BLOCKS -> RecipeBookCategories.FURNACE_BLOCKS;
            case FOOD -> RecipeBookCategories.FURNACE_FOOD;
            case MISC -> RecipeBookCategories.FURNACE_MISC;
            default -> throw new MatchException(null, null);
        };
    }

    @Override
    protected Item furnaceIcon() {
        return TutorialModItems.RUBY_FURNACE.get();
    }
}
