package com.quantumzizo.absoluteinsanity.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	public static ForgeConfigSpec CONFIG;
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final ForgeConfigSpec.DoubleValue HYPERTHERMIC_SANITY;
	
	static {
		BUILDER.comment(
				"Absolute Insanity config",
				"NOTE: all sanity values are measured in percentages (i.e. 40.0 is equal to 40% of sanity bar)",
                "NOTE: each subsequent usage of an active source or item has its effectiveness multiplied by (timeSinceLastUsage / cooldown) (capped at 1.0)")
				.push("absoluteinsanity");
		
		HYPERTHERMIC_SANITY = BUILDER
				.comment("Sanity gain per second when the player is hyperthermic or near hyperthermic")
				.defineInRange("hyperthermic", -1.0, -100.0, 100.0);
		BUILDER.pop();

		CONFIG = BUILDER.build();
	}
}
