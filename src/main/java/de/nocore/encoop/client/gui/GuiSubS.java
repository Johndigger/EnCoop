package de.nocore.encoop.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import de.nocore.encoop.reference.Reference;
import de.nocore.encoop.server.container.ContainerSubS;
import de.nocore.encoop.tileentity.TileEntitySubS;

public class GuiSubS extends GuiContainer{

	public GuiSubS(IInventory inventoryPlayer, TileEntitySubS entity) {
		super(new ContainerSubS(inventoryPlayer, entity));
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
	    this.mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID,"textures/gui/subs.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            this.fontRendererObj.drawString("Tiny", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }






}
