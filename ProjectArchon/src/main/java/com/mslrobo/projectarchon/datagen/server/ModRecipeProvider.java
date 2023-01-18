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
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		// Shaped Recipe
		ShapedRecipeBuilder.shaped(ItemInit.EXAMPLE_ITEM.get()).define('a', BlockInit.EXAMPLE_BLOCK.get().asItem())
		.define('n', TagInit.Items.COOL_ITEMS)
		.pattern("aba").pattern("bab").pattern("aba")
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath()));
		
		// Shapeless Recipe
		ShapelessRecipeBuilder.shapeless(BlockInit.EXAMPLE_BLOCK.get().asItem())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(ItemInit.EXAMPLE_ITEM.get())
		.requires(Items.DIAMOND)
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.BLOCKS.getKey(BlockInit.EXAMPLE_BLOCK.get()).getPath()));
		
		// Cookie Recipe
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get().asItem()), BlockInit.ROTATABLE_BLOCK.get().asItem(), 1f, 200)
		.save(consumer, new ResourceLocation(ProjectArchon.MOD_ID, ForgeRegistries.ITEMS.getKey(ItemInit.EXAMPLE_ITEM.get()).getPath() + "_smelting"));
	}
}