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
         
        //Adds diamond sword 
        ItemStack sword = new ItemStack(Items.diamond_sword);
        sword.addEnchantment(Enchantment.sharpness, 5);
        sword.addEnchantment(Enchantment.smite, 5);
        sword.addEnchantment(Enchantment.baneOfArthropods, 5);
        sword.addEnchantment(Enchantment.knockback, 2);
        sword.addEnchantment(Enchantment.looting, 3);
        sword.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(sword);
        
        //Adds diamond pickaxe
        ItemStack pickaxe = new ItemStack(Items.diamond_pickaxe);
        pickaxe.addEnchantment(Enchantment.efficiency, 5);
        pickaxe.addEnchantment(Enchantment.fortune, 3);
        pickaxe.addEnchantment(Enchantment.silkTouch, 1);
        pickaxe.addEnchantment(Enchantment.unbreaking, 3);
        itemList.add(pickaxe);
         
        //Adds all armor enchantments
        this.addEnchantmentBooksToList(itemList, new EnumEnchantmentType[] { EnumEnchantmentType.ARMOR});
        
        //Adds the mayhem items
        super.displayAllReleventItems(itemList);
    }
    
	
	public void addMetaDataItems(List itemList, Item item, int range) {

		//Adds meta items
        for (int i = 0; i < range; ++i) {

            itemList.add(new ItemStack(item, 1, i));
        }
    }
}
