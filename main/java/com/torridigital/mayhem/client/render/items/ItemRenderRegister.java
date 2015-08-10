package com.torridigital.mayhem.client.render.items;

import com.torridigital.mayhem.Main;
import com.torridigital.mayhem.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
	
	public static void preInit() {
		ModelBakery.addVariantName(ModItems.metaItem, "mayhem:meta_item_white", "mayhem:meta_item_black");
	}
	
	public static void registerItemRenderer() {
		reg(ModItems.mayhemItem);
		reg(ModItems.metaItem, 0, "meta_item_white");
		reg(ModItems.metaItem, 1, "meta_item_black");
		reg(ModItems.mayhemPickaxe);
		reg(ModItems.mayhemAxe);
		reg(ModItems.mayhemSpade);
		reg(ModItems.mayhemHoe);
		reg(ModItems.mayhemSword);
		reg(ModItems.mayhemMultitool);
		
		reg(ModItems.mayhemHelmet);
		reg(ModItems.mayhemChestplate);
		reg(ModItems.mayhemLeggings);
		reg(ModItems.mayhemBoots);
		
		reg(ModItems.chocolate);
		reg(ModItems.luckyCandy);
	}

	//==========================================================================

	public static String modid = Main.MODID;

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void reg(Item item, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
