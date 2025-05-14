package de.larsensmods.mc.ui;

import de.larsensmods.mc.TutorialMod;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class TutorialModMenuTypes {

    private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(TutorialMod.MOD_ID, Registries.MENU);

    public static RegistrySupplier<MenuType<GUIBlockMenu>> GUI_BLOCK;

    public static void initMenuTypes(){
        GUI_BLOCK = registerMenuType("gui_block", () -> new MenuType<>(GUIBlockMenu::new, FeatureFlagSet.of()));

        MENU_TYPES.register();

        if(Platform.isFabric()) {
            ClientLifecycleEvent.CLIENT_STARTED.register(client -> {
                MenuRegistry.registerScreenFactory(GUI_BLOCK.get(), GUIBlockScreen::new);
            });
        }
    }

    public static <T extends MenuType<?>> RegistrySupplier<T> registerMenuType(String name, Supplier<T> menuType){
        return MENU_TYPES.register(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name), menuType);
    }

}
