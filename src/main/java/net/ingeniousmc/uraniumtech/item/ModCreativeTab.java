package net.ingeniousmc.uraniumtech.item;


import net.ingeniousmc.uraniumtech.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab TECHNOBLADE = new CreativeModeTab("uraniumtech") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TECHNOBLADE_ORE.get());
        }
    };

}