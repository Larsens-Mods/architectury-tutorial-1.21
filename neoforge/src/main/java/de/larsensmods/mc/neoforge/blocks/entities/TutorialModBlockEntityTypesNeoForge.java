package de.larsensmods.mc.neoforge.blocks.entities;

import de.larsensmods.mc.blocks.TutorialModBlocks;
import de.larsensmods.mc.blocks.entities.RubyCrateEntity;
import de.larsensmods.mc.blocks.entities.TutorialModBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TutorialModBlockEntityTypesNeoForge extends TutorialModBlockEntityTypes {

    public static void initBlockEntityTypes(){
        RUBY_CRATE = registerBlockEntity("ruby_crate", () -> new BlockEntityType<>(RubyCrateEntity::new, TutorialModBlocks.RUBY_CRATE.get()));

        writeRegister();
    }

}
