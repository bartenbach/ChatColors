/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.seed419;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

/**
 *
 * @author seed419
 */
public class PlayerChatColorParser implements Listener {

    private String message;
    private String lastMessage;

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        event.setMessage(translateAlternateColorCodes('&', event.getMessage()));
    }

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKk".indexOf(b[i+1]) > -1) {
                b[i] = ChatColor.COLOR_CHAR;
                b[i+1] = Character.toLowerCase(b[i+1]);
            }
        }
        return new String(b);
    }


}
