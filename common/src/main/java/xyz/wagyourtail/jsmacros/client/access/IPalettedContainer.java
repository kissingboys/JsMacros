package xyz.wagyourtail.jsmacros.client.access;

import net.minecraft.util.PackedIntegerArray;
import net.minecraft.world.chunk.Palette;

public interface IPalettedContainer<T> {

    PackedIntegerArray jsmacros_getData();
    Palette<?> jsmacros_getPaletteProvider();

}
