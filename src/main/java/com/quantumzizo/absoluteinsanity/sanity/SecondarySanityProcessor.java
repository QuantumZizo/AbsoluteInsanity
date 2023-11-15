package com.quantumzizo.absoluteinsanity.sanity;

import java.util.Arrays;
import java.util.List;

import com.quantumzizo.absoluteinsanity.sanity.passive.Hyperthermic;

import croissantnova.sanitydim.capability.*;
import croissantnova.sanitydim.config.ConfigProxy;
import croissantnova.sanitydim.passive.IPassiveSanitySource;
import croissantnova.sanitydim.item.ItemRegistry;
import croissantnova.sanitydim.SanityProcessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public final class SecondarySanityProcessor {
	public static final List<IPassiveSanitySource> SECONDARY_PSS = Arrays.asList(
			new Hyperthermic()
	);
	
	private SecondarySanityProcessor() {}
	
	private static float calcPassive(ServerPlayer player, ISanity sanity) {
		ResourceLocation dim = player.level().dimension().location();
		float passive = 0;
		
		for (IPassiveSanitySource pss : SECONDARY_PSS) {
			float val = pss.get(player, sanity, dim);
			val *= SanityProcessor.getSanityMultiplier(player, val);
			passive += val;
		}
		
		ItemStack headItem = player.getItemBySlot(EquipmentSlot.HEAD);
		if(headItem.is(ItemRegistry.GARLAND.get())) {
			passive -= .00005 * ConfigProxy.getPosMul(dim);
		}
		return passive;
	}
	
	public static void secondaryTickPlayer(final ServerPlayer player) {
		if(player == null || player.isCreative() || player.isSpectator())
			return;
		
		player.getCapability(SanityProvider.CAP).ifPresent(s -> {
			float passive = calcPassive(player, s);
			float snapshot = s.getSanity();
			
			s.setSanity(s.getSanity() + passive);
			if(s instanceof IPassiveSanity ps) {
				ps.setPassiveIncrease(snapshot != s.getSanity() ? passive : 0);
			}
		});
	}
}