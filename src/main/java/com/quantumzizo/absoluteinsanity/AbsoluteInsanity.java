package com.quantumzizo.absoluteinsanity;

import com.quantumzizo.absoluteinsanity.config.Config;
import com.quantumzizo.absoluteinsanity.sanity.passive.Hyperthermic;
import com.quantumzizo.absoluteinsanity.sanity.passive.Thirsty;
import croissantnova.sanitydim.SanityProcessor;
import croissantnova.sanitydim.passive.IPassiveSanitySource;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.quantumzizo.absoluteinsanity.event.EventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod(AbsoluteInsanity.MOD_ID)
public class AbsoluteInsanity {
	public static final String MOD_ID = "absoluteinsanity";
	
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public AbsoluteInsanity() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG, "absoluteinsanity.toml");
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		
		modEventBus.addListener(this::commonSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		injectPassiveSanitySources();
		LOGGER.info("Passive sanity sources appended.");
		LOGGER.debug("Passive sanity sources are: " + Arrays.toString(SanityProcessor.PASSIVE_SANITY_SOURCES.toArray()));
	}

	private void injectPassiveSanitySources() {
		List<IPassiveSanitySource> SECONDARY_PSS = Arrays.asList(
				new Hyperthermic(),
				new Thirsty()
		);

		SanityProcessor.PASSIVE_SANITY_SOURCES.addAll(SECONDARY_PSS);
	}
}
