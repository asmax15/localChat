package me.asmax.localchat.listener

import me.asmax.localchat.utils.GameStateManager
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent

class ChatListener: Listener {

    @EventHandler
    fun handleChat(event: PlayerChatEvent) {
        var player = event.player
        var msg = event.message
        event.isCancelled = true

        when (GameStateManager.channels.get(player)) {
            "public" -> {
                Bukkit.broadcastMessage("${player.name} §8| §7Public §9>> §7$msg")
            }
            "whisper" -> {
                for (near in Bukkit.getOnlinePlayers()) {
                    if (player.location.distance(near.location) < 5 && player.location.world.name == "world") {
                        near.sendMessage("${player.name} §8| §7Whisper §9>> §7$msg")
                    }
                }
            }
            "local" -> {
                for (near in Bukkit.getOnlinePlayers()) {
                    if (player.location.distance(near.location) < 13 && player.location.world.name == "world") {
                        near.sendMessage("${player.name} §8| §7Local §9>> §7$msg")
                    }
                }
            }
            else -> {
                for (near in Bukkit.getOnlinePlayers()) {
                    if (player.location.distance(near.location) < 13 && player.location.world.name == "world") {
                        near.sendMessage("${player.name} §8| §7Local §9>> §7$msg")
                    }
                }
            }
        }
    }
}