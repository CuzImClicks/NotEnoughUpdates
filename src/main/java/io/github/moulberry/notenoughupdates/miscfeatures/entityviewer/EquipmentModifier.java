package io.github.moulberry.notenoughupdates.miscfeatures.entityviewer;

import com.google.gson.JsonObject;
import io.github.moulberry.notenoughupdates.NEUManager;
import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class EquipmentModifier extends EntityViewerModifier {

	private ItemStack createItem(String item) {
		NEUManager manager = NotEnoughUpdates.INSTANCE.manager;
		String[] split = item.split("#");
		if (split.length == 2) {
			switch (split[0].intern()) {
				case "LEATHER_LEGGINGS":
					return coloredLeatherArmor(Items.leather_leggings, split[1]);
				case "LEATHER_HELMET":
					return coloredLeatherArmor(Items.leather_helmet, split[1]);
				case "LEATHER_CHESTPLATE":
					return coloredLeatherArmor(Items.leather_chestplate, split[1]);
				case "LEATHER_BOOTS":
					return coloredLeatherArmor(Items.leather_boots, split[1]);
				default:
					throw new RuntimeException("Unknown leather piece: " + item);
			}
		}
		return manager.createItem(item);
	}

	private ItemStack coloredLeatherArmor(ItemArmor item, String colorHex) {
		ItemStack is = new ItemStack(item);
		item.setColor(is, Integer.parseInt(colorHex, 16));
		return is;
	}

	@Override
	public EntityLivingBase applyModifier(EntityLivingBase base, JsonObject info) {
		if (info.has("hand"))
			setCurrentItemOrArmor(base, 0, createItem(info.get("hand").getAsString()));
		if (info.has("helmet"))
			setCurrentItemOrArmor(base, 4, createItem(info.get("helmet").getAsString()));
		if (info.has("chestplate"))
			setCurrentItemOrArmor(base, 3, createItem(info.get("chestplate").getAsString()));
		if (info.has("leggings"))
			setCurrentItemOrArmor(base, 2, createItem(info.get("leggings").getAsString()));
		if (info.has("feet"))
			setCurrentItemOrArmor(base, 1, createItem(info.get("feet").getAsString()));
		return base;
	}

	public void setCurrentItemOrArmor(EntityLivingBase entity, int slot, ItemStack itemStack) {
		if (entity instanceof EntityPlayer) {
			setPlayerCurrentItemOrArmor((EntityPlayer) entity, slot, itemStack);
		} else {
			entity.setCurrentItemOrArmor(slot, itemStack);
		}
	}

	// Biscuit person needs to learn how to code and not fuck up valid vanilla behaviour
	public static void setPlayerCurrentItemOrArmor(EntityPlayer player, int slot, ItemStack itemStack) {
		if (slot == 0) {
			player.inventory.mainInventory[player.inventory.currentItem] = itemStack;
		} else {
			player.inventory.armorInventory[slot - 1] = itemStack;
		}
	}

}
