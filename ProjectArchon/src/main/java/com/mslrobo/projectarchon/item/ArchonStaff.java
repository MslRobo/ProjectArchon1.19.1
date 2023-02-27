package com.mslrobo.projectarchon.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ArchonStaff extends Item{

	public ArchonStaff(Properties properties) {
		super(properties.stacksTo(1));
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		if(Screen.hasShiftDown()) {
			components.add(Component.literal("Release SHIFT :)").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD));
		} else {
			components.add(Component.literal("Hold SHIFT for more info").withStyle(ChatFormatting.AQUA));
		}
		super.appendHoverText(stack, level, components, flag);
	}

}
