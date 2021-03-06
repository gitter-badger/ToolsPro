package ToolsPro.listeners;

import ToolsPro.ToolsPro;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.*;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

import java.io.File;

public class MuteListener implements Listener {

    ToolsPro plugin;

    public MuteListener(ToolsPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onChat(PlayerChatEvent event) {
        Config mute = new Config(new File(this.plugin.getDataFolder(), "mute.yml"), Config.YAML);
        Player player = event.getPlayer();
        if (mute.exists(player.getName().toLowerCase())) {
            if (mute.get(player.getName().toLowerCase(), System.currentTimeMillis()) >= System.currentTimeMillis()) {
                long time = (mute.get(player.getName().toLowerCase(), System.currentTimeMillis()) - System.currentTimeMillis()) / 1000;
                int seconds = NukkitMath.floorDouble(time % 60);
                int minutes = NukkitMath.floorDouble((time % 3600) / 60);
                int hours = NukkitMath.floorDouble(time % (3600 * 24) / 3600);
                int days = NukkitMath.floorDouble(time / (3600 * 24));
                String timemute = days + " days " +
                        hours + " hours " +
                        minutes + " minutes " +
                        seconds + " seconds";
                player.sendMessage(TextFormat.colorize("&7[&aMute&7] &cВы были замучены за нарушение правил чата!\n&7[&aMute&7] &cРазмут через " + timemute));
                event.setCancelled();
            } else {
                mute.remove(player.getName().toLowerCase());
                mute.save();
            }
        }
    }
}