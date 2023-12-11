package com.quantumzizo.absoluteinsanity.sanity.passive;

import com.quantumzizo.absoluteinsanity.config.Config;
import croissantnova.sanitydim.capability.ISanity;
import croissantnova.sanitydim.passive.IPassiveSanitySource;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

public class Thirsty implements IPassiveSanitySource {
    @Override
    public float get(@NotNull ServerPlayer player, @NotNull ISanity cap, @NotNull ResourceLocation dim) {
        AtomicInteger thirst = new AtomicInteger(20);
        if (ModList.get().isLoaded("thirst")) {
            player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(t -> {
                thirst.set(t.getThirst());
            });
        }
        if (thirst.get() <= Config.THIRST_THRESHOLD.get())
            return -Config.THIRSTY.get().floatValue()/2000;
        return 0;
    }
}
