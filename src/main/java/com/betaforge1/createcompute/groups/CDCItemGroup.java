package com.betaforge1.createcompute.groups;


import com.betaforge1.createcompute.CreateCompute;
import com.simibubi.create.AllItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CDCItemGroup extends CreativeModeTab {
    public static CDCItemGroup MAIN;

    public CDCItemGroup(String name) {
        super(CreateCompute.MODID + ":" + name);
        MAIN = this;
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AllItems.REFINED_RADIANCE.get());
    }
}