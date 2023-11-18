package com.quantumzizo.absoluteinsanity.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	public static ForgeConfigSpec CONFIG;
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final ForgeConfigSpec.DoubleValue HYPERTHERMIC_SANITY;
	public static final ForgeConfigSpec.IntValue THIRST_THRESHOLD;
	public static final ForgeConfigSpec.DoubleValue THIRSTY;
	
	static {
		BUILDER.comment(
				"Absolute Insanity config",
				"NOTE: all sanity values are measured in percentages (i.e. 40.0 is equal to 40% of sanity bar)",
                "NOTE: each subsequent usage of an active source or item has its effectiveness multiplied by (timeSinceLastUsage / cooldown) (capped at 1.0)")
				.push("absoluteinsanity");
		
		HYPERTHERMIC_SANITY = BUILDER
				.comment("From: Cold Sweat", "Sanity gain per second when the player is hyperthermic or near hyperthermic")
				.defineInRange("hyperthermic", -1.0, -100.0, 100.0);
		THIRST_THRESHOLD = BUILDER
				.comment("From: Thirst Was Taken", "Players' sanity will start getting affected with thirst levels at and below this threshold (in half thirst droplets)")
				.defineInRange("thirst_threshold", 8, 0, 20);
		THIRSTY = BUILDER
				.comment("From: Thirst Was Taken", "Players with thirst levels at and below <thirst_threshold> gain this amount of sanity per second")
				.defineInRange("thirsty", -0.5, -100.0, 100.0);
		BUILDER.pop();

		CONFIG = BUILDER.build();
	}
}
