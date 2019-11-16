package com.jjnet.firstmod.setup;

import net.minecraft.world.World;

public class ServerProxy implements IProxy {

    @Override
    public World getClientWorld(){
        throw new IllegalStateException("Only run this on this client");

    }

}
