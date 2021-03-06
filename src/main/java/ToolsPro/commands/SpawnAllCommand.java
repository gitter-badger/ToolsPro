package ToolsPro.commands;

import ToolsPro.ToolsPro;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Effect;
import cn.nukkit.level.Location;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class SpawnAllCommand extends Command {

    private ToolsPro plugin;

    public SpawnAllCommand(ToolsPro plugin) {
        super("spawnall", "Телепортирует всех игроков на спавн.", "/spawnall");
        this.setPermission("toolspro.commands.spawnall");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(this.getPermissionMessage());
        }else{
            for (Player player : this.plugin.getServer().getOnlinePlayers().values()){
                if (player.equals(sender)) continue;
                player.teleport(Location.fromObject(this.plugin.getServer().getDefaultLevel().getSpawnLocation(), this.plugin.getServer().getDefaultLevel()));
                player.sendMessage(TextFormat.colorize("&7[&aSpawn&7] Вы были телепортированы на спавн!"));
            }
        }
        return true;
    }
}
