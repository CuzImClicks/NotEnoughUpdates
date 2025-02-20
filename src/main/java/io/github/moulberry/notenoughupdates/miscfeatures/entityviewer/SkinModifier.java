package io.github.moulberry.notenoughupdates.miscfeatures.entityviewer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

public class SkinModifier extends EntityViewerModifier {
    @Override
    public EntityLivingBase applyModifier(EntityLivingBase base, JsonObject info) {
        if (base instanceof GUIClientPlayer) {
            GUIClientPlayer player = (GUIClientPlayer) base;
            if (info.has("cape")) {
                player.overrideCape = new ResourceLocation(info.get("cape").getAsString());
            }
            if (info.has("skin")) {
                player.overrideSkin = new ResourceLocation(info.get("skin").getAsString());
            }
            if (info.has("slim")) {
                player.overrideIsSlim = info.get("slim").getAsBoolean();
            }
            if (info.has("parts")) {
                JsonElement parts = info.get("parts");
                byte partBitField = player.getDataWatcher().getWatchableObjectByte(10);
                if (parts.isJsonPrimitive() && parts.getAsJsonPrimitive().isBoolean()) {
                    partBitField = parts.getAsBoolean() ? (byte) -1 : 0;
                } else {
                    JsonObject obj = parts.getAsJsonObject();
                    for (Map.Entry<String, JsonElement> part : obj.entrySet()) {
                        EnumPlayerModelParts modelPart = EnumPlayerModelParts.valueOf(part.getKey());
                        if (part.getValue().getAsBoolean()) {
                            partBitField |= modelPart.getPartMask();
                        } else {
                            partBitField &= ~modelPart.getPartMask();
                        }
                    }
                }
                player.getDataWatcher().updateObject(10, partBitField);
            }
        }
        return base;
    }
}
