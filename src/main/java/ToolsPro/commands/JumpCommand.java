package ToolsPro.commands;

import ToolsPro.ToolsPro;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Effect;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class JumpCommand extends Command {

    private ToolsPro plugin;

    public JumpCommand(ToolsPro plugin) {
        super("jump", "Телепортирует тебя в то место, куда смотришь.", "/jump");
        this.setPermission("toolspro.commands.jump");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(this.getPermissionMessage());
        }else if (sender instanceof Player) {
            /*Block block = ((Player) sender).getTargetBlock(100, this.plugin.NON_SOLID_BLOCK);
            if(block == null){
                sender.sendMessage(TextFormat.RED + "There isn't a reachable block");
                return false;
            }
            if(!((Player) sender).getLevel().getBlock(block.add(0, 2)).isSolid()){
                ((Player) sender).teleport(block.add(0, 1));
                return true;
            }
            Integer side = ((Player) sender).getDirection();
            switch(side){
                case 0:
                case 1:
                    side += 3;
                    break;
                case 3:
                    side += 2;
                    break;
                default:
                    break;
            }
            if(!block.getSide(side).isSolid()) {
                ((Player) sender).teleport(block);
            }
            */
        }else{
            sender.sendMessage(TextFormat.colorize("&cПожалуйста, используйте эту команду только в игре!"));
        }
        return true;
    }


}
