package de.nocore.encoop.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.nocore.encoop.EnCoop;
import de.nocore.encoop.reference.GuiIds;
import de.nocore.encoop.tileentity.TileEntitySubS;

public class BlockSubS extends BlockContainer implements ITileEntityProvider {

	public BlockSubS(Material p_i45394_1_) {
		super(p_i45394_1_);

		this.setBlockTextureName("encoop:subs");
		this.setBlockName("subs");
		this.setCreativeTab(EnCoop.mainTab);
	}

	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon sideIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon frontIcon;

	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 0 || side == 1) {
			return topIcon;
		} else if (side == 2) {
			return frontIcon;
		} else {
			return sideIcon;
		}
	}
	
	

	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		FMLNetworkHandler.openGui(player, EnCoop.instance, GuiIds.SUBS, world, x, y, z);
		return true;
		
	
	}



	@Override
	public void registerBlockIcons(IIconRegister iconr) {
		topIcon = iconr.registerIcon("encoop:subs_top");
		sideIcon = iconr.registerIcon("encoop:subs_side");
		frontIcon = iconr.registerIcon("encoop:subs_front");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySubS();
	}

}
