package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperCreeper;

public class RenderSuperCreeper extends RenderLiving
{
	private ModelBase model = new ModelSuperCreeper(2.0F);
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod:textures/entity/supercreeper.png");

	public RenderSuperCreeper(ModelSuperCreeper model, float f)
	{
		super(new ModelSuperCreeper(), 0.5F);
	}

	protected ResourceLocation getCreeperTexture(MobSuperCreeper entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getCreeperTexture((MobSuperCreeper)entity);
	}

	protected void updateMob_supercreeperScale(MobSuperCreeper mob, float par2)
	{
		float var4 = mob.setCreeperFlashTime(par2);
		float var5 = 1.0F + MathHelper.sin(var4 * 100.0F) * var4 * 0.01F;

		if(var4 < 0.0F)
		{
			var4 = 0.0F;
		}

		if(var4 > 1.0F)
		{
			var4 = 1.0F;
		}

		var4 *= var4;
		var4 *= var4;
		float var6 = (1.0F + var4 * 0.4F) * var5;
		float var7 = (1.0F + var4 * 0.1F) / var5;
		GL11.glScalef(var6, var7, var6);
	}

	protected int updateMob_supercreeperColorMultiplier(MobSuperCreeper mob, float par2, float par3)
	{
		float var5 = mob.setCreeperFlashTime(par3);

		if((int)(var5 * 10.0F) % 2 == 0)
		{
			return 0;
		}
		else
		{
			int var6 = (int)(var5 * 0.2F * 255.0F);

			if(var6 < 0)
			{
				var6 = 0;
			}

			if(var6 > 255)
			{
				var6 = 255;
			}

			short var7 = 255;
			short var8 = 255;
			short var9 = 255;
			return var6 << 24 | var7 << 16 | var8 << 8 | var9;
		}
	}

	protected int renderMob_supercreeperPassModel(MobSuperCreeper mob, int par2, float par3)
	{
		if(mob.getPowered())
		{
			if(par2 == 1)
			{
				float var4 = (float)mob.ticksExisted + par3;
				this.bindTexture(new ResourceLocation("textures/entity/creeper/creeper_armor.png"));
				GL11.glMatrixMode(GL11.GL_TEXTURE);
				GL11.glLoadIdentity();
				float var5 = var4 * 0.01F;
				float var6 = var4 * 0.01F;
				GL11.glTranslatef(var5, var6, 0.0F);
				this.setRenderPassModel(this.model);
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glEnable(GL11.GL_BLEND);
				float var7 = 0.5F;
				GL11.glColor4f(var7, var7, var7, 1.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
				return 1;
			}

			if(par2 == 2)
			{
				GL11.glMatrixMode(GL11.GL_TEXTURE);
				GL11.glLoadIdentity();
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_BLEND);
			}
		}

		return -1;
	}

	protected int func_77061_b(MobSuperCreeper mob, int par2, float par3)
	{
		return -1;
	}

	protected void preRenderCallback(EntityLiving entityliving, float par2)
	{
		this.updateMob_supercreeperScale((MobSuperCreeper)entityliving, par2);
	}

	protected int getColorMultiplier(EntityLiving entityliving, float par2, float par3)
	{
		return this.updateMob_supercreeperColorMultiplier((MobSuperCreeper)entityliving, par2, par3);
	}

	protected int shouldRenderPass(EntityLiving entityliving, int par2, float par3)
	{
		return this.renderMob_supercreeperPassModel((MobSuperCreeper)entityliving, par2, par3);
	}

	protected int inheritRenderPass(EntityLiving entityliving, int par2, float par3)
	{
		return this.func_77061_b((MobSuperCreeper)entityliving, par2, par3);
	}
}