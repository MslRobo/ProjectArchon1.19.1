package com.mslrobo.projectarchon.datagen.server;


import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, ProjectArchon.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Blocks.COBBLESTONE).add(BlockInit.ROTATABLE_BLOCK.get());
	}

}
