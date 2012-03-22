/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.seed419;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author seed419
 */
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


public class ChatColors extends JavaPlugin {

    private PluginManager pm;
    private PrintColors printcolors = new PrintColors();
    private PlayerChatColorParser parser;
    private PluginDescriptionFile pdf;
    static final Logger log = Logger.getLogger("Colors");

    @Override
    public void onDisable() {
        log.info(pdf.getName() + " Version " + pdf.getVersion() + " Disabled");
    }

    @Override
    public void onEnable() {
        pdf = this.getDescription();
        parser = new PlayerChatColorParser();
        pm = getServer().getPluginManager();
        pm.registerEvents(parser, this);
        log.info(pdf.getName() + " Version " + pdf.getVersion() + " Enabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("colors"))
        {
            printcolors.printcolors(sender);
            return true;
        }else if(label.equalsIgnoreCase("rb")){
            printcolors.rainbowize(sender, args);
            return true;
        }else{
            return false;
        }

    }
}