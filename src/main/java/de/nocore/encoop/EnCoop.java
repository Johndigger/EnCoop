package de.nocore.encoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.nocore.encoop.creativetabs.EnCoopTab;
import de.nocore.encoop.handlers.EnCoopGuiHandler;
import de.nocore.encoop.init.EnCoopItem;
import de.nocore.encoop.init.EnCoopMod;
import de.nocore.encoop.init.ModBlock;
import de.nocore.encoop.proxy.IProxy;
import de.nocore.encoop.reference.Reference;


@Mod(modid = Reference.MOD_ID, version = Reference.VERSION )
public class EnCoop {	
	public static final CreativeTabs mainTab = new EnCoopTab(Reference.MOD_ID) ;

	@Instance(Reference.MOD_ID)
	public static EnCoop instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
	
    
	private ArrayList<EnCoopMod> modlist = new ArrayList<EnCoopMod>();
	

	@EventHandler
	public void pre(FMLPreInitializationEvent event) {		
		NetworkRegistry.INSTANCE.registerGuiHandler(EnCoop.instance, new EnCoopGuiHandler());
		proxy.initRenderingAndTextures();

	
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {       
        ModBlock.init();

	}

	@EventHandler
	public void post(FMLPostInitializationEvent event) {
		registerMods();				
		FMLLog.info("EnCoop modlist:"+modlist, this);
		
	}
	
	
	
	

	private void registerMods() {
		// fill item list
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
			modlist.add(emod);

		}

	}

}
