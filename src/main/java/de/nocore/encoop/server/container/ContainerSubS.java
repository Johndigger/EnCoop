package de.nocore.encoop.server.container;

import de.nocore.encoop.tileentity.TileEntitySubS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerSubS extends Container{

	protected TileEntitySubS entity;
	
	public ContainerSubS(IInventory playerInv, TileEntitySubS entity) {
		this.entity=entity;
        addSlotToContainer(new Slot(entity, 0, 10, 10));
        

	}
	
	 protected void bindPlayerInventory(IInventory inventoryPlayer) {
         for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 9; j++) {
                         addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                         8 + j * 18, 84 + i * 18));
                 }
         }

         for (int i = 0; i < 9; i++) {
                 addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
         }
 }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entity.isUseableByPlayer(player);
	}

}
