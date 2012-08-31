package org.seed419.chatcolors;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.seed419.chatcolors.ChatColors;

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

public class PlayerChatColorParser implements Listener {


    private ChatColors cc;


    public PlayerChatColorParser(ChatColors cc) {
        this.cc = cc;
    }


    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
        if (!cc.hasPerms(event.getPlayer(), "chatcolors.format")) {
            return;
        }
        event.setMessage(customTranslateAlternateColorCodes('&', event.getMessage()));
    }

    public static String customTranslateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] charArray = textToTranslate.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == altColorChar && "0123456789AaBbCcDdEeFfKkNnRrLlMmOo".indexOf(charArray[i+1]) > -1) {
                charArray[i] = ChatColor.COLOR_CHAR;
                charArray[i+1] = Character.toLowerCase(charArray[i+1]);
            }
        }
        return new String(charArray);
    }


}
