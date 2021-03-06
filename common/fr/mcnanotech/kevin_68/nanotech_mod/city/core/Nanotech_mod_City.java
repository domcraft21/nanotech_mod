package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.city.blocks.NanotechCityBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.city.network.GuiHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.city.network.PacketHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

@Mod(modid = "Nanotech_mod_City", name = "Nanotech mod City", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"NTMC|light", "NTMC|fount"}, packetHandler = PacketHandler.class)
public class Nanotech_mod_City
{
	// Instance
	@Instance("Nanotech_mod_City")
	public static Nanotech_mod_City modInstance;
	// Proxy
	@SidedProxy(clientSide = "fr.mcnanotech.kevin_68.nanotech_mod.city.core.ClientProxy", serverSide = "fr.mcnanotech.kevin_68.nanotech_mod.city.core.CommonProxy")
	public static CommonProxy proxy;

	// Block IDs
	public static int BlockTrashcanID, BlockSpotLightID, BlockTrailID, BlockFountainID, BlockLampID, BlockSunShadeID, BlockModernFenceID;

	// Item IDs

	public static CreativeTabs cityTab = new CreativeTabs("NanotechModCity")
	{
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex()
		{
			return NanotechCityBlock.BlockLamp.blockID;
		}
	};

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			BlockTrashcanID = cfg.getBlock("Trash can", 1100).getInt();
			BlockSpotLightID = cfg.getBlock("SpotLight", 1101).getInt();
			BlockTrailID = cfg.getBlock("Trail", 1021).getInt();
			BlockFountainID = cfg.getBlock("Fountain", 1022).getInt();
			BlockLampID = cfg.getBlock("Lamp", 1023).getInt();
			BlockSunShadeID = cfg.getBlock("SunShade", 1024).getInt();
			BlockModernFenceID = cfg.getBlock("ModernFence", 1025).getInt();
		}
		catch(Exception ex)
		{
			Nanotech_mod.NanoLog.severe("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}

		NanotechCityBlock.initBlock();
		NanotechCityBlock.blockRegistry();
		NanotechCityAchievement.initAchievement();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		GameRegistry.registerCraftingHandler(new CityCraftingHandler());

		// NetWork
		NetworkRegistry.instance().registerGuiHandler(this.modInstance, new GuiHandler());
		NetworkRegistry.instance().registerChannel(new PacketHandler(), "nanotechmodcity");

		// TileEntity
		GameRegistry.registerTileEntity(TileEntitySpotLight.class, "TileEntitySpotLight");
		GameRegistry.registerTileEntity(TileEntityTrail.class, "TileEntityTrail");
		GameRegistry.registerTileEntity(TileEntityFountain.class, "TileEntityFountain");
		GameRegistry.registerTileEntity(TileEntityLamp.class, "TileEntityLamp");
		GameRegistry.registerTileEntity(TileEntityLampLight.class, "TileEntityLampLight");
		GameRegistry.registerTileEntity(TileEntitySunShade.class, "TileEntitySunShade");

		// Render
		proxy.registerTileRenders();

		// Recipe
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockLamp, 1), new Object[] {"IDI", "GSG", "III", 'I', Item.ingotIron, 'D', Block.daylightSensor, 'G', Block.thinGlass, 'S', Block.glowStone});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockSunShade, 1), new Object[] {"WWW", " S ", " S ", 'W', Block.cloth, 'S', Item.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(NanotechCityBlock.BlockTrail, 1), new Object[] {Block.grass, Block.gravel});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockFountain, 1), new Object[] {"S S", "SWS", "SPS", 'S', new ItemStack(Block.stoneSingleSlab, 0), 'W', Item.bucketWater, 'P', Block.pistonBase});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockModernFence, 4), new Object[] {"I I", "III", "I I", 'I', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockTrashcan, 1), new Object[] {"I I", "ICI", "III", 'I', Item.ingotIron, 'C', Block.cactus});
		GameRegistry.addRecipe(new ItemStack(NanotechCityBlock.BlockSpotLight), new Object[] {"OAO", "RGB", "OAO", 'O', Block.obsidian, 'A', Block.glass, 'R', new ItemStack(Item.dyePowder, 1, 1), 'G', new ItemStack(Item.dyePowder, 1, 2), 'B', new ItemStack(Item.dyePowder, 1, 4)});

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		NanotechCityAchievement.addAchievementInPage();
	}
}