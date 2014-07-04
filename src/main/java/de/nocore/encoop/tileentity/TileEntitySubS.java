package de.nocore.encoop.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySubS extends TileEntity implements IInventory {

	ItemStack[] item = new ItemStack[1];

	public TileEntitySubS() {
		item = new ItemStack[1];
	}

	@Override
	public int getSizeInventory() {
		return item.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return item[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);

		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				  itemstack = itemstack.splitStack(count);
                  if (itemstack.stackSize == 0) {
                          setInventorySlotContents(slot, null);
                  }
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
	      ItemStack stack = getStackInSlot(slot);
          if (stack != null) {
                  setInventorySlotContents(slot, null);
          }
          return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		item[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Submission System";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player
				.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound p_145839_1_) {
		// TODO Auto-generated method stub
		super.readFromNBT(p_145839_1_);
	}

	@Override
	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);
	}
	
	

}
