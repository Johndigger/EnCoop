package de.nocore.encoop.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import de.nocore.encoop.EnCoop;

public class BlockSubS extends Block {

	protected BlockSubS(Material p_i45394_1_) {
		super(p_i45394_1_);

		this.setCreativeTab(EnCoop.mainTab);
	}

	public BlockSubS() {
		super(Material.sponge);
		this.setCreativeTab(EnCoop.mainTab);

	}
 
}
