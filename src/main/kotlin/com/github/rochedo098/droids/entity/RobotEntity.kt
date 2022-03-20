/*
package com.github.rochedo098.droids.entity


import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.ActionResult
import net.minecraft.util.Arm
import net.minecraft.util.Hand
import net.minecraft.world.World

class RobotEntity(world: World): LivingEntity(world) {
    private var connected: Boolean = false
    private var player: PlayerEntity = null!!
    private var owner: String = ""
    private var energy: Double = 0.0
    private var antenna: String = ""

    override fun getArmorItems(): MutableIterable<ItemStack> = player.inventory.armor
    override fun equipStack(slot: EquipmentSlot, stack: ItemStack?) {} // WHY USE THIS? SYNC WITH PLAYER
    override fun getEquippedStack(slot: EquipmentSlot): ItemStack = player.getEquippedStack(slot) // DON'T USE THIS FUNCTION (OR USE IDK)
    override fun getMainArm(): Arm = player.mainArm

    override fun getHealth(): Float = 1f
    override fun kill() { this.energy = 0.0; this.health = 0f }
    override fun onDeath(source: DamageSource) {}
    override fun damage(source: DamageSource, amount: Float): Boolean {
        if (energy > amount.toDouble()) {
            energy -= amount.toDouble()
            return false
        } else {
            this.kill()
        }
        return false
    }


    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        super.readCustomDataFromNbt(nbt)
        connected = nbt.getBoolean("connected")
        player = null!!
        owner = nbt.getString("owner")
        energy = nbt.getDouble("energy")
        antenna = nbt.getString("antenna")
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        super.writeCustomDataToNbt(nbt)
        nbt.putBoolean("connected", this.connected)
        nbt.putString("player", this.player.name.toString())
        nbt.putString("owner", this.owner)
        nbt.putDouble("energy", this.energy)
        nbt.putString("antenna", this.antenna)
    }

    override fun tick() {

    }

    override fun interact(player: PlayerEntity, hand: Hand): ActionResult {
        return ActionResult.SUCCESS
    }
}
*/