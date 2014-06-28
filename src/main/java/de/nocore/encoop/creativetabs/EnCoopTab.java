package de.nocore.encoop.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class EnCoopTab extends CreativeTabs {
	
	public EnCoopTab(String label) {
		
		super(label);
	}
	
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.dragon_egg);
	}
}
