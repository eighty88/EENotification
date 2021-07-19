package com.github.eighty88.ee;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = EENotification.MOD_ID)
public class EventHandler {
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onEvent(ClientChatReceivedEvent event) {
        String Message = event.getMessage().getFormattedText();
        if(!Message.matches("\\[.*].*")) {
            if (Message.contains("joined") || Message.contains("left")) {
                String[] str = Utils.stripColor(Message).split(" ", 2);
                if (!str[0].contains(Minecraft.getMinecraft().player.getName())) {
                    Minecraft.getMinecraft().getToastGui().add(new ToastGUI(str[0], str[1]));
                }
                EENotification.logger.log(Level.INFO, Message);
                event.setCanceled(true);
            }
        }
    }
}
