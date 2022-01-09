package me.asmax.localchat

import me.asmax.localchat.commands.ChannelCommandExecutor
import me.asmax.localchat.listener.ChatListener
import me.asmax.localchat.listener.JoinListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class LocalChat : JavaPlugin() {

    val prefix = "§8[§9LocalChat§8]§7"

    companion object {
        lateinit var instance: LocalChat
        private set
    }

    override fun onLoad() {
        instance = this
    }

    override fun onEnable() {
        registerCommands()
        registerListener()
    }

    private fun registerCommands() {
        val channelCommand = getCommand("channel") ?: error("An error ocurred while registering the command. This should not happen.")
        channelCommand.setExecutor(ChannelCommandExecutor())
    }

    private fun registerListener() {
        val pluginManager = Bukkit.getPluginManager()

        pluginManager.registerEvents(ChatListener(), this)
        pluginManager.registerEvents(JoinListener(), this)
    }

}