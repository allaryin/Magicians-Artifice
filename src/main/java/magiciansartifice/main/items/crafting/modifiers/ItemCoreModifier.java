package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.modifiers.BasicWandCore;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemCoreModifier extends BasicWandCore{

    public ItemCoreModifier(int wandLevel, String coreName, ResourceLocation location) {
        super(wandLevel);
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setUnlocalizedName("wandCore." + coreName);
        this.setTextureName(ModInfo.MODID + ":wands/cores/"+coreName);
        Modifiers.modifiers.add(this);
        Modifiers.resources.put(this,location);
        ItemRegistry.items.add(this);
    }

}
