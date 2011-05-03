package com.fernferret.lightlevel.tests;

import junit.framework.Assert;

import org.bukkit.plugin.PluginManager;
import org.junit.Test;

import com.lithium3141.liza.*;

public class LightLevelTest extends LizaTest {
	@Test
	public void testEnable() {
		Liza.loadPluginJar("lightlevel-snapshot.jar");
		
		PluginManager pm = Liza.getCraftServer().getPluginManager();
		
		Assert.assertEquals("Minecraft did not load plugin", 1, pm.getPlugins().length);
		Assert.assertTrue("LightLevel was not found", null != pm.getPlugin("LightLevel"));
	}
	
	@Test
	public void testDisable() {
		PluginManager pm = Liza.getCraftServer().getPluginManager();
		
		Liza.disablePlugin("LightLevel");
		
		Assert.assertEquals("Unexpected number of loaded plugins", 1, pm.getPlugins().length);
		Assert.assertTrue("LightLevel was unloaded entirely", null != pm.getPlugin("LightLevel"));
		
		Assert.assertFalse("LightLevel was not disabled", pm.getPlugin("LightLevel").isEnabled());
	}
}
