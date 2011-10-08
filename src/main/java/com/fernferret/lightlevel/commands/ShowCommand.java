package com.fernferret.lightlevel.commands;

import com.fernferret.lightlevel.LightLevel;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * Multiverse 2
 *
 * @author fernferret
 */
public class ShowCommand extends LightLevelCommand {
    public ShowCommand(LightLevel plugin) {
        super(plugin);
        this.setName("Display a block's light level.");
        this.setCommandUsage("/ll ");
        this.setArgRange(0, 0);
        this.addKey("ll");
        this.setPermission("lightlevel.use", "Displays the Light Level of the block you're looking at.", PermissionDefault.OP);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (sender instanceof Player) {
            this.plugin.getLightLevel((Player) sender);
        } else {
            sender.sendMessage("This command must be run as a player!");
        }
    }
}
