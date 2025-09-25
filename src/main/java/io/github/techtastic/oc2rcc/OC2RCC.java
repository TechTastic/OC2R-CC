package io.github.techtastic.oc2rcc;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(OC2RCC.MODID)
public class OC2RCC {

    public static final String MODID = "oc2rcc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OC2RCC(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
    }
}
