package io.github.moulberry.notenoughupdates.recipes;

import com.google.gson.JsonObject;
import io.github.moulberry.notenoughupdates.NEUManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public enum RecipeType {
	CRAFTING("crafting", "Crafting", CraftingRecipe::parseCraftingRecipe, new ItemStack(Blocks.crafting_table)),
	FORGE("forge", "Forging", ForgeRecipe::parseForgeRecipe, new ItemStack(Blocks.anvil)),
	TRADE("trade", "Trading", VillagerTradeRecipe::parseStaticRecipe, new ItemStack(Items.emerald)),
	MOB_LOOT("drops", "Mob Loot", MobLootRecipe::parseRecipe, new ItemStack(Items.diamond_sword));

	private final String id;
	private final String label;
	private final RecipeFactory recipeFactory;
	private final ItemStack icon;

	RecipeType(String id, String label, RecipeFactory recipeFactory, ItemStack icon) {
		this.id = id;
		this.label = label;
		this.recipeFactory = recipeFactory;
		this.icon = icon;
		icon.setStackDisplayName("neurecipe-" + id);
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public RecipeFactory getRecipeFactory() {
		return recipeFactory;
	}

	public ItemStack getIcon() {
		return icon;
	}

	public NeuRecipe createRecipe(NEUManager manager, JsonObject recipe, JsonObject outputItemJson) {
		return recipeFactory.createRecipe(manager, recipe, outputItemJson);
	}

	public static RecipeType getRecipeTypeForId(String id) {
		for (RecipeType value : values()) {
			if (value.id.equals(id)) return value;
		}
		return null;
	}

	@FunctionalInterface
	interface RecipeFactory {
		NeuRecipe createRecipe(NEUManager manager, JsonObject recipe, JsonObject outputItemJson);
	}
}
