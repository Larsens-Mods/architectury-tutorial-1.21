package de.larsensmods.mc.tags;

import de.larsensmods.mc.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TutorialModTags {

    public static final TagKey<Item> RUBY_TOOL_MATERIALS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ruby_tool_materials"));

}
