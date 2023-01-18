package com.mslrobo.projectarchon.datagen.client.lang;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider{

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, ProjectArchon.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		// Item Groups
		add("itemGroup.projectarchon", "Project Archon");
		
		// Items
		add(ItemInit.EXAMPLE_ITEM.get(), "Example Item");
		add(ItemInit.ARCHON_CORE.get(), "Archon Core");
			
		// Blocks
		add(BlockInit.EXAMPLE_BLOCK.get(), "Example Block");
		add(BlockInit.ROTATABLE_BLOCK.get(), "Rotatable Block");
	}
	
}
