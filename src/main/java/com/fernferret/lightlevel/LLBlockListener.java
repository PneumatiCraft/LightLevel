package com.fernferret.lightlevel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class LLBlockListener implements Listener {
    private LightLevel plugin;

    public LLBlockListener(LightLevel plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Player p = event.getPlayer();
        if (this.plugin.configLL.getBoolean(LightLevel.WAND_ENABLE_KEY, true) &&
                p.getItemInHand().getTypeId() == this.plugin.configLL.getInt(LightLevel.WAND_KEY, LightLevel.TORCH_ITEM) &&
                this.plugin.playerHasWandEnabled(p)) {
            this.plugin.getLightLevel(p);
            event.setCancelled(true);
        }
    }
}
