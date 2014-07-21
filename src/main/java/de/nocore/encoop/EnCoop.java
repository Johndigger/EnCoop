package de.nocore.encoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.nocore.encoop.creativetabs.EnCoopTab;
import de.nocore.encoop.handlers.ConfigurationHandler;
import de.nocore.encoop.handlers.EnCoopEventHandler;
import de.nocore.encoop.init.EnCoopItem;
import de.nocore.encoop.init.EnCoopMod;
import de.nocore.encoop.init.ModItem;
import de.nocore.encoop.proxy.IProxy;
import de.nocore.encoop.reference.Reference;
import de.nocore.encoop.utility.LogHelper;


@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)
public class EnCoop {	
	public static final CreativeTabs mainTab = new EnCoopTab(Reference.MOD_ID) ;

	@Instance(Reference.MOD_ID)
	public static EnCoop instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
	
    
	
	

	@EventHandler
	public void pre(FMLPreInitializationEvent event) {		
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		MinecraftForge.EVENT_BUS.register(new EnCoopEventHandler());

		//		NetworkRegistry.INSTANCE.registerGuiHandler(EnCoop.instance, new EnCoopGuiHandler());
//		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
//		proxy.initRenderingAndTextures();

	
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {       
//        ModBlock.init();
		ModItem.init();

	}

	@EventHandler
	public void post(FMLPostInitializationEvent event) {
		registerMods();		
	}
	
	
	
	

public ArrayList<EnCoopMod> modlist = new ArrayList<EnCoopMod>();
	
    public void registerMods() {
    	LogHelper.info("Getting mods");		// fill item list
		@SuppressWarnings("unchecked")
		Set<String> items = Item.itemRegistry.getKeys();

		// create mod list
		for (ModContainer mod : Loader.instance().getActiveModList()) {
			List<EnCoopItem> itemlist = new ArrayList<EnCoopItem>();
			for (String itemobject : items) {
				// assemble itemlist
				if (itemobject.startsWith(mod.getModId())) {
					EnCoopItem item = new EnCoopItem(
							(Item) Item.itemRegistry.getObject(itemobject));
					itemlist.add(item);
				}
			}
			// create encoop mod and add to modlist
			EnCoopMod emod = new EnCoopMod(mod, itemlist);
			if(emod.hasItems()){
			modlist.add(emod);
			}

		}
		System.out.println(modlist);
	}
	
	public EnCoopMod getRandomMod(){
		Random rand = new Random();		
		LogHelper.info("Getting Random Mod");
		return modlist.get(rand.nextInt(modlist.size()));
	}
	
	public EnCoopItem getRandomItemFromMod(EnCoopMod mod){
		Random rand = new Random();		
		LogHelper.info("Getting Item from Mod "+mod.getForgeMod().getName());

		return mod.getItems().get(rand.nextInt(mod.getItems().size()));
		
	}

	public EnCoopMod getModById(String modid) {
		for (EnCoopMod enCoopMod : modlist) {
			if (enCoopMod.getForgeMod().getModId().equals(modid)){
				return enCoopMod;
			}
		}
		return null;
	}

	
	public List<EnCoopMod> getModlist() {
		return modlist;
	}



}
