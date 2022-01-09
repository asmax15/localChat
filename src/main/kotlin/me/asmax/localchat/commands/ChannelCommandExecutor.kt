package me.asmax.localchat.commands

import me.asmax.localchat.LocalChat
import me.asmax.localchat.utils.GameStateManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ChannelCommandExecutor: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            return true
        }
        var player: Player = sender

        if (args.size != 1) {
            player.sendMessage("${LocalChat.instance.prefix} Bitte verwende: §9/channel <local | public | whisper>")
            return true
        }

        when (args[0]) {
            "local" -> {
                GameStateManager.channels.put(player, "local")
                player.sendMessage("${LocalChat.instance.prefix} Dein Channel wurde gewechselt zu §9§olocal")
            }
            "public" -> {
                GameStateManager.channels.put(player, "public")
                player.sendMessage("${LocalChat.instance.prefix} Dein Channel wurde gewechselt zu §9§opublic")
            }
            "whisper" -> {
                GameStateManager.channels.put(player, "whisper")
                player.sendMessage("${LocalChat.instance.prefix} Dein Channel wurde gewechselt zu §9§owhisper")
            }
            else -> {
                GameStateManager.channels.put(player, "public")
                player.sendMessage("${LocalChat.instance.prefix} Dein Channel wurde gewechselt zu §9§opublic")
            }
        }

        return true
    }
}