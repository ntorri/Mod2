package com.torridigital.mayhem.client.render.blocks;

import com.torridigital.mayhem.Main;
import com.torridigital.mayhem.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {

	public static void preInit() {
		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.propertyBlock), "mayhem:block_properties_black", "mayhem:block_properties_white");
	}
	
	public static void registerBlockRenderer() {
		reg(ModBlocks.mayhemBlock);
		reg(ModBlocks.propertyBlock, 0, "block_properties_white");
		reg(ModBlocks.propertyBlock, 1, "block_properties_black");
		reg(ModBlocks.mayhem_ore);
		reg(ModBlocks.mayhem_multi_ore);
		reg(ModBlocks.modBlockTileEntity);
	}

	public static String modid = Main.MODID;

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	public static void reg(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
