package xyz.wagyourtail.jsmacros.client.api.library.impl;

import net.minecraft.util.math.Vec3d;

import xyz.wagyourtail.jsmacros.client.api.helpers.world.BlockPosHelper;
import xyz.wagyourtail.jsmacros.client.api.helpers.world.entity.EntityHelper;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Pos2D;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Pos3D;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Vec2D;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Vec3D;
import xyz.wagyourtail.jsmacros.core.library.BaseLibrary;
import xyz.wagyourtail.jsmacros.core.library.Library;

/**
 * position helper classes
 * @since 1.6.3
 */
@Library("PositionCommon")
@SuppressWarnings("unused")
public class FPositionCommon extends BaseLibrary {
    /**
     * create a new vector object
     *
     * @since 1.6.3
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     *
     * @return
     */
    public Vec3D createVec(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Vec3D(x1, y1, z1, x2, y2, z2);
    }

    /**
     * @since 1.8.4
     * @param entity
     * @return
     */
    public Vec3D createLookingVector(EntityHelper<?> entity) {
        Vec3d rotation = entity.getRaw().getRotationVector();
        return new Vec3D(0, 0, 0, rotation.x, rotation.y, rotation.z);
    }

    /**
     * @since 1.8.4
     * @param yaw
     * @param pitch
     * @return
     */
    public Vec3D createLookingVector(double yaw, double pitch) {
        Vec3d rotation = Vec3d.fromPolar((float) pitch, (float) yaw);
        return new Vec3D(0, 0, 0, rotation.x, rotation.y, rotation.z);
    }

    /**
     * @since 1.6.3
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     *
     * @return
     */
    public Vec2D createVec(double x1, double y1, double x2, double y2) {
        return new Vec2D(x1, y1, x2, y2);
    }

    /**
     * @since 1.6.3
     * @param x
     * @param y
     * @param z
     *
     * @return
     */
    public Pos3D createPos(double x, double y, double z) {
        return new Pos3D(x, y, z);
    }

    /**
     *
     * @since 1.6.3
     * @param x
     * @param y
     *
     * @return
     */
    public Pos2D createPos(double x, double y) {
        return new Pos2D(x, y);
    }

    /**
     * @param x the x position of the block
     * @param y the y position of the block
     * @param z the z position of the block
     * @return a {@link BlockPosHelper} for the given coordinates.
     *
     * @since 1.8.4
     */
    public BlockPosHelper createBlockPos(int x, int y, int z) {
        return new BlockPosHelper(x, y, z);
    }
    
}
