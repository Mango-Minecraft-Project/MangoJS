package com.mangojellypudding.mangojs.kubejs.bindings.modules;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ItemUtils {
    public ItemUtils() {}

    /**
     * Gets the enchantments of an ItemStack as a LinkedHashMap.
     * @param stack the ItemStack to get enchantments from
     * @return a LinkedHashMap containing enchantment keys and their levels
     */
    @Info("""
        Gets the enchantments of an ItemStack as a LinkedHashMap.
        The keys are ResourceKeys of Enchantments and the values are their levels.
        """
    )
    public LinkedHashMap<ResourceKey<Enchantment>, Integer> getEnchantments(ItemStack stack) {
        LinkedHashMap<ResourceKey<Enchantment>, Integer> enchantments = new LinkedHashMap<>();
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : EnchantmentHelper.getEnchantmentsForCrafting(stack).entrySet()) {
            enchantments.put(entry.getKey().getKey(), entry.getIntValue());
        }
        return enchantments;
    }

    /**
     * Removes specified enchantments from an ItemStack.
     * @param stack the ItemStack to modify
     * @param enchantments the enchantments to remove
     * @param copy if true, a copy of the ItemStack will be modified instead of the original
     * @return the modified ItemStack with specified enchantments removed
     */
    @Info(value = """
        Removes specified enchantments from an ItemStack.
        """,
            params = {
                @Param(name = "stack", value = "The ItemStack to modify."),
                @Param(name = "enchantments", value = "An array of enchantments to remove."),
                @Param(name = "copy", value = "If true, a copy of the ItemStack will be modified instead of the original.")
            }
    )
    public ItemStack removeEnchantments(ItemStack stack, Enchantment[] enchantments, boolean copy) {
        if (copy) {
            stack = stack.copy();
        }

        List<Enchantment> enchantmentList = Arrays.asList(enchantments);

        EnchantmentHelper.updateEnchantments(stack, (mutable -> {
            mutable.removeIf((holder) -> enchantmentList.contains(holder.value()));
        }));

        return stack;
    }
}
