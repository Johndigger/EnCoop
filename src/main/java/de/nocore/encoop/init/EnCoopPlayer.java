package de.nocore.encoop.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import de.nocore.encoop.EnCoop;
import de.nocore.encoop.utility.LogHelper;

public class EnCoopPlayer implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "EnCoopSelected";

	
	public List<EnCoopMod> mods;
	public EnCoopMod mod;
	public EnCoopItem item;
	public int amount;
	
	
	public EnCoopPlayer(EntityPlayer player) {
			mod = EnCoop.instance.getRandomMod();
			mods = new ArrayList<EnCoopMod>();
			mods.add(mod);
			item = EnCoop.instance.getRandomItemFromMod(mod);
			amount = 1;
	}

	

	public static final EnCoopPlayer get(EntityPlayer player) {
		return (EnCoopPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {

		NBTTagCompound props = new NBTTagCompound();
		NBTTagCompound modsnbt = new NBTTagCompound();
		for (int i = 0; i < this.mods.size(); i++) {
			modsnbt.setString("mod" + i, mods.get(i).getForgeMod().getModId());
		}
		modsnbt.setInteger("size", mods.size());
		props.setInteger("amount", amount);
		props.setString("activemod", mod.getForgeMod().getModId());
		props.setInteger("item", Item.getIdFromItem(item.getForgeItem()));
		LogHelper.info("saved: "+item.getForgeItem());
		props.setTag("mods", modsnbt);
		compound.setTag(EXT_PROP_NAME, props);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);
		String modid = properties.getString("activemod");
		mods = new ArrayList<EnCoopMod>();
		NBTTagCompound modsnbt = properties.getCompoundTag("mods");
		int numbermods = modsnbt.getInteger("size");
		for (int i = 0; i < numbermods; i++) {
			mods.add(EnCoop.instance.getModById(modsnbt.getString("mod" + i)));
		}
		int itemid = properties.getInteger("item");
		mod = EnCoop.instance.getModById(modid);
	
     	item = new EnCoopItem(Item.getItemById(itemid));	
     	LogHelper.info("loaded:"+item.getForgeItem().getUnlocalizedName());
     	amount = properties.getInteger("amount");

	}

	public static final void register(EntityPlayer player) {
		
		player.registerExtendedProperties(EXT_PROP_NAME, new EnCoopPlayer(
				player));
	}


	
	@Override
	public void init(Entity entity, World world) {
		if(!world.isRemote){
			entity.getExtendedProperties(EXT_PROP_NAME);
		}
	}

}
