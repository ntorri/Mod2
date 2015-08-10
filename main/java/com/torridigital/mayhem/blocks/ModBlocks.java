package com.torridigital.mayhem.blocks;

import com.torridigital.mayhem.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block mayhemBlock;
	public static Block propertyBlock;
	public static Block mayhem_ore;
	public static Block mayhem_multi_ore;
	public static Block modBlockTileEntity;

	public static void createBlocks() {
	    GameRegistry.registerBlock(mayhemBlock = new BasicBlock("mayhem_block").setLightLevel(1.0f), "mayhem_block");
	    GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties"), ItemBlockMeta.class, "block_properties");
	    GameRegistry.registerBlock(mayhem_ore = new ModBlockOre("mayhem_ore", Material.rock, ModItems.mayhemItem, 2, 4), "mayhem_ore");
		GameRegistry.registerBlock(mayhem_multi_ore = new ModBlockMultiOre("mayhem_multi_ore", Material.rock), "mayhem_multi_ore");
		GameRegistry.registerBlock(modBlockTileEntity = new ModBlockTileEntity("tile_entity"), "tile_entity");
	}
}
