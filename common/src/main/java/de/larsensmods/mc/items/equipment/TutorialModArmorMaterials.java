package de.larsensmods.mc.items.equipment;

import de.larsensmods.mc.TutorialMod;
import de.larsensmods.mc.tags.TutorialModTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class TutorialModArmorMaterials {

    public static final ResourceKey<EquipmentAsset> RUBY_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ruby"));

    public static final ArmorMaterial RUBY = new ArmorMaterial(
            24,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            12,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.0f,
            0.0f,
            TutorialModTags.REPAIRS_RUBY_ARMOR,
            RUBY_ARMOR_MATERIAL_KEY
    );

}
