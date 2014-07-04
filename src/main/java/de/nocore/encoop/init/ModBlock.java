package de.nocore.encoop.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.nocore.encoop.block.BlockSubS;
import de.nocore.encoop.tileentity.TileEntitySubS;

public class ModBlock {
 public static final Block subs = new BlockSubS(Material.clay);
 
 public static void init(){ 
	 GameRegistry.registerBlock(subs, "subs");
		GameRegistry.registerTileEntity(TileEntitySubS.class, "subs123");
 }
}
