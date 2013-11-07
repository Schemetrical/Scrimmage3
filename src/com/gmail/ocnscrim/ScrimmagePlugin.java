package com.gmail.ocnscrim;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

class ScrimmagePlugin {


  private Logger logger;
  
  @Override
  public void onEnable(){
  
    logger = getLogger();
    PluginManager pm = this.getServer().getPluginManager();
    
    logger.info("onEnable envoked");
  }
  
  @Override
  public void onDisable(){
  
  }
  
  
  
}
