package net.ingeniousmc.uraniumtech.block;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.ingeniousmc.uraniumtech.block.custom.TechnobladeOreBlock;
import net.ingeniousmc.uraniumtech.item.ModCreativeTab;
import net.ingeniousmc.uraniumtech.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UraniumTechNoblade.MOD_ID);

        public static final RegistryObject<Block> TECHNOBLADE_ORE = registerBlock("technoblade_ore",
                () -> new TechnobladeOreBlock(BlockBehaviour.Properties.of(Material.METAL)
                        .strength(5f).requiresCorrectToolForDrops()),
                ModCreativeTab.TECHNOBLADE);

        public static final RegistryObject<Block> TIME_WOOD = registerBlock("time_wood",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                        .strength(5f).requiresCorrectToolForDrops()),
                ModCreativeTab.TECHNOBLADE);




private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                 CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
        }

private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                        CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().tab(tab)){
@Override
public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(new TranslatableComponent(tooltipKey));
        }
        });
        }

private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
        }

private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
        CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().tab(tab)));
        }

public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        }
}
