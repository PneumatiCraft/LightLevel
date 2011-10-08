package com.fernferret.lightlevel;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;

public class LLBlockListener extends BlockListener {
    private LightLevel plugin;

    public LLBlockListener(LightLevel plugin) {
        this.plugin = plugin;
    }

    @Override
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
