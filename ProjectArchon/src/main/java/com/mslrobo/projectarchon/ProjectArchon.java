package com.mslrobo.projectarchon;

import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;
import com.mslrobo.projectarchon.painting.ModPaintings;
import com.mslrobo.projectarchon.villager.ModVillagers;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("projectarchon")
public class ProjectArchon {
	
	public static final String MOD_ID = "projectarchon";
	
	public static final CreativeModeTab PROJECT_ARCHON_TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
		}
	};
	
	public ProjectArchon() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		ModVillagers.register(bus);
		ModPaintings.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SuppressWarnings("unused")
	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ModVillagers.registertPOIs();
		});
	}
}
