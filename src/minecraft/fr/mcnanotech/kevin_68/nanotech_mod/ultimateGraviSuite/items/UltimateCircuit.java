package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items;

import ic2.core.IC2;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class UltimateCircuit extends Item
{
	public UltimateCircuit(int id)
	{
		super(id);
		this.setCreativeTab(IC2.tabIC2);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("UltimateGraviSuite:ultimateCircuit");
	}

}