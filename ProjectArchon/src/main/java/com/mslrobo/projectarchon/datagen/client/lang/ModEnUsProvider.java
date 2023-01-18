package com.mslrobo.projectarchon.datagen.client.lang;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider{

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, ProjectArchon.MOD_ID, "en_us");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addTranslations() {
		// Item Groups
		add("itemGroup.projectarchon", "Project Archon");
		
		// Items
		add(ItemInit.EXAMPLE_ITEM.get(), "Example Item");
			
		// Blocks
		add(BlockInit.EXAMPLE_BLOCK.get(), "Example Block");
	}
	
}
