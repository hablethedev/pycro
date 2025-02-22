package hazel.pycro;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.io.File;
import java.io.IOException;

import static hazel.pycro.Pycro.LOGGER;

public class PycroClient implements ClientModInitializer {
    private final File firstRunFile = new File(FabricLoader.getInstance().getConfigDir().toAbsolutePath() + "/pycro_first_run");

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (!firstRunFile.exists()) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("Hey, it looks like this is your first time running Pycro!\n" +
                        "Please configure the Python interpreter to use in the config."
                ));
                try {
                    firstRunFile.createNewFile();
                } catch (IOException e) {
                    LOGGER.error("Failed to create first run file");
                    LOGGER.error(e.getMessage());
                }
            }
        });
    }
}
