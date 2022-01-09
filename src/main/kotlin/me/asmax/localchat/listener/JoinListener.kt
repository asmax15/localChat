package me.asmax.localchat.listener

import me.asmax.localchat.LocalChat
import me.asmax.localchat.utils.GameStateManager
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinListener: Listener {

    @EventHandler
    fun handleJoin(event: PlayerJoinEvent) {
        var player: Player = event.player

        if (!GameStateManager.channels.containsKey(player)) {
            GameStateManager.channels.put(player, "local")
            player.sendMessage("${LocalChat.instance.prefix} §7Dein channel wurde auf §9§olocal §r§7festgelegt")
        }
    }
}