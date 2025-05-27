package de.larsensmods.mc.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;

public class Bull extends Cow {

    public Bull(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
    }

}
