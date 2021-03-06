package ToolsPro.commands;

import ToolsPro.ToolsPro;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Effect;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class SetSpawnCommand extends Command {

    private ToolsPro plugin;

    public SetSpawnCommand(ToolsPro plugin) {
        super("setspawn", "Устанавливает точку спавна.", "setspawn");
        this.setPermission("toolspro.commands.setspawn");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(this.getPermissionMessage());
        }else if (sender instanceof Player) {
            ((Player) sender).getLevel().setSpawnLocation(((Player) sender));
            ((Player) sender).getServer().setDefaultLevel(((Player) sender).getLevel());
            ((Player) sender).sendMessage(TextFormat.colorize("&eТочка спавна игроков успешно установлена!"));
            this.plugin.getServer().getLogger().info("Server's spawn point set to " + ((Player) sender).getLevel().getName() + " by " + ((Player) sender).getName());
        }else{
            sender.sendMessage(TextFormat.colorize("&cПожалуйста, используйте эту команду только в игре!"));
        }
        return true;
    }
}
