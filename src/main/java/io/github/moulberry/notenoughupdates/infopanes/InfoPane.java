package io.github.moulberry.notenoughupdates.infopanes;

import io.github.moulberry.notenoughupdates.NEUManager;
import io.github.moulberry.notenoughupdates.NEUOverlay;
import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import io.github.moulberry.notenoughupdates.core.BackgroundBlur;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public abstract class InfoPane extends Gui {
	final NEUOverlay overlay;
	final NEUManager manager;

	public InfoPane(NEUOverlay overlay, NEUManager manager) {
		this.overlay = overlay;
		this.manager = manager;
	}

	public void reset() {}

	public void tick() {}

	public abstract void render(
		int width, int height, Color bg, Color fg, ScaledResolution scaledresolution, int mouseX,
		int mouseY
	);

	public abstract void mouseInput(int width, int height, int mouseX, int mouseY, boolean mouseDown);

	public void mouseInputOutside() {}

	public abstract boolean keyboardInput();

	public void renderDefaultBackground(int width, int height, Color bg) {
		int paneWidth = (int) (width / 3 * overlay.getWidthMult());
		int rightSide = (int) (width * overlay.getInfoPaneOffsetFactor());
		int leftSide = rightSide - paneWidth;

		int boxLeft = leftSide + overlay.getBoxPadding() - 5;
		int boxRight = rightSide - overlay.getBoxPadding() + 5;

		BackgroundBlur.renderBlurredBackground(NotEnoughUpdates.INSTANCE.config.itemlist.bgBlurFactor,
			width, height,
			boxLeft, overlay.getBoxPadding() - 5,
			boxRight - boxLeft, height - overlay.getBoxPadding() * 2 + 10, true
		);
		drawRect(boxLeft, overlay.getBoxPadding() - 5, boxRight,
			height - overlay.getBoxPadding() + 5, bg.getRGB()
		);
	}

	public static CompletableFuture<? extends InfoPane> create(
		NEUOverlay overlay, NEUManager manager, String infoType,
		String name, String internalName, String infoText
	) {
		switch (infoType.intern()) {
			case "WIKI_URL":
				return HTMLInfoPane.createFromWikiUrl(overlay, manager, name, infoText);
			case "WIKI":
				return CompletableFuture.completedFuture(
					HTMLInfoPane.createFromWikiText(overlay, manager, name, internalName, infoText, false));
			case "HTML":
				return CompletableFuture.completedFuture(
					new HTMLInfoPane(overlay, manager, name, internalName, infoText, false));
			default:
				return CompletableFuture.completedFuture(
					new TextInfoPane(overlay, manager, name, infoText));
		}
	}
}
