package org.sdoaj.eloncraft.entity.falcon9;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelFalcon9Dragon extends ModelBase {
	private final ModelRenderer trunk;
	private final ModelRenderer top;
	private final ModelRenderer pivot;
	private final ModelRenderer hatch;
	private final ModelRenderer chair;

	ModelFalcon9Dragon() {
		textureWidth = 80;
		textureHeight = 80;

		trunk = new ModelRenderer(this);
		trunk.setRotationPoint(0.0F, 24.0F, 0.0F);
		trunk.cubeList.add(new ModelBox(trunk, 0, 0, -4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 28, 17, 4.0F, -9.0F, -2.0F, 1, 9, 4, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 0, 30, -2.0F, -9.0F, 4.0F, 4, 9, 1, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 18, 17, -5.0F, -9.0F, -2.0F, 1, 9, 4, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 10, 30, -2.0F, -9.0F, -5.0F, 4, 9, 1, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 4, 51, 5.0F, -6.0F, -0.5F, 1, 6, 1, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 6, 58, -0.5F, -6.0F, 5.0F, 1, 6, 1, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 10, 58, -6.0F, -6.0F, -0.5F, 1, 6, 1, 0.0F, false));
		trunk.cubeList.add(new ModelBox(trunk, 0, 51, -0.5F, -6.0F, -6.0F, 1, 6, 1, 0.0F, false));

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, 24.0F, 0.0F);
		top.cubeList.add(new ModelBox(top, 0, 17, 3.0F, -12.0F, -4.0F, 1, 3, 8, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 34, -3.0F, -12.0F, 3.0F, 6, 3, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 32, 0, -4.0F, -12.0F, -4.0F, 1, 3, 8, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 30, -3.0F, -12.0F, -4.0F, 6, 3, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 40, 4.0F, -11.0F, -2.0F, 1, 2, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 30, 46, -2.0F, -11.0F, 4.0F, 4, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 10, 40, -5.0F, -11.0F, -2.0F, 1, 2, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 40, 46, -2.0F, -11.0F, -5.0F, 4, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 14, 58, 2.0F, -15.0F, 1.0F, 1, 3, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 14, 51, 2.0F, -15.0F, -3.0F, 1, 3, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 10, 46, -2.0F, -15.0F, 2.0F, 4, 3, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 58, -3.0F, -15.0F, 1.0F, 1, 3, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 8, 51, -3.0F, -15.0F, -3.0F, 1, 3, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 28, 65, 1.0F, -15.0F, -3.0F, 1, 3, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 24, 65, -2.0F, -15.0F, -3.0F, 1, 3, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 46, 3.0F, -13.0F, -2.0F, 1, 1, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 14, 69, 3.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 18, 69, 3.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 46, -2.0F, -14.0F, 3.0F, 4, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 40, 40, -4.0F, -13.0F, -2.0F, 1, 1, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 22, 69, -4.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 26, 69, -4.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 4, 69, -2.0F, -14.0F, -4.0F, 1, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 69, 1.0F, -14.0F, -4.0F, 1, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 30, 40, 1.0F, -17.0F, -2.0F, 1, 2, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 12, 65, -1.0F, -17.0F, 1.0F, 2, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 40, -2.0F, -17.0F, -2.0F, 1, 2, 4, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 65, -1.0F, -17.0F, -2.0F, 2, 2, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 6, 65, 2.0F, -16.0F, -1.0F, 1, 1, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 18, 65, -1.0F, -16.0F, 2.0F, 2, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 62, -3.0F, -16.0F, -1.0F, 1, 1, 2, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 32, 65, -1.0F, -16.0F, -3.0F, 2, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 20, 54, -1.0F, -18.0F, -1.0F, 2, 1, 2, 0.0F, false));

		pivot = new ModelRenderer(this);
		pivot.setRotationPoint(0.0F, 20.75F, -4.75F);
		pivot.cubeList.add(new ModelBox(pivot, 51, 0, 1.99F, -0.25F - 0.25F, -0.5F, 0, 3, 1, 0.0F, false));
		pivot.cubeList.add(new ModelBox(pivot, 51, 0, -1.99F, -0.25F - 0.25F, -0.5F, 0, 3, 1, 0.0F, false));

		hatch = new ModelRenderer(this);
		hatch.setRotationPoint(0.0F, 24.0F, 0.0F);
		hatch.cubeList.add(new ModelBox(hatch, 26, 58, -1.0F, -14.0F, -4.0F, 2, 2, 1, 0.0F, false));
		hatch.cubeList.add(new ModelBox(hatch, 18, 67, -1.0F, -15.0F, -3.0F, 2, 1, 1, 0.0F, false));
		setHatch(0.0);

		chair = new ModelRenderer(this);
		chair.setRotationPoint(0.0F, 24.0F, 0.0F);
		chair.cubeList.add(new ModelBox(chair, 8, 69, -0.5F, -11.0F, 1.0F, 1, 1, 2, 0.0F, false));
		chair.cubeList.add(new ModelBox(chair, 20, 58, -1.0F, -12.5F, 0.75F, 2, 3, 1, 0.0F, false));
		chair.cubeList.add(new ModelBox(chair, 20, 51, -1.0F, -10.5F, -1.25F, 2, 1, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float yaw, float pitch, float scale) {
		EntityFalcon9Dragon dragon = (EntityFalcon9Dragon) entity;
		setHatch(dragon.getHatchPosition());

		float modelScale = ModelFalcon9Stage1.modelScale;

		GL11.glPushMatrix();
		GL11.glTranslatef(0F, 1.5F - 1.5F * modelScale, 0F);
		GL11.glScalef(modelScale, modelScale, modelScale);
		GL11.glRotatef(180 + entity.rotationYaw, 0, 1, 0);
		GL11.glRotatef(-entity.rotationPitch, 1, 0, 0);

		trunk.render(scale);
		top.render(scale);

		GL11.glPushMatrix();
		GL11.glScalef(0.5F, 0.5F, 0.5F);

		pivot.render(scale);

		GL11.glPopMatrix();

		hatch.render(scale);
		chair.render(scale);

		GL11.glPopMatrix();
	}

	private static final double minPivotAngle = Math.asin(0.625 / 1.25);
	private static final double maxPivotAngle = Math.PI - minPivotAngle;

	private final double y0 = 1.25 * -Math.cos(minPivotAngle);
	private final double z0 = 1.25 * Math.sin(minPivotAngle);

	private void setHatch(double x) {
		x = MathHelper.clamp(x, 0.0, 1.0);
		float angle = (float) (minPivotAngle + ((maxPivotAngle - minPivotAngle) * x));
		pivot.rotateAngleX = -angle;

		double yf = 1.25 * -Math.cos(angle);
		double zf = 1.25 * Math.sin(angle);
		float dy = (float) (yf - y0);
		float dz = (float) (zf - z0);
		hatch.rotationPointY = 24.0F - dy;
		hatch.rotationPointZ = 0.0F - dz;
	}
}