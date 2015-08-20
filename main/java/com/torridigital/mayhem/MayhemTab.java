package com.torridigital.mayhem;

import java.util.List;

import com.torridigital.mayhem.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MayhemTab extends CreativeTabs {
	
	public MayhemTab(int id, String unlocalizedName) {
		super(id, unlocalizedName);
		//Hides the scrollbar
		this.setNoScrollbar();
		//Sets the background image
		this.setBackgroundImageName("mayhem.png");
	}
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		//Sets the icon on tab
		return ModItems.mayhemItem;
	}
	
	@SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List itemList) {
        
		//Adds the mayhem items
        super.displayAllReleventItems(itemList);
        
        //Adds enchanted diamond sword 
        ItemStack sword = new ItemStack(Items.diamond_sword);
        sword.addEnchantment(Enchantment.baneOfArthropods, 5);
        sword.addEnchantment(Enchantment.knockback, 2);
        sword.addEnchantment(Enchantment.looting, 3);
        sword.addEnchantment(Enchantment.sharpness, 5);
        sword.addEnchantment(Enchantment.smite, 5);
        sword.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(sword);
        
        //Adds enchanted bow
        ItemStack bow = new ItemStack(Items.bow);
        bow.addEnchantment(Enchantment.infinity, 1);
        bow.addEnchantment(Enchantment.power, 5);
        bow.addEnchantment(Enchantment.punch, 2);
        bow.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(bow);
        
        //Adds enchanted diamond pickaxe
        ItemStack pickaxe = new ItemStack(Items.diamond_pickaxe);
        pickaxe.addEnchantment(Enchantment.efficiency, 5);
        pickaxe.addEnchantment(Enchantment.fortune, 3);
        pickaxe.addEnchantment(Enchantment.silkTouch, 1);
        pickaxe.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(pickaxe);
        
        //Adds enchanted diamond axe
        ItemStack axe = new ItemStack(Items.diamond_axe);
        axe.addEnchantment(Enchantment.efficiency, 5);
        axe.addEnchantment(Enchantment.fortune, 3);
        axe.addEnchantment(Enchantment.silkTouch, 1);
        axe.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(axe);
        
        //Adds enchanted fishing rod
        ItemStack rod = new ItemStack(Items.fishing_rod);
        rod.addEnchantment(Enchantment.luckOfTheSea, 3);
        rod.addEnchantment(Enchantment.lure, 3);
        rod.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(rod);
        
        //Adds enchanted diamond helmet
        ItemStack helmet = new ItemStack(Items.diamond_helmet);
        helmet.addEnchantment(Enchantment.aquaAffinity, 1);
        helmet.addEnchantment(Enchantment.blastProtection, 4);
        helmet.addEnchantment(Enchantment.fireProtection, 4);
        helmet.addEnchantment(Enchantment.projectileProtection, 4);
        helmet.addEnchantment(Enchantment.protection, 4);
        helmet.addEnchantment(Enchantment.respiration, 3);
        helmet.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(helmet);
        
        //Adds enchanted diamond chestplate
        ItemStack chestplate = new ItemStack(Items.diamond_chestplate);
        chestplate.addEnchantment(Enchantment.blastProtection, 4);
        chestplate.addEnchantment(Enchantment.fireProtection, 4);
        chestplate.addEnchantment(Enchantment.projectileProtection, 4);
        chestplate.addEnchantment(Enchantment.protection, 4);
        chestplate.addEnchantment(Enchantment.thorns, 3);
        chestplate.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(chestplate);
        
        //Adds enchanted diamond leggings
        ItemStack leggings = new ItemStack(Items.diamond_leggings);
        leggings.addEnchantment(Enchantment.blastProtection, 4);
        leggings.addEnchantment(Enchantment.fireProtection, 4);
        leggings.addEnchantment(Enchantment.projectileProtection, 4);
        leggings.addEnchantment(Enchantment.protection, 4);
        leggings.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(leggings);
        
        //Adds enchanted diamond boots
        ItemStack boots = new ItemStack(Items.diamond_boots);
        boots.addEnchantment(Enchantment.blastProtection, 4);
        boots.addEnchantment(Enchantment.depthStrider, 3);
        boots.addEnchantment(Enchantment.featherFalling, 4);
        boots.addEnchantment(Enchantment.fireProtection, 4);
        boots.addEnchantment(Enchantment.projectileProtection, 4);
        boots.addEnchantment(Enchantment.protection, 4);
        boots.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(boots);
        
        //Adds 32 cooked steak
        ItemStack steak = new ItemStack(Items.cooked_beef, 32);
        itemList.add(steak);
        
        //Adds 64 bottles o' enchanting
        ItemStack ench = new ItemStack(Items.experience_bottle, 64);
        itemList.add(ench);
        
        //Adds all armor enchantments
        // this.addEnchantmentBooksToList(itemList, new EnumEnchantmentType[] { EnumEnchantmentType.ARMOR});  
    }
    
	public void addMetaDataItems(List itemList, Item item, int range) {

		//Adds meta items
        for (int i = 0; i < range; ++i) {
            itemList.add(new ItemStack(item, 1, i));
        }
    }
}
