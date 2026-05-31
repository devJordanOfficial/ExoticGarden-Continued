package io.github.thebusybiscuit.exoticgarden.items;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun5.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;

public class MagicalEssence extends SlimefunItem {

    @ParametersAreNonnullByDefault
    public MagicalEssence(ItemGroup itemGroup, SlimefunItemStack item) {
        ItemStack stack = item.item();
        super(itemGroup, item, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { stack, stack, stack, stack, null, stack, stack, stack, stack });
    }

    @Override
    public boolean useVanillaBlockBreaking() {
        return true;
    }

}
