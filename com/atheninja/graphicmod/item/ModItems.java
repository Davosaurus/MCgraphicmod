package com.atheninja.graphicmod.item;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
	//Instantiates all mod items
	public static ItemBase testItem = new ItemBase("testItem");

	//Registers all mod items
	public static void register(IForgeRegistry<Item> registry)
	{
		registry.registerAll(
			testItem
		);
	}
	
	public static void registerModels()
	{
		testItem.registerItemModel();
	}
}
