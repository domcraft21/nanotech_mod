package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemNanomiteSword extends ItemSword
{
	public ItemNanomiteSword(int id, EnumToolMaterial toolMaterial)
	{
		super(id, toolMaterial);
	}

	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("nanotech_mod:nanomiteSword");
	}

	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem().itemID == NanotechItem.ItemBase.itemID && repairItem.getItemDamage() == 14)
		return true;
		return false;
	}
}