package com.fernferret.lightlevel.commands;

import com.fernferret.lightlevel.LightLevel;
import com.pneumaticraft.commandhandler.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class LightLevelCommand extends Command {

    protected LightLevel plugin;

    public LightLevelCommand(LightLevel plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public abstract void runCommand(CommandSender sender, List<String> args);

}
