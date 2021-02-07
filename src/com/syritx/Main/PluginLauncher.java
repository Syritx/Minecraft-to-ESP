package com.syritx.Main;

import org.bukkit.event.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class PluginLauncher extends JavaPlugin implements Listener {
	
	CommunicationCenter communication = new CommunicationCenter();
	
	@Override
	public void onEnable() {
		communication.start();
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void breakBlock(BlockBreakEvent event) {
		
		try {
			communication.sendToESP("[MINED: "+event.getBlock().getType().toString()+"]");
		}
		catch(IOException e) {}
	}
}
