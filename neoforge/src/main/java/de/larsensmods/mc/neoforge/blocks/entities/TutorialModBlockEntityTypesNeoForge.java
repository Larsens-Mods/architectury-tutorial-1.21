package de.larsensmods.mc.neoforge.blocks.entities;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.blocks.entities.GUIBlockEntity;
import de.larsensmods.mc.blocks.entities.RubyCrateEntity;
import de.larsensmods.mc.blocks.entities.RubyFurnaceEntity;
import de.larsensmods.mc.blocks.entities.TutorialModBlockEntityTypes;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TutorialModBlockEntityTypesNeoForge extends TutorialModBlockEntityTypes {

    public static void initBlockEntityTypes(){
        RUBY_CRATE = registerBlockEntity("ruby_crate", () -> new BlockEntityType<>(RubyCrateEntity::new, TutorialModBlocks.RUBY_CRATE.get()));
        RUBY_FURNACE = registerBlockEntity("ruby_furnace", () -> new BlockEntityType<>(RubyFurnaceEntity::new, TutorialModBlocks.RUBY_FURNACE.get()));

        GUI_BLOCK = registerBlockEntity("gui_block", () -> new BlockEntityType<>(GUIBlockEntity::new, TutorialModBlocks.GUI_BLOCK.get()));

        writeRegister();
    }

}
