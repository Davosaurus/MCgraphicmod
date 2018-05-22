package com.atheninja.graphicmod;

import com.atheninja.graphicmod.block.*;
import com.atheninja.graphicmod.block.BlockReplacable.ReplaceEventHandler;
import com.atheninja.graphicmod.item.ModItems;
import com.atheninja.graphicmod.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = GraphicMod.MODID, name = GraphicMod.NAME, version = GraphicMod.VERSION)
public class GraphicMod
{
    public static final String MODID = "graphicmod";
    public static final String NAME = "Graphic Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;
    
    @SidedProxy(serverSide = "com.atheninja.graphicmod.proxy.CommonProxy", clientSide = "com.atheninja.graphicmod.proxy.ClientProxy")
    public static CommonProxy proxy;
    
    //block registration
    @Mod.EventBusSubscriber
    public static class RegistrationHandler
    {
    	@SubscribeEvent
    	public static void registerBlocks(RegistryEvent.Register<Block> event)
    	{
    		ModBlocks.register(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event)
    	{
    		ModItems.register(event.getRegistry());
    		ModBlocks.registerItemBlocks(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerModels(ModelRegistryEvent event)
    	{
    		ModItems.registerModels();
    		ModBlocks.registerModels();
    	}
    }
    
    //other miscellaneous events
    @Mod.EventBusSubscriber
    public static class MyEventHandler
    {
    	
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("This is a debug message wooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    }
}
