package com.github.rochedo098.droids.mixins.common;

import com.github.rochedo098.droids.registry.DroidsItems;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(AnvilBlock.class)
public abstract class MixinAnvilBlock {
    public MixinAnvilBlock() {}

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = false)
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable info) {
        if (player.isSneaking()) {
            ItemStack mainHandStack = player.getMainHandStack();// code block
            if (mainHandStack.equals(new ItemStack(Registry.ITEM.get(new Identifier("minecraft:iron_ingot"))))) {
                player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
                player.giveItemStack(new ItemStack(Registry.ITEM.get(new Identifier("droids:iron_dust"))));
                return ActionResult.SUCCESS;
            } else if (mainHandStack.equals(new ItemStack(Registry.ITEM.get(new Identifier("minecraft:coal"))))) {
                player.getMainHandStack().setCount(player.getMainHandStack().getCount() - 1);
                player.giveItemStack(new ItemStack(Registry.ITEM.get(new Identifier("droids:coal_dust"))));
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.FAIL;
            }
        } else {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
                player.incrementStat(Stats.INTERACT_WITH_ANVIL);
                return ActionResult.CONSUME;
            }
        }
    }
}
