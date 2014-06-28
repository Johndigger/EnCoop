package de.nocore.encoop.proxy;

import java.io.File;

public interface IProxy {

	public abstract void initClientConfiguration(File configFile);

	public abstract void initRenderingAndTextures();

	public abstract void registerKeybindings();

}
