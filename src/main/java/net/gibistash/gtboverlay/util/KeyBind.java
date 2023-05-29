package net.gibistash.gtboverlay.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBind {
    public static final String KEY_CATEGORY_GTBOVERLAY = "key.category.gtboverlay.shortcut";

    public static final String KEY_GET_SHORTCUT = "key.gtboverlay.get_shortcut";
    public static final KeyMapping SHORTCUT_KEY = new KeyMapping(KEY_GET_SHORTCUT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_GTBOVERLAY);
}
