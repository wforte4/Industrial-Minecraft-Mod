package com.wforte.industrial.entity;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.entity.custom.BuffZombieEntity;
import com.wforte.industrial.entity.custom.HogEntity;
import com.wforte.industrial.entity.custom.KnuckleDraggerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            IndustrialMod.MOD_ID);

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE =
            ENTITY_TYPES.register("buff_zombie",
                    () -> EntityType.Builder.create(BuffZombieEntity::new,
                            EntityClassification.MONSTER).size(1f, 3f)
                            .build(new ResourceLocation(IndustrialMod.MOD_ID, "buff_zombie").toString()));

    public static final RegistryObject<EntityType<KnuckleDraggerEntity>> KNUCKLE_DRAGGER =
            ENTITY_TYPES.register("knuckle_dragger",
                    () -> EntityType.Builder.create(KnuckleDraggerEntity::new,
                            EntityClassification.MONSTER).size(1f, 3f)
                            .build(new ResourceLocation(IndustrialMod.MOD_ID, "knuckle_dragger").toString()));

    public static final RegistryObject<EntityType<HogEntity>> HOG =
            ENTITY_TYPES.register("hog",
                    () -> EntityType.Builder.create(HogEntity::new,
                            EntityClassification.CREATURE).size(1f, 3f)
                            .build(new ResourceLocation(IndustrialMod.MOD_ID, "knuckle_dragger").toString()));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }

}
