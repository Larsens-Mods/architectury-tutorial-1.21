package de.larsensmods.mc.entities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Bull extends Cow {

    public Bull(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.DIAMOND);
    }

    @Override
    public @Nullable Cow getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return TutorialModEntityTypes.BULL.get().create(serverLevel, EntitySpawnReason.BREEDING);
    }
}
