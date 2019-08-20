package fr.Rgld_.PexTab;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.PermissionEntity;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import ru.tehkode.permissions.events.PermissionEntityEvent;

public final class PexTab extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        if(Bukkit.getPluginManager().getPlugin("PermissionsEx") == null){
            System.out.println("You must install PermissionEx if you want that this plugin work.");
            this.setEnabled(false);
        }
        Bukkit.getPluginManager().registerEvents(this, this);
    }


    @EventHandler
    public void onPermChange(PermissionEntityEvent e){
        PermissionEntity ent = e.getEntity();
        if(ent.getType().equals(PermissionEntity.Type.USER)){
            PermissionUser user = PermissionsEx.getUser(ent.getName());
            Player p = user.getPlayer();
            p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', user.getPrefix() + p.getName() + user.getSuffix()));
        }
    }

}
