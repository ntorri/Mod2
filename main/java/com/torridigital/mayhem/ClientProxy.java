package com.torridigital.mayhem;

import com.torridigital.mayhem.client.render.blocks.BlockRenderRegister;
import com.torridigital.mayhem.client.render.items.ItemRenderRegister;
import com.torridigital.mayhem.entities.EntityParticleFXMysterious;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author ntorri
 * Client side only events
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void generateMysteriousParticles(Entity theEntity)
	{
		double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
		EntityFX particleMysterious = new EntityParticleFXMysterious(

          theEntity.worldObj, 
          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 
          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() 

                * theEntity.height, 
          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 

          motionX, 

          motionY, 

          motionZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);        
	}

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ItemRenderRegister.preInit();
		BlockRenderRegister.preInit();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ItemRenderRegister.registerItemRenderer();
        BlockRenderRegister.registerBlockRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
