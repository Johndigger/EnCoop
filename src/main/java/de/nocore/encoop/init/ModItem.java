package de.nocore.encoop.init;

import cpw.mods.fml.common.registry.GameRegistry;
import de.nocore.encoop.item.ItemCheck;



public class ModItem {

	public static ItemCheck check=new ItemCheck();
	
	public static void init(){
		GameRegistry.registerItem(check, "Check");
	}
	
}
