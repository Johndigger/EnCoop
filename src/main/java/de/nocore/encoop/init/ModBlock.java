package de.nocore.encoop.init;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import de.nocore.encoop.block.BlockSubS;

public class ModBlock {
 public static final Block subs = new BlockSubS();
 public static void init(){
	 GameRegistry.registerBlock(subs, "subs");
 }
}
