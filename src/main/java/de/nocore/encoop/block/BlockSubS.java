package de.nocore.encoop.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.nocore.encoop.EnCoop;
import de.nocore.encoop.reference.GuiIds;

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
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z,
				p_149749_5_, p_149749_6_);
		
	}



	private void dropItems(World world, int x, int y, int z){
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack item = inventory.getStackInSlot(i);

                if (item != null && item.stackSize > 0) {
                        float rx = rand.nextFloat() * 0.8F + 0.1F;
                        float ry = rand.nextFloat() * 0.8F + 0.1F;
                        float rz = rand.nextFloat() * 0.8F + 0.1F;

                        EntityItem entityItem = new EntityItem(world,
                                        x + rx, y + ry, z + rz,
                                        new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                        if (item.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                        }

                        float factor = 0.05F;
                        entityItem.motionX = rand.nextGaussian() * factor;
                        entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                        entityItem.motionZ = rand.nextGaussian() * factor;
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                }
        }
}



	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return null;
	}
}
