package com.github.wyrdix.netherchangeratio.nms;

import java.lang.reflect.Field;

public class Fixer_1_18_1 {

    public static void change(double ratio) throws Exception {
        //Accessing the class in which world types are stored
        Class<?> dimClazz = Class.forName("net.minecraft.world.level.dimension.DimensionManager");

        //Getting the nether world type
        Field netherField = dimClazz.getDeclaredField("q");

        netherField.setAccessible(true);
        Object dim = netherField.get(null);

        //Getting the ratio field of the nether world type
        Field ratioField = dimClazz.getDeclaredField("B");
        ratioField.setAccessible(true);
        ratioField.set(dim, ratio);

    }
}
