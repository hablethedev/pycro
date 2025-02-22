package hazel.pycro;

import hazel.pycro.gui.PythonInterpreterGui;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.Stack;

import static hazel.pycro.Pycro.LOGGER;

public class PycroClient implements ClientModInitializer {
    private static KeyBinding openGuiKey;

    public static Stack<String> stringMessages = new Stack<>();
    public static void onMessage(Text message) {
        stringMessages.push(message.getString());
    }

    @Override
    public void onInitializeClient() {
        openGuiKey = new KeyBinding("key.pycro.opengui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I, "category.pycro.controls");
        KeyBindingHelper.registerKeyBinding(openGuiKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                LOGGER.info("python picker open");

                MinecraftClient.getInstance().setScreen(new PythonInterpreterGui());
            }
        });
    }
}
