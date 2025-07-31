package de.larsensmods.mc.entities.client;

import net.minecraft.client.model.BabyModelTransform;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

import java.util.Set;

public class BullModel extends QuadrupedModel<LivingEntityRenderState> {

    public static final MeshTransformer BABY_TRANSFORMER = new BabyModelTransform(false, 10.0F, 4.0F, Set.of("head"));

    public BullModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F)
                        .texOffs(1, 33)
                        .addBox(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F)
                        .texOffs(27, 0)
                        .addBox(-8.0F, -3.0F, -5.0F, 4.0F, 2.0F, 2.0F)
                        .texOffs(39, 0)
                        .addBox(-8.0F, -5.0F, -5.0F, 2.0F, 2.0F, 2.0F)
                        .texOffs(27, 0)
                        .mirror()
                        .addBox(4.0F, -3.0F, -5.0F, 4.0F, 2.0F, 2.0F)
                        .mirror(false)
                        .texOffs(39, 0)
                        .mirror()
                        .addBox(6.0F, -5.0F, -5.0F, 2.0F, 2.0F, 2.0F)
                        .mirror(false),
                PartPose.offset(0.0F, 4.0F, -8.0F)
        );
        partDefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(18, 4)
                        .addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F)
                        .texOffs(52, 0)
                        .addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );

        CubeListBuilder var2 = CubeListBuilder.create().mirror().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        CubeListBuilder var3 = CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        partDefinition.addOrReplaceChild("right_hind_leg", var3, PartPose.offset(-4.0F, 12.0F, 7.0F));
        partDefinition.addOrReplaceChild("left_hind_leg", var2, PartPose.offset(4.0F, 12.0F, 7.0F));
        partDefinition.addOrReplaceChild("right_front_leg", var3, PartPose.offset(-4.0F, 12.0F, -5.0F));
        partDefinition.addOrReplaceChild("left_front_leg", var2, PartPose.offset(4.0F, 12.0F, -5.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public ModelPart getHead() {
        return this.head;
    }
}
