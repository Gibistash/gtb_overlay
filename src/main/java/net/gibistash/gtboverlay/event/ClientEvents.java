package net.gibistash.gtboverlay.event;

import net.gibistash.gtboverlay.GtbOverlay;
import net.gibistash.gtboverlay.util.KeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.gibistash.gtboverlay.util.ShortcutThemes;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = GtbOverlay.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void chatMessage(ClientChatEvent event){
            if(event.getMessage().contains("!solve")){
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("A cheating report has been submitted to hypixel. who do u think made this mod? ilone??" ));
                event.setCanceled(true);
                return;
            }
            if(event.getMessage().contains("!test")){
                Minecraft.getInstance().player.sendSystemMessage(Component.literal(event.getMessage()));
            }
            if(event.getMessage().toLowerCase().contains("mommydinoo")&&!event.getMessage().contains("/")){
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("I'm always listening ;)"));
            }
            if(event.getMessage().toLowerCase().contains("!help")){
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("!shortcut <Theme with spaces> - returns a shortcut if there is one\n!solve <wordhint>"));
                event.setCanceled(true);
            }
            if (event.getMessage().length()>10&&event.getMessage().substring(0, 9).equals("!shortcut")) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("searching..."));
                Minecraft.getInstance().player.sendSystemMessage(Component.literal(ShortcutThemes.WordBurger(event.getMessage().substring(10))));
                event.setCanceled(true);
            }
        }
        @SubscribeEvent
        public static void onKeyInput(InputEvent event) {
            if (KeyBind.SHORTCUT_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage((Component.literal("WASSUP DQAWG")));
            }
        }
        @SubscribeEvent
        public static void onLivingHurt(LivingHurtEvent event){
            if(event.getEntity() instanceof Sheep){
                if(event.getSource().getEntity() instanceof Player player) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " is an ANIMAL ABUSER!" ));
                }
            }
        }
    }
    @Mod.EventBusSubscriber(modid = GtbOverlay.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBind.SHORTCUT_KEY);
        }
    }

}
