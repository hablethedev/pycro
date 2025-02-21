package hazel.pycro;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import hazel.pycro.gui.PythonInterpreterGui;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PycroInit implements ClientModInitializer {
    public static KeyBinding openGuiKey;

    public static final Logger LOGGER = LoggerFactory.getLogger("pycro");

    @Override
    public void onInitializeClient() {
        openGuiKey = new KeyBinding("key.pycro.opengui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I, "category.pycro.controls");

        KeyBindingHelper.registerKeyBinding(openGuiKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openGuiKey.wasPressed()) {
                LOGGER.info("python picker open");

                if (client != null) {
                    client.execute(() -> MinecraftClient.getInstance().setScreen(new PythonInterpreterGui()));
                }
            }
        });
    }
}