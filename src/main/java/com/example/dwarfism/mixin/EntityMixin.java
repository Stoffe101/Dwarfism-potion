package com.example.dwarfism.mixin;

import com.example.dwarfism.Dwarfism;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/**
 * This mixin approach works more reliably than trying to modify player dimensions.
 * It affects the rendering scale of entities.
 */
@Mixin(Entity.class)
public class EntityMixin {
    
    /**
     * This method intercepts calls to set scale in the rendering process
     */
    @ModifyArg(
        method = "updateRenderData",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/entity/EntityRenderData;setScale(F)V"
        ),
        index = 0
    )
    private float modifyRenderScale(float original) {
        // Check if this entity should have the dwarfism effect applied
        Entity self = (Entity)(Object)this;
        if (self instanceof LivingEntity living) {
            return original * Dwarfism.getScaleFactor(living);
        }
        return original;
    }
}
