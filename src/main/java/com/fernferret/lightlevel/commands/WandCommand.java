package com.fernferret.lightlevel.commands;

import com.fernferret.lightlevel.LightLevel;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * Multiverse 2
 *
 * @author fernferret
 */
public class WandCommand extends LightLevelCommand {
    public WandCommand(LightLevel plugin) {
        super(plugin);
        this.setName("Enable/disable the Light Level wand.");
        this.setCommandUsage("/ll wand" + ChatColor.GOLD + "[ON/OFF]");
        this.setArgRange(0, 1);
        this.addKey("ll wand");
        this.addKey("llwand");
        this.setPermission("lightlevel.use", "Displays the Light Level of the block you're looking at.", PermissionDefault.OP);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (sender instanceof Player) {
            this.plugin.togglePlayerWand((Player) sender);
        } else {
            sender.sendMessage("Sorry this command must be run as a player.");
        }

    }
}
