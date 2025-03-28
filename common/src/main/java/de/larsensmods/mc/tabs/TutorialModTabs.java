package de.larsensmods.mc.tabs;

import de.larsensmods.mc.TutorialMod;
import de.larsensmods.mc.items.TutorialModItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TutorialModTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(TutorialMod.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static RegistrySupplier<CreativeModeTab> TUTORIAL_TAB;

    public static void initTabs(){
        TUTORIAL_TAB = TABS.register("tutorial_tab", () -> CreativeTabRegistry.create(Component.translatable("category.tutorial_tab"), () -> new ItemStack(TutorialModItems.RUBY)));

        TABS.register();
    }

}
