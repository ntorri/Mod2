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
		return ModItems.mayhemItem;
	}
	
	
	@SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List itemList) {
         
        //Adds string with silk touch lv 1 
        ItemStack string = new ItemStack(Items.string);
        string.addEnchantment(Enchantment.silkTouch, 1);
        itemList.add(string);
 
        //Adds wooden hoe
        itemList.add(new ItemStack(Items.wooden_hoe));
         
        //Adds all fishing enchantments
        this.addEnchantmentBooksToList(itemList, new EnumEnchantmentType[] { EnumEnchantmentType.FISHING_ROD});
        
        super.displayAllReleventItems(itemList);
    }
    
	
	public void addMetaDataItems(List itemList, Item item, int range) {

        for (int i = 0; i < range; ++i) {

            itemList.add(new ItemStack(item, 1, i));
        }
    }
}
