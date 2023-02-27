package com.mslrobo.projectarchon.init;

import com.google.common.base.Supplier;
import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.item.ArchonCore;
import com.mslrobo.projectarchon.item.ArchonStaff;
import com.mslrobo.projectarchon.item.ArchonSword;
import com.mslrobo.projectarchon.item.ExampleItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectArchon.MOD_ID);
	
	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item", () -> new ExampleItem(
			new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1f).build())));
	
	public static final RegistryObject<Item> ARCHON_CORE = register("archon_core", () -> new ArchonCore(
			new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
	
	public static final RegistryObject<Item> ARCHON_SWORD = register("archon_sword", () -> new ArchonSword( 
			new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB)));
	
	public static final RegistryObject<Item> ARCHON_STAFF = register("archon_staff", () -> new ArchonStaff( 
			new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB)));
	
	public static final RegistryObject<Item> BLUEBERRY_SEEDS = register("blueberry_seeds", 
			() -> new ItemNameBlockItem(BlockInit.BLUEBERRY_CROP.get(),
					new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB)));

	public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", 
			() -> new Item(new Item.Properties().tab(ProjectArchon.PROJECT_ARCHON_TAB)
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));
}
