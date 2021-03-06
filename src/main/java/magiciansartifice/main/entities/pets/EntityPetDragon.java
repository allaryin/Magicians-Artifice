package magiciansartifice.main.entities.pets;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class EntityPetDragon extends EntityPetBase {
    private static double health = 40.0D;
    private static double range = 40.0D;
    private static double speed = 0.6000000238418579D;

    public EntityPetDragon(World world) {
        super(world, 40, 40, 0.6000000238418579D);
    }

    public EntityPetDragon createChild(EntityAgeable ageable) {
        EntityPetDragon baby = new EntityPetDragon(this.worldObj);
        baby.onSpawnWithEgg((IEntityLivingData)null);
        return baby;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(health);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(range);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(speed);
    }
}
