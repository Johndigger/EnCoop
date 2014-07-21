package de.nocore.encoop.item;

import com.sun.imageio.plugins.common.I18N;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import de.nocore.encoop.EnCoop;
import de.nocore.encoop.init.EnCoopMod;
import de.nocore.encoop.init.EnCoopPlayer;

public class ItemCheck extends Item{
	
	

	public ItemCheck() {
		super();
		this.setCreativeTab(EnCoop.mainTab);
		this.setUnlocalizedName("check");
		this.setTextureName("encoop:check");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		if(!world.isRemote){
			if(player.isSneaking()){
				EnCoopPlayer ep=EnCoopPlayer.get(player);
				ep.mod=EnCoop.instance.getRandomMod();
				ep.item=EnCoop.instance.getRandomItemFromMod(ep.mod);
				ep.amount=1;
				
			}else{
			EnCoopPlayer ep=EnCoopPlayer.get(player);
			//System.out.println(ep);
			player.addChatMessage(new ChatComponentText("Your Item is: "+ep.amount+"x "+I18n.format(ep.item.getForgeItem().getUnlocalizedName()+".name")+" from "+ep.mod.getForgeMod().getName()));
			}
		}
		return itemstack;
	}

	
}
