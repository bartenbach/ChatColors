/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.seed419;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author seed419
 */
public class PrintColors {
    
    public void printcolors(CommandSender sender){
        sender.sendMessage(ChatColor.DARK_RED + "C" + ChatColor.RED + "h" + ChatColor.GOLD + "a" + ChatColor.YELLOW + "t" + ChatColor.GREEN + " C" + ChatColor.DARK_GREEN + "o" + ChatColor.AQUA + "l" + ChatColor.DARK_AQUA + "o" + ChatColor.BLUE + "r" + ChatColor.LIGHT_PURPLE + "s" + ChatColor.DARK_PURPLE + " :)\n");
        sender.sendMessage(ChatColor.DARK_GREEN + "Syntax for iChat Colors is an ampersand '&'");
        sender.sendMessage(ChatColor.DARK_GREEN + "Followed by the following number or letter:");        
    }
    
}
