package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks.ModelBlockTrail;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrail;

public class TileEntityTrailRender extends TileEntitySpecialRenderer
{
	private final ModelBlockTrail model;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city:textures/blocks/BlockTrail.png");

	public TileEntityTrailRender()
	{
		this.model = new ModelBlockTrail();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		this.renderTileEntityAtBlockTrail((TileEntityTrail)tileentity, x, y, z, scale);
	}

	public void renderTileEntityAtBlockTrail(TileEntityTrail tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}