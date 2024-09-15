package com.irgendwer01.gsecore.mixins.openblocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldServer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

import openmods.fakeplayer.BreakBlockAction;
import openmods.fakeplayer.FakePlayerPool;
import openmods.utils.ItemUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import openblocks.common.tileentity.TileEntityBlockBreaker;
import openmods.utils.InventoryUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(TileEntityBlockBreaker.class)
public class MixinTileEntityBlockBreaker extends TileEntity {

    /**
     * @author Irgendwer01
     * @reason Don't let the Block Breaker running when there's no output inventory/output inventory is full
     */
    @Overwrite(remap = false)
    protected boolean canWork(IBlockState targetState, BlockPos target, EnumFacing direction) {
        EnumFacing dropSide = direction.getOpposite();

        IItemHandler targetInventory = InventoryUtils.tryGetHandler(this.world, this.pos.offset(dropSide), direction);
        Block block = targetState.getBlock();
        if (targetInventory != null) {
            AtomicBoolean canInsert = new AtomicBoolean();
            targetState.getBlock().getDrops(this.world, target, targetState, 0).forEach(drop -> {
                if (ItemHandlerHelper.insertItem(targetInventory, drop, true) == ItemStack.EMPTY) {
                    canInsert.set(true);
                } else {
                    canInsert.set(false);
                }
            });

            return !block.isAir(targetState, this.world, target) && block != Blocks.BEDROCK &&
                    targetState.getBlockHardness(this.world, target) > -1.0F && canInsert.get();
        }
        return false;
    }
}
