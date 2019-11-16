package com.jjnet.firstmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SecondBlock extends Block {
    public SecondBlock(){
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(10.0f)
                .lightValue(14)
        );
        setRegistryName("secondblock");
    }
}