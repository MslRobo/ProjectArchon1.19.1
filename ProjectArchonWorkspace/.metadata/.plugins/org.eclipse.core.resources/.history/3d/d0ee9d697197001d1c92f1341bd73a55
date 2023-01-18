package com.mslrobo.projectarchon.datagen;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.datagen.client.ModBlockStateProvider;
import com.mslrobo.projectarchon.datagen.client.ModItemModelProvider;
import com.mslrobo.projectarchon.datagen.client.lang.ModEnUsProvider;
import com.mslrobo.projectarchon.datagen.server.ModBlockTagsProvider;
import com.mslrobo.projectarchon.datagen.server.ModItemTagsProvider;
import com.mslrobo.projectarchon.datagen.server.ModLootTableProvider;
import com.mslrobo.projectarchon.datagen.server.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ProjectArchon.MOD_ID, bus = Bus.MOD)
public class ProjectArchonDataGeneration {
	
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			// Client data generation
			generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, helper));
			generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, helper));
			generator.addProvider(event.includeClient(), new ModEnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
			generator.addProvider(event.includeServer(), blockTags);
			generator.addProvider(event.includeServer(), new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
			
		}
	}

}
