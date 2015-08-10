package com.torridigital.mayhem.crafting;

import com.torridigital.mayhem.blocks.ModBlocks;
import com.torridigital.mayhem.items.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.mayhemBlock),	"##","##",	'#', ModItems.mayhemItem);
		//or: GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock), new Object[]{"##","##", '#', ModItems.tutorialItem});

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mayhemItem), Items.redstone, new ItemStack(Items.dye, 1, 4));
		//or: GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tutorialItem), new Object[]{Items.redstone, new ItemStack(Items.dye, 1, 4)});

		GameRegistry.addSmelting(Items.diamond, new ItemStack(ModItems.mayhemItem), 1.0f);
	}
}
