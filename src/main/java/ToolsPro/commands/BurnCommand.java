package ToolsPro.commands;

import ToolsPro.ToolsPro;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class BurnCommand extends Command {

    private ToolsPro plugin;

    public BurnCommand(ToolsPro plugin) {
        super("burn", "Поджигает определенного игрока.", "/burn <ник> <время>");
        this.setPermission("toolspro.commands.burn");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(this.getPermissionMessage());
        }else if (args.length == 2) {
            Player p = this.plugin.getServer().getPlayer(args[0]);
            if (p instanceof Player) {
                if (args[1].matches("^[1-9]+\\d*$")) {
                    p.setOnFire(Integer.parseInt(args[1]));
                    sender.sendMessage(TextFormat.colorize("&7[&aBurn&7] &aВы подожгли игрока &b" + p.getName()));
                } else {
                    sender.sendMessage(TextFormat.colorize("&7[&aBurn&7] &cВведите правильное значение времени!"));
                }
            } else {
                sender.sendMessage(TextFormat.colorize("&7[&aBurn&7] &cТакого игрока нет на сервере!"));
            }
        }else{
            sender.sendMessage(TextFormat.colorize("&7[&aBurn&7] &cИспользуйте: /burn <ник> <время>"));
        }
        return true;
    }
}
