package de.nocore.encoop.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.nocore.encoop.init.EnCoopPlayer;
import de.nocore.encoop.utility.LogHelper;

public class EnCoopEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			LogHelper.debug("constructing Player");
			if (!event.entity.worldObj.isRemote) {
				if (EnCoopPlayer.get((EntityPlayer) event.entity) == null) {
					LogHelper.debug("registering Player");
					EnCoopPlayer.register((EntityPlayer) event.entity);

				}
			}
		}
	}

}
