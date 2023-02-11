package com.betaforge1.createcompute.mixin;

import com.simibubi.create.repack.registrate.AbstractRegistrate;
import com.simibubi.create.repack.registrate.builders.BlockBuilder;
import com.simibubi.create.repack.registrate.util.nullness.NonNullFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(AbstractRegistrate.class)
public abstract class AbstractRegistrateMixin<S extends AbstractRegistrate<S>>{

    @Shadow
    protected abstract S self();
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public <T extends Block> BlockBuilder<T, S> block(String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        BlockBuilder<T, S> target = ((AbstractRegistrate)(Object)this).block((Object) this.self(), (String)name, factory);
        if (name.equals("shadow_steel_casing")) {
            target.properties(p -> p.strength(40.0F, 1200.0F));
            target.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_DIAMOND_TOOL);
        } else if (name.equals("refined_radiance_casing")) {
            target.properties(p -> p.strength(10.0F, 10.0F));
            target.tag(BlockTags.NEEDS_IRON_TOOL);
        }
        return target;
    }

}
