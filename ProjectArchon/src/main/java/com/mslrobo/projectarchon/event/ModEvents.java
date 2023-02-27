package com.mslrobo.projectarchon.event;

import java.util.List;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;
import com.mslrobo.projectarchon.villager.ModVillagers;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectArchon.MOD_ID)
public class ModEvents {
	
	@SubscribeEvent
	public static void addCustomTrades(VillagerTradesEvent event) {
		if(event.getType() == ModVillagers.ROTATER_MASTER.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(BlockInit.ROTATABLE_BLOCK.get(), 1);
			int villagerLevel = 1;
			
			trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
					new ItemStack(Items.EMERALD, 2),
					stack, 10, 8, 0.02F));
		}
		
		if(event.getType() == ModVillagers.ROTATER_MASTER.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.ARCHON_SWORD.get(), 1);
			int villagerLevel = 1;
			
			trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
					new ItemStack(Items.EMERALD, 32),
					stack, 10, 8, 0.02F));
		}
	}
}
