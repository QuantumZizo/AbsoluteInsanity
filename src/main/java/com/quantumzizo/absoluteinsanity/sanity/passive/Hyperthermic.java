package com.quantumzizo.absoluteinsanity.sanity.passive;

import com.quantumzizo.absoluteinsanity.config.Config;
import com.momosoftworks.coldsweat.api.util.Temperature;
import croissantnova.sanitydim.capability.ISanity;
import croissantnova.sanitydim.passive.IPassiveSanitySource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.ModList;

public class Hyperthermic implements IPassiveSanitySource {
	@Override
	public float get(ServerPlayer player, ISanity cap, ResourceLocation dim) {
		if(ModList.get().isLoaded("coldsweat")) {
			double playerTemp = Temperature.get(player, Temperature.Type.BODY);
			if (playerTemp >= 50) 
				return Config.HYPERTHERMIC_SANITY.get().floatValue();
		}
		return 0;
	}
}