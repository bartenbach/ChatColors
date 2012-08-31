package org.seed419.chatcolors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*  Attribute Only (Public) License
        Version 0.a3, July 11, 2011

    Copyright (C) 2012 Blake Bartenbach <seed419@gmail.com> (@seed419)

    Anyone is allowed to copy and distribute verbatim or modified
    copies of this license document and altering is allowed as long
    as you attribute the author(s) of this license document / files.

    ATTRIBUTE ONLY PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

      1. Attribute anyone attached to the license document.
         * Do not remove pre-existing attributes.

         Plausible attribution methods:
            1. Through comment blocks.
            2. Referencing on a site, wiki, or about page.

      2. Do whatever you want as long as you don't invalidate 1.


@license AOL v.a3 <http://aol.nexua.org>*/

//TODO word wrapping bleh

/*
 * Changelog:
 * Updated source just a tad
 */

public class ChatColors extends JavaPlugin {


    private PluginManager pm;
    private final PrintColors printcolors = new PrintColors(this);
    private final PlayerChatColorParser parser = new PlayerChatColorParser(this);


    @Override
    public void onEnable() {
        pm = getServer().getPluginManager();
        pm.registerEvents(parser, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
        if (label.equalsIgnoreCase("colors") || label.equalsIgnoreCase("colours")) {
            if (sender instanceof Player) {
                if (!hasPerms(player, "chatcolors.colors")) {
                    return false;
                }
            }
            printcolors.printcolors(sender);
            return true;
        } else if(label.equalsIgnoreCase("rb")) {
            if (sender instanceof Player) {
                if (!hasPerms(player, "chatcolors.rainbow")) {
                    return false;
                }
            }
            printcolors.rainbowize(sender, args);
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPerms(Player player, String permission) {
        return (player.hasPermission(permission) || player.hasPermission("chatcolors.*") || player.isOp());
    }
}
