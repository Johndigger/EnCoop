package de.nocore.encoop.init;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.ModContainer;

public class EnCoopMod {

	private ModContainer forgeMod;
	private List<EnCoopItem> items;
	
	public EnCoopMod(ModContainer forgeMod) {
		this.forgeMod=forgeMod;
		this.items=new ArrayList<EnCoopItem>();
	}
	
	public EnCoopMod(ModContainer forgeMod,List<EnCoopItem> items){
		this.forgeMod=forgeMod;
		this.items=items;
	}
	
	
	
	@Override
	public String toString() {
		return forgeMod.getName()+ (hasItems()?"("+items.size()+")"+items:"(X)");
	}

	public boolean hasItems(){
		return items.size()>0?true:false;
	}

	public ModContainer getForgeMod() {
		return forgeMod;
	}

	public void setForgeMod(ModContainer forgeMod) {
		this.forgeMod = forgeMod;
	}

	public List<EnCoopItem> getItems() {
		return items;
	}

	public void setItems(List<EnCoopItem> items) {
		this.items = items;
	}
	
	
}
