package com.mslrobo.projectarchon.datagen.server;

import com.mslrobo.projectarchon.datagen.BaseLootTableProvider;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootTableProvider extends BaseLootTableProvider{

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(BlockInit.EXAMPLE_BLOCK.get());
		createSilkTouchTable(ForgeRegistries.BLOCKS.getKey(BlockInit.ROTATABLE_BLOCK.get()).getPath(), 
				BlockInit.ROTATABLE_BLOCK.get(), ItemInit.EXAMPLE_ITEM.get(), 1, 4);
	}
	
	protected void dropSelf(Block block) {
		createSimpleTable(ForgeRegistries.BLOCKS.getKey(BlockInit.EXAMPLE_BLOCK.get()).getPath(), BlockInit.EXAMPLE_BLOCK.get());
	}
}
