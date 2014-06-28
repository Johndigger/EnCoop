package de.nocore.encoop.init;

import net.minecraft.item.Item;

public class EnCoopItem{

	private Item forgeItem;
	
	public EnCoopItem(Item forgeItem) {
		this.forgeItem = forgeItem;
	}
	
	@Override
	public String toString() {
		return "[" + forgeItem.getUnlocalizedName() + "]";
	}
	
	public Item getForgeItem() {
		return forgeItem;
	}

	public void setForgeItem(Item forgeItem) {
		this.forgeItem = forgeItem;
	}
	
	
	
}
