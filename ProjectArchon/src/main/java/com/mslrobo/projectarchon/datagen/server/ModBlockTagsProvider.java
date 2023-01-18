package com.mslrobo.projectarchon.datagen.server;


import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.TagInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, ProjectArchon.MOD_ID, helper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addTags() {
		tag(TagInit.Blocks.COOL_BLOCKS).add(Blocks.ACACIA_BUTTON).add(BlockInit.ROTATABLE_BLOCK.get());
		tag(Tags.Blocks.COBBLESTONE).add(BlockInit.ROTATABLE_BLOCK.get());
	}

}