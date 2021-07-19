package com.github.eighty88.ee;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = EENotification.MOD_ID, name = EENotification.MOD_NAME, version = EENotification.VERSION)
public class EENotification {

    public static final String MOD_ID = "eenotification";
    public static final String MOD_NAME = "EENotification";
    public static final String VERSION = "1.0-SNAPSHOT";

    public static Logger logger;

    @Mod.Instance(MOD_ID)
    public static EENotification INSTANCE;

    public EENotification() {
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }
}
