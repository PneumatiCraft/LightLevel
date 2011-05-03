package com.fernferret.lightlevel.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.lithium3141.liza.*;

public class LightLevelTest extends LizaTest {
	@Test
	public void testEnable() {
		try {
			Liza.loadPluginJar("lightlevel-snapshot.jar");
		} catch (Exception e) {
			Assert.fail("Loading plugin failed with exception message: " + e.getMessage());
		}
		
		Assert.assertEquals("Minecraft did not load plugin", 1, Liza.getMinecraftServer().server.getPluginManager().getPlugins().length);
		Assert.assertTrue("LightLevel was not found", null != Liza.getMinecraftServer().server.getPluginManager().getPlugin("LightLevel"));
	}
}
