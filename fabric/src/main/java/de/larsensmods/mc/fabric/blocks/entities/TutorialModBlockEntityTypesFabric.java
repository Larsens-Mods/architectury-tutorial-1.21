package de.larsensmods.mc.fabric.blocks.entities;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.blocks.entities.GUIBlockEntity;
import de.larsensmods.mc.blocks.entities.RubyCrateEntity;
import de.larsensmods.mc.blocks.entities.RubyFurnaceEntity;
import de.larsensmods.mc.blocks.entities.TutorialModBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class TutorialModBlockEntityTypesFabric extends TutorialModBlockEntityTypes {

    public static void initBlockEntityTypes(){
        RUBY_CRATE = registerBlockEntity("ruby_crate", () -> FabricBlockEntityTypeBuilder.create(RubyCrateEntity::new, TutorialModBlocks.RUBY_CRATE.get()).build());
        RUBY_FURNACE = registerBlockEntity("ruby_furnace", () -> FabricBlockEntityTypeBuilder.create(RubyFurnaceEntity::new, TutorialModBlocks.RUBY_FURNACE.get()).build());

        GUI_BLOCK = registerBlockEntity("gui_block", () -> FabricBlockEntityTypeBuilder.create(GUIBlockEntity::new, TutorialModBlocks.GUI_BLOCK.get()).build());

        writeRegister();
    }

}
