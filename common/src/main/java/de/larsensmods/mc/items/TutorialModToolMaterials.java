package de.larsensmods.mc.items;

import de.larsensmods.mc.tags.TutorialModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class TutorialModToolMaterials {

    public static final ToolMaterial RUBY = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1024,
            7f,
            2.5f,
            12,
            TutorialModTags.RUBY_TOOL_MATERIALS
    );

}
