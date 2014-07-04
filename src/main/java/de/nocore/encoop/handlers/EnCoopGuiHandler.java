package de.nocore.encoop.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import de.nocore.encoop.client.gui.GuiSubS;
import de.nocore.encoop.server.container.ContainerSubS;
import de.nocore.encoop.tileentity.TileEntitySubS;

public class EnCoopGuiHandler implements IGuiHandler  {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
	TileEntity tile = world.getTileEntity(x, y, z);
		
	
		switch (ID) {
		case 0:
			if(tile instanceof TileEntitySubS){
				return new ContainerSubS(player.inventory,(TileEntitySubS) tile);
			}
			return null;

		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		
		
		switch (ID) {
		case 0:
			if(tile instanceof TileEntitySubS){
				return new GuiSubS(player.inventory,(TileEntitySubS) tile);
			}
			return null;

		default:
			return null;
		}
	}

}
