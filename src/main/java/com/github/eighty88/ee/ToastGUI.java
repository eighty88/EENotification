package com.github.eighty88.ee;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;

public class ToastGUI implements IToast {
    private static final long VISIBLE_TIME = 3000;
    private final String USERID;
    private final String Message;
    private final ItemStack head;

    public ToastGUI(String USERID, String Message) {
        this.USERID = USERID;
        this.Message = Message;
        this.head = GetCustomHead(USERID);
    }

    @Override
    public Visibility draw(GuiToast toastGui, long delta) {
        Minecraft mc = toastGui.getMinecraft();

        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        mc.getTextureManager().bindTexture(TEXTURE_TOASTS);
        toastGui.drawTexturedModalRect(0, 0, 0, 0, 160, 32);

        mc.fontRenderer.drawString(USERID, 8, 7, 0xFFFFFF00);
        mc.fontRenderer.drawString(Message, 8, 18, 0xFFFFFFFF);

        /*
         mc.fontRenderer.drawString(USERID, 30, 7, 0xFFFFFF00);
         mc.fontRenderer.drawString(Message, 30, 18, 0xFFFFFFFF);

         RenderHelper.enableGUIStandardItemLighting();
         toastGui.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(null, head, 8, 8);
        */

        return delta >= VISIBLE_TIME ? IToast.Visibility.HIDE : IToast.Visibility.SHOW;
    }

    private ItemStack GetCustomHead(String playerName) {
        ItemStack customHead = new ItemStack(Items.SKULL, 1, 3);
        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("SkullOwner", new NBTTagString(playerName));
        customHead.setTagCompound(compound);
        return customHead;
    }
}
