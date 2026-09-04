package uk.org.flushedpancake.animaldespawn;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class AnimalDespawnPlugin extends JavaPlugin {
    private DespawnManager manager;
    private BukkitTask task;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        manager = new DespawnManager(this);
        Bukkit.getPluginManager().registerEvents(manager, this);
        getCommand("animaldespawn").setExecutor(new AnimalDespawnCommand(this, manager));

        scheduleManager();
        getLogger().info("AnimalDespawn enabled. Preset: " + manager.getPreset());
    }

    private void scheduleManager() {
        if (task != null) {
            task.cancel();
        }

        long interval = Math.max(1L, manager.getScanInterval());
        task = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                manager.tick(interval);
            }
        }, interval, interval);
    }

    @Override
    public void onDisable() {
        if (task != null) {
            task.cancel();
        }
        if (manager != null) {
            manager.save();
        }
    }
}
