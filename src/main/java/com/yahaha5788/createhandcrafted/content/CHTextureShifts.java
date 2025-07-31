package com.yahaha5788.createhandcrafted.content;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.yahaha5788.createhandcrafted.CreateHandcrafted;


public class CHTextureShifts {

    public static final CTSpriteShiftEntry GOLD_CASING = getCasingCT("gold_casing");

    public static final CTSpriteShiftEntry GILDED_CASING = getCasingCT("gilded_casing");

    private static CTSpriteShiftEntry getCasingCT(String casingName) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL,
                CreateHandcrafted.asResource("block/" + casingName),
                CreateHandcrafted.asResource("block/" + casingName + "_connected")
                );
    }
}
