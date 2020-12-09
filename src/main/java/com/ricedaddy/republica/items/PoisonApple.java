package com.ricedaddy.republica.items;

import com.ricedaddy.republica.Republica;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonApple extends Item {

    public PoisonApple() {
        super(new Item.Properties()
                .group(Republica.TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.NAUSEA, 300,1), 1)
                        .effect(new EffectInstance(Effects.POISON, 300,2), 1)
                        .effect(new EffectInstance(Effects.HUNGER, 300,1), 0.3F)
                        .setAlwaysEdible()
                .build())
        );
    }
}
