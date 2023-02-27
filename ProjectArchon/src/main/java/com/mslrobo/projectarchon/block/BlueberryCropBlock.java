package com.mslrobo.projectarchon.block;
import com.mslrobo.projectarchon.init.ItemInit;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BlueberryCropBlock extends CropBlock{

	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	
	public BlueberryCropBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ItemLike getBaseSeedId() {
		// TODO Auto-generated method stub
		return ItemInit.BLUEBERRY_SEEDS.get();
	}
	
	@Override
	public IntegerProperty getAgeProperty() {
		// TODO Auto-generated method stub
		return AGE;
	}
	
	@Override
	public int getMaxAge() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		// TODO Auto-generated method stub
		builder.add(AGE);
	}

}
