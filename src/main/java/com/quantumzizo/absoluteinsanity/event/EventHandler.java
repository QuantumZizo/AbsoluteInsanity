package com.quantumzizo.absoluteinsanity.event;

import com.quantumzizo.absoluteinsanity.sanity.SecondarySanityProcessor;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class EventHandler {
	/*@SubscribeEvent
	public void tickPlayer(final TickEvent.PlayerTickEvent event) {
		if(event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.END && event.player instanceof ServerPlayer sp)
			SecondarySanityProcessor.secondaryTickPlayer(sp);
	}*/
}
