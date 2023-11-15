package com.quantumzizo.absoluteinsanity;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.quantumzizo.absoluteinsanity.event.EventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AbsoluteInsanity.MOD_ID)
public class AbsoluteInsanity {
	public static final String MOD_ID = "absoluteinsanity";
	
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public AbsoluteInsanity() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		
		modEventBus.addListener(this::commonSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info("Don't ya just love going insane?");
	}
}
