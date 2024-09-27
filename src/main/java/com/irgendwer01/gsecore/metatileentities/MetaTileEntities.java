package com.irgendwer01.gsecore.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.getHighTier;
import static gregtech.common.metatileentities.MetaTileEntities.getMidTier;

import net.minecraft.util.ResourceLocation;

import com.irgendwer01.gsecore.metatileentities.electric.MetaTileEntitySieve;
import com.irgendwer01.gsecore.metatileentities.steam.MetaTileEntitySteamSieve;

import gregtech.api.GTValues;

public class MetaTileEntities {

    // Machines
    public static MetaTileEntitySteamSieve STEAM_SIEVE_BRONZE;
    public static MetaTileEntitySteamSieve STEAM_SIEVE_STEEL;
    public static MetaTileEntitySieve[] SIEVES = new MetaTileEntitySieve[GTValues.V.length - 1];

    public static void registerMetaTileEntities() {
        STEAM_SIEVE_BRONZE = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5000,
                new MetaTileEntitySteamSieve(new ResourceLocation(GTValues.MODID, "sieve.steam"), false));
        STEAM_SIEVE_STEEL = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5001,
                new MetaTileEntitySteamSieve(new ResourceLocation(GTValues.MODID, "steam_sieve_steel"), true));

        SIEVES[0] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5002,
                new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.lv"), 1));
        SIEVES[1] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5003,
                new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.mv"), 2));
        SIEVES[2] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5004,
                new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.hv"), 3));
        SIEVES[3] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5005,
                new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.ev"), 4));
        SIEVES[4] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5006,
                new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.iv"), 5));

        if (getMidTier("sieve")) {
            SIEVES[5] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5007,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.luv"), 6));
            SIEVES[6] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5008,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.zpm"), 7));
            SIEVES[7] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5009,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.uv"), 8));
        }

        if (getHighTier("sieve")) {
            SIEVES[8] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5010,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.uhv"), 9));
            SIEVES[9] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5011,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.uev"), 10));
            SIEVES[10] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5012,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.uiv"), 11));
            SIEVES[11] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5013,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.uxv"), 12));
            SIEVES[12] = gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity(5014,
                    new MetaTileEntitySieve(new ResourceLocation(GTValues.MODID, "sieve.opv"), 13));
        }
    }
}
