package hazel.pycro;

import hazel.pycro.config.PycroConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pycro implements ModInitializer {
    public static final String MOD_ID = "pycro";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final PycroConfig CONFIG = PycroConfig.createAndLoad();

    @Override
    public void onInitialize() {
        LOGGER.info("uhh... hi.");
    }
}
