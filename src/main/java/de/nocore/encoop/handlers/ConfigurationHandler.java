package de.nocore.encoop.handlers;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.nocore.encoop.reference.Reference;
import net.minecraftforge.common.config.Configuration;


public class ConfigurationHandler {
	
	public static Configuration configuration;
	
	public static boolean modsChoosable=true;
	
	public static void init(File file){
		if(configuration==null){
			configuration=new Configuration(file);
			loadConfiguration();		
			
		}
	}
	
	
	private static void loadConfiguration(){
		modsChoosable=configuration.getBoolean("modsChoosable", Configuration.CATEGORY_GENERAL, false, "Unlocked Mod can be choosen by player");
		
		if(configuration.hasChanged()){
			configuration.save();
			
		}
	
	}
	
	 @SubscribeEvent
	 public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event){
		 if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
			 loadConfiguration();
		 }
	 }
	
}
