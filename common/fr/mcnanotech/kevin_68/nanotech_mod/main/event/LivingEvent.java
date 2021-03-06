package fr.mcnanotech.kevin_68.nanotech_mod.main.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class LivingEvent
{
	@ForgeSubscribe
	public void livingFall(LivingFallEvent event)
	{
		ItemStack boots = event.entityLiving.getCurrentItemOrArmor(1);

		if(boots != null && boots.getItem().equals(NanotechItem.Mysteriousboots))
		{
			boots.damageItem((int)(event.distance / 8), event.entityLiving);
			if(boots.stackSize == 0)
			{
				event.entityLiving.setCurrentItemOrArmor(1, null);
			}
			event.distance = 0F;
		}
	}
}