package com.mslrobo.projectarchon.datagen.server;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider{

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, ProjectArchon.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Items.BARRELS).add(BlockInit.ROTATABLE_BLOCK.get().asItem());
	}

}
