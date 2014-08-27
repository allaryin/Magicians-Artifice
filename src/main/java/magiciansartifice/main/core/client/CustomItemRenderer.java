package magiciansartifice.main.core.client;

import cpw.mods.fml.client.FMLClientHandler;
import magiciansartifice.main.core.client.items.ModelWand;
import magiciansartifice.main.core.client.machines.ModelTank;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.machines.ModelAnvil;
import magiciansartifice.main.core.client.machines.ModelWandCarver;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class CustomItemRenderer implements IItemRenderer {
    private final ModelAnvil anvil = new ModelAnvil();
    private ResourceLocation anvilTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/mysticAnvil.png");

    private final ModelWandCarver carver = new ModelWandCarver();
    private ResourceLocation carverTexture = new ResourceLocation(ModInfo.MODID,"textures/blocks/machines/wandCarver.png");

    private final ModelWand wand = new ModelWand();
    private ResourceLocation wandTexture = new ResourceLocation(ModInfo.MODID, "textures/items/wands/magiciansWand");

    private final ModelTank tank = new ModelTank();
    private ResourceLocation tankTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/magicTank.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY: {
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.mysticAnvil)) {
                    renderAnvil(0.5F, 15F, -0.5F, 0.09F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.wandCarver)) {
                    renderWandCarver(0.5F, 15F, -0.5F, 0.09F);
                }
                if (item.getItem() == ItemRegistry.magiciansWand) {
                    renderWand(0.5F, 15F, -0.5F, 0.2F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.tank)) {
                    renderTank(0.5F, 15F, -0.5F, 0.2F);
                }
                break;
            }
            case EQUIPPED: {
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.mysticAnvil)) {
                    renderAnvil(2F, 15F, 5F, 0.10F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.wandCarver)) {
                    renderWandCarver(2F, 15F, 5F, 0.10F);
                }
                if (item.getItem() == ItemRegistry.magiciansWand) {
                    renderWand(2F, 15F, 5F, 0.2F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.tank)) {
                    renderTank(2F, 15F, 5F, 0.10F);
                }
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.mysticAnvil)) {
                    renderAnvil(1F, 19F, 7F, 0.08F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.wandCarver)) {
                    renderWandCarver(1F, 19F, 7F, 0.08F);
                }
                if (item.getItem() == ItemRegistry.magiciansWand) {
                    renderWand(1F, 19F, 7F, 0.2F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.tank)) {
                    renderTank(1F, 19F, 7F, 0.08F);
                }
                break;
            }
            case INVENTORY: {
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.mysticAnvil)) {
                    renderAnvil(-0.01F, 10F, 0.0F, 0.1F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.wandCarver)) {
                    renderWandCarver(-0.01F, 10F, 0.0F, 0.1F);
                }
                if (item.getItem() == ItemRegistry.magiciansWand) {
                    renderWand(-0.01F, 10F, 0.0F, 0.2F);
                }
                if (item.getItem() == Item.getItemFromBlock(BlockRegistry.tank)) {
                    renderTank(-0.01F, 10F, 0.0F, 0.1F);
                }
                break;
            }
            default:
                return;
        }
    }

    private void renderAnvil(float x, float y, float z, float size) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(anvilTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        anvil.renderAll();
        GL11.glPopMatrix(); // end
    }

    private void renderWandCarver(float x, float y, float z, float size) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(carverTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        carver.renderAll();
        GL11.glPopMatrix(); // end
    }

    private void renderWand(float x, float y, float z, float size) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(wandTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        wand.renderAll();
        GL11.glPopMatrix(); // end
    }

    private void renderTank(float x, float y, float z, float size) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(tankTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        tank.renderAll();
        GL11.glPopMatrix(); // end
    }
}
