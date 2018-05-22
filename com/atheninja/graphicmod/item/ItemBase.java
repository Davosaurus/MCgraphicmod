package com.atheninja.graphicmod.item;

import com.atheninja.graphicmod.GraphicMod;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	protected String name;
	
	public ItemBase(String name)
	{
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel()
	{
		GraphicMod.proxy.registerItemRenderer(this, 0, name);
	}
}
