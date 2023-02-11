package com.betaforge1.createcompute;

import com.betaforge1.createcompute.groups.CDCItemGroup;
import com.betaforge1.createcompute.index.CDCItems;
import com.mojang.logging.LogUtils;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.CreateItemGroup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.AbstractRegistrate;
import com.simibubi.create.repack.registrate.util.nullness.NonNullFunction;
import com.simibubi.create.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.objectweb.asm.Type;
import org.slf4j.Logger;

@Mod (CreateCompute.MODID)
public class CreateCompute {
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final NonNullSupplier <CreateRegistrate> registrate = CreateRegistrate.lazy(CreateCompute.MODID);

    public static final String MODID = "createcompute";
    public static final CreativeModeTab BASE_CREATIVE_TAB = new CDCItemGroup("base");

    public CreateCompute() {

        MinecraftForge.EVENT_BUS.register(this);

        CDCItems.register();
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Create Detect & Compute started in the server");

    }


    public static CreateRegistrate registrate() {
        return registrate.get();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(Type.getMethodDescriptor(AbstractRegistrate.class.getMethod("block", String.class, NonNullFunction.class)));
    }

}
