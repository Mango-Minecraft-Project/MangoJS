package com.mangojellypudding.mangojs.kubejs.event.living;

import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingGetProjectileEvent;

public class LivingGetProjectileKubeEvent extends KubeLivingEntityEvent<LivingGetProjectileEvent> {
    public LivingGetProjectileKubeEvent(LivingGetProjectileEvent event) {
        super(event);
    }

    @Info("""
            The itemstack of the projectile found.
            Initially this is set to the projectile found by vanilla behaviour, but it's possible for thatnot to be the case if a modder uses a different implementation of LivingEntity.getProjectile(ItemStack).
            """)
    public ItemStack getProjectile() {
        return event.getProjectileItemStack();
    }

    @Info("""
            Sets the projectile itemstack to be used.
            If the entity is a player: whenever the projectile is fired/consumed the stack will be shrunk by one. To disable this behaviour you can copy the stack before giving it to the event. For bows, you can use ArrowLooseEvent to remove the arrow yourself.
            Be aware that since this event fires every time a living entity gets a projectile, whether or not its Entity.level is client-side, you will want to make a conditional to always set the item stack to what you'd want it to be to avoid client-server desyncs.
            """)
    public void setProjectile(ItemStack projectile) {
        event.setProjectileItemStack(projectile);
    }

    @Info("""
            The itemstack of the itrm that is looking for a projectile.
            With vanilla behavior, this usually returns an itemstack of a ProjectileWeaponItem, but it's possible for that to not be the case if modder uses a different implementation of LivingEntity.getProjectile(ItemStack).
            """)
    public ItemStack getWeapon() {
        return event.getProjectileWeaponItemStack();
    }
}
