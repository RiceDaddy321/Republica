package com.ricedaddy.republica.items;

import com.ricedaddy.republica.Republica;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {


    public ItemBase() {
        super(new Item.Properties().group(Republica.TAB));
    }
}
