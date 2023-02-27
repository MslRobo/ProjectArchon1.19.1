package com.mslrobo.projectarchon.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ArchonSword extends Item{

	public ArchonSword(Properties properties) {
		super(properties.stacksTo(1));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Attack Damage: 10, Attack Speed: 1").withStyle(ChatFormatting.BOLD));
			
		} else {
			components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.AQUA));
		}
		
		
		
		super.appendHoverText(stack, level, components, flag);
	}

}
