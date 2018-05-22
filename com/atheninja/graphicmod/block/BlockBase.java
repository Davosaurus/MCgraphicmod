package com.atheninja.graphicmod.block;

import com.atheninja.graphicmod.GraphicMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
	protected String name;
	
	public BlockBase(Material material, String name)
	{
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	//makes an ItemBlock and returns a reference as an item
	//used for registering ItemBlocks
	public Item createItemBlock()
	{
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	public void registerItemModel(Item itemBlock)
	{
		GraphicMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
}
