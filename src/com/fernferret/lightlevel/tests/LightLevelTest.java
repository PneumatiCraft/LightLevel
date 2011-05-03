package com.fernferret.lightlevel.tests;

import junit.framework.Assert;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.liza.*;

public class LightLevelTest extends LizaTest {
	private PluginManager pluginManager;
	
	@Before
	public void findPluginManager() {
		this.pluginManager = Liza.getCraftServer().getPluginManager();
	}
	
	@Test
	public void testLoad() {
		Liza.loadPluginJar("lightlevel-snapshot.jar");
		
		Assert.assertEquals("Unexpected number of loaded plugins", 1, this.pluginManager.getPlugins().length);
		
		Plugin loadedPlugin = this.pluginManager.getPlugin("LightLevel");
		
		Assert.assertNotNull("LightLevel was not found", loadedPlugin);
		Assert.assertTrue("Loaded plugin is not LightLevel", loadedPlugin instanceof com.fernferret.lightlevel.LightLevel);
	}
	
	@Test
	public void testEnable() {
		Liza.enablePlugin("LightLevel");
		
		Assert.assertTrue("LightLevel was not enabled", this.pluginManager.getPlugin("LightLevel").isEnabled());
	}
	
	@Test
	public void testDisable() {
		Liza.disablePlugin("LightLevel");
		
		Assert.assertEquals("Unexpected number of loaded plugins", 1, this.pluginManager.getPlugins().length);
		Assert.assertTrue("LightLevel was unloaded entirely", null != this.pluginManager.getPlugin("LightLevel"));
		
		Assert.assertFalse("LightLevel was not disabled", this.pluginManager.getPlugin("LightLevel").isEnabled());
	}
}
