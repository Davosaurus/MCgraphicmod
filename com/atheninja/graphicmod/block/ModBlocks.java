package com.atheninja.graphicmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
	//Instantiates all mod blocks
	public static BlockReplacable testBlock = new BlockReplacable(Material.CLAY, "testBlock", "furnace");

	//Registers all mod blocks
	public static void register(IForgeRegistry<Block> registry)
	{
		registry.registerAll(
			testBlock
		);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry)
	{
		registry.registerAll(
			testBlock.createItemBlock()
		);
	}
	
	public static void registerModels()
	{
		testBlock.registerItemModel(Item.getItemFromBlock(testBlock));
	}
}
