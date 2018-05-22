package com.atheninja.graphicmod.block;

import java.util.Random;

import com.atheninja.graphicmod.GraphicMod;
import com.atheninja.graphicmod.block.BlockReplacable.ReplaceEventHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockReplacable extends BlockBase
{
	protected String original;
	
	public BlockReplacable(Material material, String name, String original)
	{
		super(material, name);
		this.original = original;
		MinecraftForge.EVENT_BUS.register(new ReplaceEventHandler());
	}
	
	//handles placing the replacement block instead whenever the original is placed
    public class ReplaceEventHandler
    {
	    @SubscribeEvent
	    public void onPlaceBlock(RightClickBlock e)
	    {
	    	if(Block.getBlockFromItem(e.getItemStack().getItem()).getUnlocalizedName().equals("tile." + original))
	    	{
	    		e.setCanceled(true);
	    		new ItemBlock(Block.getBlockFromName(GraphicMod.MODID + ":" + name)).onItemUse(e.getEntityPlayer(), e.getWorld(), e.getPos(), e.getHand(), e.getFace(), (float)e.getHitVec().x, (float)e.getHitVec().y, (float)e.getHitVec().z);
	    	}
	    }
    }
    
    //these two functions make sure the replacement block drops the original block's drops
    public int quantityDropped(Random random)
    {
        return Block.getBlockFromName(original).quantityDropped(random);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Block.getBlockFromName(original).getItemDropped(state, rand, fortune);
    }
}
