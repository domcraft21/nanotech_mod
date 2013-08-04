package fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityFountain;

@SideOnly(Side.CLIENT)
public class TileEntityFountainRender extends TileEntitySpecialRenderer
{

	public void renderTileEntitySpotLightAt(TileEntityFountain tileEntityFountain, double par2, double par4, double par6, float par8)
	{
		float f1 = tileEntityFountain.func_82125_v_();

		if(f1 > 0.0F)
		{   
			Tessellator tessellator = Tessellator.instance;
			this.bindTextureByName("/misc/water.png");
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			float f2 = (float)(tileEntityFountain.getWorldObj().getTotalWorldTime()/ 2) + par8;
			float f22;
			if (tileEntityFountain.rotate)
			{
				f22 = ((f2 - par8) * 2) + par8;
			}
			else
			{
				f22 = 1.0F;
			}
			float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
			byte b0 = 1;
			double d3 = (double)f22 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
			tessellator.startDrawingQuads();
			//tessellator.setColorRGBA(tileEntityFountain.getRedValue(), tileEntityFountain.getGreenValue(), tileEntityFountain.getBlueValue(), 32);
			double d4 = (double)b0 * tileEntityFountain.width;// taille
			double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d4;
			double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d4;
			double d7 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d4;
			double d8 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d4;
			double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d4;
			double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d4;
			double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d4;
			double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d4;
			double d13;
			
				d13 = (double)(tileEntityFountain.f * f1);
			
			double d14 = 0.0D;
			double d15 = 1.0D;
			double d16 = (double)(-1.0F + f3);
			double d17 = (double)(tileEntityFountain.f * f1) * (0.5D / d4) + d16;
			//tessellator.addVertexWithUV(par2 + d5 , par4 + d13, par6 + d6 , d15, d17);
			//tessellator.addVertexWithUV(par2 + d5 , par4      , par6 + d6 , d15, d16);
			tessellator.addVertexWithUV(par2 + d7 , par4	  , par6 + d8 , d14, d16);
			tessellator.addVertexWithUV(par2 + d7 , par4 + d13, par6 + d8 , d14, d17);
			//tessellator.addVertexWithUV(par2 + d11, par4 + d13, par6 + d12, d15, d17);
			//tessellator.addVertexWithUV(par2 + d11, par4	  , par6 + d12, d15, d16);
			tessellator.addVertexWithUV(par2 + d9 , par4	  , par6 + d10, d14, d16);
			tessellator.addVertexWithUV(par2 + d9 , par4 + d13, par6 + d10, d14, d17);
			tessellator.addVertexWithUV(par2 + d7 , par4 + d13, par6 + d8 , d15, d17);
			tessellator.addVertexWithUV(par2 + d7 , par4	  , par6 + d8 , d15, d16);
			//tessellator.addVertexWithUV(par2 + d11, par4	  , par6 + d12, d14, d16);
			//tessellator.addVertexWithUV(par2 + d11, par4 + d13, par6 + d12, d14, d17);
			tessellator.addVertexWithUV(par2 + d9 , par4 + d13, par6 + d10, d15, d17);
			tessellator.addVertexWithUV(par2 + d9 , par4	  , par6 + d10, d15, d16);
			//tessellator.addVertexWithUV(par2 + d5 , par4	  , par6 + d6 , d14, d16);
			//tessellator.addVertexWithUV(par2 + d5 , par4 + d13, par6 + d6 , d14, d17);
			
			tessellator.addVertexWithUV(par2 + d5 , par4 + d13, par6 + d6 , d15, d17);
			tessellator.addVertexWithUV(par2 + d5 , par4      , par6 + d6 , d15, d16);
			//tessellator.addVertexWithUV(par2 + d7 , par4	  , par6 + d8 , d14, d16);
			//tessellator.addVertexWithUV(par2 + d7 , par4 + d13, par6 + d8 , d14, d17);
			tessellator.addVertexWithUV(par2 + d11, par4 + d13, par6 + d12, d15, d17);
			tessellator.addVertexWithUV(par2 + d11, par4	  , par6 + d12, d15, d16);
			//tessellator.addVertexWithUV(par2 + d9 , par4	  , par6 + d10, d14, d16);
			//tessellator.addVertexWithUV(par2 + d9 , par4 + d13, par6 + d10, d14, d17);
			//tessellator.addVertexWithUV(par2 + d7 , par4 + d13, par6 + d8 , d15, d17);
			//tessellator.addVertexWithUV(par2 + d7 , par4	  , par6 + d8 , d15, d16);
			tessellator.addVertexWithUV(par2 + d11, par4	  , par6 + d12, d14, d16);
			tessellator.addVertexWithUV(par2 + d11, par4 + d13, par6 + d12, d14, d17);
			//tessellator.addVertexWithUV(par2 + d9 , par4 + d13, par6 + d10, d15, d17);
			//tessellator.addVertexWithUV(par2 + d9 , par4	  , par6 + d10, d15, d16);
			tessellator.addVertexWithUV(par2 + d5 , par4	  , par6 + d6 , d14, d16);
			tessellator.addVertexWithUV(par2 + d5 , par4 + d13, par6 + d6 , d14, d17);
			tessellator.draw();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(true);
		}
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderTileEntitySpotLightAt((TileEntityFountain)par1TileEntity, par2, par4, par6, par8);
	}
}
