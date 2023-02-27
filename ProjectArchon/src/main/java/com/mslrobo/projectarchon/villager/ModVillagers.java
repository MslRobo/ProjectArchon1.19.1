package com.mslrobo.projectarchon.villager;

import java.lang.reflect.InvocationTargetException;

import com.google.common.collect.ImmutableSet;
import com.mslrobo.projectarchon.ProjectArchon;
import com.mslrobo.projectarchon.init.BlockInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
	public static final DeferredRegister<PoiType> POI_TYPES = 
			DeferredRegister.create(ForgeRegistries.POI_TYPES, ProjectArchon.MOD_ID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = 
			DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ProjectArchon.MOD_ID);
	
	// Villagers / PoiTypes
	public static final RegistryObject<PoiType> ROTATER_BLOCK_POI = POI_TYPES.register("rotater_block_poi", 
			() -> new PoiType(ImmutableSet.copyOf(BlockInit.ROTATABLE_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 1));
	
	public static final RegistryObject<VillagerProfession> ROTATER_MASTER = VILLAGER_PROFESSIONS.register("rotater_master", 
			() -> new VillagerProfession("jump_master", x -> x.get() == ROTATER_BLOCK_POI.get(), x -> x.get() == ROTATER_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
	
	
	// registers
	public static void registertPOIs() {
		try {
			ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, ROTATER_BLOCK_POI.get());
		} catch (InvocationTargetException | IllegalAccessException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void register(IEventBus eventBus) {
		POI_TYPES.register(eventBus);
		VILLAGER_PROFESSIONS.register(eventBus);
	}
}
