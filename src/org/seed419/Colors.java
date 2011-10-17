/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.seed419;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author seed419
 */
public class Colors extends JavaPlugin {
    
    PluginManager pm;
    PrintColors printcolors = new PrintColors();
    PluginDescriptionFile pdf;
    static final Logger log = Logger.getLogger("Colors");

    @Override
    public void onDisable() {
        log.info(pdf.getName() + " Version " + pdf.getVersion() + " Disabled");
    }
    
    @Override
    public void onEnable() {
        pdf = this.getDescription();
        log.info(pdf.getName() + " Version " + pdf.getVersion() + " Enabled");        
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("colors")  && sender.hasPermission("Colors.colors")){
            printcolors.printcolors(sender);
            return true;
        }else{
        return false;
        }
    }
    
   
   
    
    
    
}
