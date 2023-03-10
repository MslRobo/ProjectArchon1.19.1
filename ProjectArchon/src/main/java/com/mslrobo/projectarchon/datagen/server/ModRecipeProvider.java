package com.mslrobo.projectarchon.datagen.server;

import java.util.function.Consumer;

import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;
import com.mslrobo.projectarchon.init.ItemInit;
import com.mslrobo.projectarchon.init.TagInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeProvider extends RecipeProvider{

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		// Shaped Recipe
		ShapedRecipeBuilder.shaped(ItemInit.EXAMPLE_ITEM.get())
		.define('a', BlockInit.EXAMPLE_BLOCK.get().asItem())
		.define('b', TagInit.Items.COOL_ITEMS)
		.pattern("aba").pattern("bab").pattern("aba")
		.unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(BlockInit.EXAMPLE_BLOCK.get()).getPath(), has(BlockInit.EXAMPLE_BLOCK.get().asItem()))
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath()));
		
		ShapedRecipeBuilder.shaped(ItemInit.ARCHON_SWORD.get())
		.define('a', ItemInit.ARCHON_CORE.get().asItem())
		.define('b', Items.STICK.asItem())
		.pattern(" a ").pattern(" a ").pattern(" b ")
		.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ItemInit.ARCHON_CORE.get()).getPath(), has(ItemInit.ARCHON_CORE.get()))
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.ITEMS.getKey(ItemInit.ARCHON_SWORD.get()).getPath()));
		
		ShapedRecipeBuilder.shaped(BlockInit.EXAMPLE_BLOCK.get().asItem())
		.define('n', ItemInit.EXAMPLE_ITEM.get().asItem())
		.pattern("nnn").pattern("nnn").pattern("nnn")
		.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath(), has(ItemInit.EXAMPLE_ITEM.get()))
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, "blockrecipe"));
		
		// Shapeless Recipe
		ShapelessRecipeBuilder.shapeless(BlockInit.EXAMPLE_BLOCK.get().asItem())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(Items.DIAMOND)
		.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath(), has(ItemInit.EXAMPLE_ITEM.get()))
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.BLOCKS.getKey(BlockInit.EXAMPLE_BLOCK.get()).getPath()));
		
		// Cookie Recipe
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get().asItem()), BlockInit.ROTATABLE_BLOCK.get().asItem(), 1f, 200)
		.unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(BlockInit.EXAMPLE_BLOCK.get()).getPath(), has(BlockInit.EXAMPLE_BLOCK.get().asItem()))
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath() + "_smelting"));
	}
}
