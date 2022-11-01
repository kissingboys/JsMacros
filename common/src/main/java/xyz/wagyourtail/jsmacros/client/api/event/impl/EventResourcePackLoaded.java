package xyz.wagyourtail.jsmacros.client.api.event.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackProfile;
import xyz.wagyourtail.jsmacros.core.event.BaseEvent;
import xyz.wagyourtail.jsmacros.core.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This event is fired after resources have been reloaded, i.e. after the splash screen has finished.
 * This includes when the game is finished loading and the title screen becomes visible, which you can check using
 * {@link #isGameStart}.
 *
 * @since 1.5.1
 */
@Event("ResourcePackLoaded")
public class EventResourcePackLoaded implements BaseEvent {
    public final boolean isGameStart;
    public final List<String> loadedPacks;

    public EventResourcePackLoaded(boolean isGameStart) {
        this.isGameStart = isGameStart;
        this.loadedPacks = MinecraftClient.getInstance().getResourcePackManager().getEnabledProfiles().stream().map(ResourcePackProfile::getName).collect(Collectors.toList());

        profile.triggerEvent(this);
    }

    @Override
    public String toString() {
        return String.format("%s:{\"isGameStart\": %b, \"loadedPacks\": %s}", this.getEventName(), isGameStart, loadedPacks);
    }
}
