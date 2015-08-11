package com.torridigital.mayhem.items;

import com.torridigital.mayhem.CreeperTab;
import com.torridigital.mayhem.client.render.items.MetaItem;
import com.torridigital.mayhem.client.render.items.ModItemAdvancedFood;
import com.torridigital.mayhem.client.render.items.ModItemFood;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static final CreeperTab tabCreeper = new CreeperTab("tabCreeper");
	
	public static ToolMaterial MAYHEM = EnumHelper.addToolMaterial("MAYHEM", 3, 1000, 15.0F, 4.0F, 30);
	public static ArmorMaterial MAYHEMA = EnumHelper.addArmorMaterial("MAYHEMA", "mayhem:mayhem", 16, new int[]{3, 8, 6, 3}, 30);
	
	public static Item mayhemItem;
	public static Item metaItem;
	
	public static Item mayhemPickaxe;
	public static Item mayhemAxe;
	public static Item mayhemSpade;
	public static Item mayhemHoe;
	public static Item mayhemSword;
	public static Item mayhemMultitool;
	
	public static Item mayhemHelmet;
	public static Item mayhemChestplate;
	public static Item mayhemLeggings;
	public static Item mayhemBoots;
	
	public static Item chocolate;
	public static Item luckyCandy;

	public static void createItems() {
		GameRegistry.registerItem(mayhemItem = new BasicItem("mayhem_item"), "mayhem_item");
		mayhemItem.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(metaItem 		= new MetaItem("meta_item"), "meta_item");
		metaItem.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemPickaxe = new ItemModPickaxe("mayhem_pickaxe", MAYHEM), "mayhem_pickaxe");
		mayhemPickaxe.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemAxe = new ItemModAxe("mayhem_axe", MAYHEM), "mayhem_axe");
		mayhemAxe.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemSpade = new ItemModSpade("mayhem_spade", MAYHEM), "mayhem_spade");
		mayhemSpade.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemHoe = new ItemModHoe("mayhem_hoe", MAYHEM), "mayhem_hoe");
		mayhemHoe.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemSword = new ItemModSword("mayhem_sword", MAYHEM), "mayhem_sword");
		mayhemSword.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemMultitool = new ItemModMultitool("mayhem_multitool", MAYHEM), "mayhem_multitool");
		mayhemMultitool.setCreativeTab(tabCreeper);
		
		GameRegistry.registerItem(mayhemHelmet = new ItemModArmor("mayhem_helmet", MAYHEMA, 1, 0), "mayhem_helmet");
		mayhemHelmet.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemChestplate = new ItemModArmor("mayhem_chestplate", MAYHEMA, 1, 1), "mayhem_chestplate");
		mayhemChestplate.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemLeggings = new ItemModArmor("mayhem_leggings", MAYHEMA, 2, 2), "mayhem_leggings");
		mayhemLeggings.setCreativeTab(tabCreeper);
		GameRegistry.registerItem(mayhemBoots = new ItemModArmor("mayhem_boots", MAYHEMA, 1, 3), "mayhem_boots");
		mayhemBoots.setCreativeTab(tabCreeper);
		
		GameRegistry.registerItem(chocolate = new ModItemFood("mayhem_chocolate", 2, 0.2f, false,
			    new PotionEffect(Potion.moveSpeed.id, 1200, 1),
			    new PotionEffect(Potion.jump.id, 600, 0),
			    new PotionEffect(Potion.regeneration.id, 200, 1))
			    .setAlwaysEdible(), "mayhem_chocolate");
		chocolate.setCreativeTab(tabCreeper);

		GameRegistry.registerItem(luckyCandy = new ModItemAdvancedFood("lucky_candy", 1, 0.5f, false)
				.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4), 0.5)
				.addPotionEffect(new PotionEffect(Potion.wither.id, 200, 4), 0.5)
				.setAlwaysEdible(), "lucky_candy");
		luckyCandy.setCreativeTab(tabCreeper);
	}
}
