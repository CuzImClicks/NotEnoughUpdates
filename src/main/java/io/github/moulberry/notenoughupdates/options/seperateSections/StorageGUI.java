package io.github.moulberry.notenoughupdates.options.seperateSections;

import com.google.gson.annotations.Expose;
import io.github.moulberry.notenoughupdates.core.config.annotations.*;
import org.lwjgl.input.Keyboard;

public class StorageGUI {
	@ConfigOption(
		name = "Storage Overlay",
		desc = ""
	)
	@ConfigEditorAccordion(id = 1)
	public boolean storageOverlayAccordion = false;

	@Expose
	public int selectedIndex = 0;
	@ConfigOption(
		name = "\u00A7cWarning",
		desc = "You need Fast Render and Antialiasing off for these settings to work\n" +
			"You can find these in your video settings"
	)
	@ConfigEditorFSR(
		runnableId = 12,
		buttonText = ""
	)
	@ConfigAccordionId(id = 1)
	public boolean storageGUIWarning = false;
	@Expose
	@ConfigOption(
		name = "Enable Storage GUI",
		desc = "Show a custom storage overlay when accessing /storage. " +
			"Makes switching between pages much easier and also allows for searching through all storages"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean enableStorageGUI3 = true;

	@Expose
	@ConfigOption(
		name = "Storage Height",
		desc = "Change the height of the storage preview section. Increasing this allows more storages to be seen at once"
	)
	@ConfigEditorSlider(
		minValue = 104,
		maxValue = 312,
		minStep = 26
	)
	@ConfigAccordionId(id = 1)
	public int storageHeight = 208;

	@Expose
	@ConfigOption(
		name = "Storage Style",
		desc = "Change the visual style of the overlay"
	)
	@ConfigEditorDropdown(
		values = {"Transparent", "Minecraft", "Grey", "Custom"}
	)
	@ConfigAccordionId(id = 1)
	public int displayStyle = 0;

	@Expose
	@ConfigOption(
		name = "Enderchest Preview",
		desc = "Preview Enderchest pages when hovering over the selector on the left side"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean enderchestPreview = true;

	@Expose
	@ConfigOption(
		name = "Backpack Preview",
		desc = "Preview Backpacks when hovering over the selector on the left side"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean backpackPreview = true;

	@Expose
	@ConfigOption(
		name = "Compact Vertically",
		desc = "Remove the space between backpacks when there is a size discrepancy"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean masonryMode = false;

	@Expose
	@ConfigOption(
		name = "Fancy Glass Panes",
		desc = "Replace the glass pane textures in your storage containers with a fancy connected texture"
	)
	@ConfigEditorDropdown(
		values = {"On", "Locked", "Off"}
	)
	@ConfigAccordionId(id = 1)
	public int fancyPanes = 0;

	@Expose
	@ConfigOption(
		name = "Search Bar Autofocus",
		desc = "Automatically focus the search bar when pressing keys"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean searchBarAutofocus = true;

	@Expose
	@ConfigOption(
		name = "Show Enchant Glint",
		desc = "Toggle enchant glint in storage GUI"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 1)
	public boolean showEnchantGlint = true;

	@Expose
	@ConfigOption(
		name = "Selected Storage Colour",
		desc = "Change the colour used to draw the selected backpack border"
	)
	@ConfigEditorColour
	@ConfigAccordionId(id = 1)
	public String selectedStorageColour = "0:255:255:223:0";

	@Expose
	@ConfigOption(
		name = "Scrollable Tooltips",
		desc = "Support for scrolling tooltips for users with small monitors\n" +
			"This will prevent the menu from scrolling while holding the key, allowing you to scroll tooltips"
	)
	@ConfigEditorKeybind(defaultKey = 0)
	@ConfigAccordionId(id = 1)
	public int cancelScrollKey = 0;

	@ConfigOption(
		name = "Inventory Backpacks",
		desc = ""
	)
	@ConfigEditorAccordion(id = 0)
	public boolean inventorySlotAccordion = false;

	@Expose
	@ConfigOption(
		name = "Inventory Backpacks",
		desc = "Add a \"10th slot\" to your inventory which allows you to quickly access your backpacks"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 0)
	public boolean showInvBackpack = false;

	//public boolean showInvBackpack = false;
	@Expose
	@ConfigOption(
		name = "Scroll to Backpack",
		desc = "Allow scrolling to the backpack using the mouse wheel.\n" +
			"\"Scroll (Key)\" = Allow scrolling to 10th slot only while 'Backpack Scroll Key' (default: SHIFT) is pressed"
	)
	@ConfigEditorDropdown(
		values = {"Scroll (Key)", "Scroll (Always)", "Don't Scroll"}
	)
	@ConfigAccordionId(id = 0)
	public int scrollToBackpack2 = 0;

	@Expose
	@ConfigOption(
		name = "Backpack Side",
		desc = "Set which side of the hotbar the backpack slot shows"
	)
	@ConfigEditorDropdown(
		values = {"Left", "Right"}
	)
	@ConfigAccordionId(id = 0)
	public int backpackHotbarSide = 0;

	@Expose
	@ConfigOption(
		name = "Backpack Peeking",
		desc = "When the backpack is selected, show it's contents on your screen"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 0)
	public boolean showInvBackpackPreview = true;

	@Expose
	@ConfigOption(
		name = "Backpack Opacity%",
		desc = "Change the opacity of the backpack preview background"
	)
	@ConfigEditorSlider(
		minValue = 0,
		maxValue = 100,
		minStep = 5
	)
	@ConfigAccordionId(id = 0)
	public int backpackOpacity = 50;

	@Expose
	@ConfigOption(
		name = "Backpack Scroll Key",
		desc = "Change the key which needs to be pressed in order to allow backpacks to be scrolled between"
	)
	@ConfigEditorKeybind(defaultKey = Keyboard.KEY_LSHIFT)
	@ConfigAccordionId(id = 0)
	public int backpackScrollKey = Keyboard.KEY_LSHIFT;

	@Expose
	@ConfigOption(
		name = "Backpack Hotkey",
		desc = "Hotkey to quickly switch to the backpack slot"
	)
	@ConfigEditorKeybind(defaultKey = Keyboard.KEY_GRAVE)
	@ConfigAccordionId(id = 0)
	public int backpackHotkey = Keyboard.KEY_GRAVE;

	@Expose
	@ConfigOption(
		name = "Arrow Key Backpacks",
		desc = "Use arrow keys [LEFT],[RIGHT] to move between backpacks and [DOWN] to navigate backpack even when the slot is not selected. Keys are customizable below"
	)
	@ConfigEditorBoolean
	@ConfigAccordionId(id = 0)
	public boolean arrowKeyBackpacks = false;

	@ConfigOption(
		name = "Arrow Key Backpack Keybinds",
		desc = ""
	)
	@ConfigEditorAccordion(id = 2)
	@ConfigAccordionId(id = 0)
	public boolean backpackArrowAccordion = false;

	@Expose
	@ConfigOption(
		name = "Backpack Left",
		desc = "Select the backpack to the left"
	)
	@ConfigEditorKeybind(defaultKey = Keyboard.KEY_LEFT)
	@ConfigAccordionId(id = 2)
	public int arrowLeftKey = Keyboard.KEY_LEFT;

	@Expose
	@ConfigOption(
		name = "Backpack Right",
		desc = "Select the backpack to the right"
	)
	@ConfigEditorKeybind(defaultKey = Keyboard.KEY_RIGHT)
	@ConfigAccordionId(id = 2)
	public int arrowRightKey = Keyboard.KEY_RIGHT;

	@Expose
	@ConfigOption(
		name = "Backpack Open",
		desc = "Open the selected backpack"
	)
	@ConfigEditorKeybind(defaultKey = Keyboard.KEY_DOWN)
	@ConfigAccordionId(id = 2)
	public int arrowDownKey = Keyboard.KEY_DOWN;
}
