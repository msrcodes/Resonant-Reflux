package com.eagle.resonantreflux.registry;

import com.eagle.resonantreflux.integration.ItemStealer;
import com.eagle.resonantreflux.integration.ModChecker;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 27/07/2015, 11:55 GMT.
 */
public class RecipeRegistry
{
    public static IRecipe scrapBag, scrap;

    public static void load()
    {
        scrapBag =
                new ShapelessOreRecipe(new ItemStack(ItemRegistry.scrapBag), "itemScrap", "itemScrap", "itemScrap", "itemScrap", "itemScrap", "itemScrap", "itemScrap", "itemScrap", "itemScrap");
        GameRegistry.addRecipe(scrapBag);

        scrap = new ShapelessOreRecipe(new ItemStack(ItemRegistry.scrap, 9), "itemScrapBag");
        GameRegistry.addRecipe(scrap);

        loadFluxCrystalRecipes();
        loadDynamicRecipes();
    }

    private static void loadDynamicRecipes()
    {
        if (ModChecker.teLoaded && ModChecker.tfLoaded && ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "ESE", "SCS", "KFK", 'C', ItemStealer.resonantEnergyCell, 'E', "ingotEnderium", 'S', "gearPlatinum", 'K', ItemStealer.octadicCapacitor, 'F', ItemStealer.frank));
        }
        else if (ModChecker.teLoaded && ModChecker.tfLoaded && !ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "ESE", "SCS", "KFK", 'C', ItemStealer.resonantEnergyCell, 'E', "ingotEnderium", 'S', "gearPlatinum", 'K', ItemStealer.receptionCoil, 'F', "dustPyrotheum"));
        }
        else if (!ModChecker.teLoaded && ModChecker.tfLoaded && ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "ESE", "SCS", "KFK", 'C', ItemStealer.capacitorBank, 'E', "ingotEnderium", 'S', "gearPlatinum", 'K', ItemStealer.octadicCapacitor, 'F', ItemStealer.frank));
        }
        else if (!ModChecker.teLoaded && ModChecker.tfLoaded && !ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "ESE", "SCS", "KSK", 'C', "blockEnderium", 'E', "ingotEnderium", 'S', "gearPlatinum", 'K', "dustPyrotheum"));
        }
        else if (!ModChecker.teLoaded && !ModChecker.tfLoaded && ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "ESE", "ECE", "KFK", 'C', ItemStealer.capacitorBank, 'E', "ingotSoularium", 'S', "itemEnderCrystal", 'K', ItemStealer.octadicCapacitor, 'F', ItemStealer.frank));
        }
        else if (!ModChecker.teLoaded && !ModChecker.tfLoaded && !ModChecker.eioLoaded)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockFluxCrystallizer), "RDR", "IEI", "EDE", 'R', "dustRedstone", 'D', "gemDiamond", 'I', "blockIron", 'E', "gemEmerald"));
        }
    }

    private static void loadFluxCrystalRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(Blocks.log, 8), " X ", "   ", "   ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.stone, 16), "   ", " X ", "   ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.snow, 16), "X X", "   ", "   ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.grass, 16), "   ", "X  ", "X  ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.obsidian, 12), "X X", "X X", "   ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.glass, 32), " X ", "X X", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.water, 1), "   ", " X ", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.lava, 1), " X ", " X ", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.dye, 32, 3), "XX ", "  X", "XX ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.glowstone, 8), " X ", "X X", "XXX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.cactus, 48), " X ", "XXX", "X X", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.reeds, 48), "X X", "X X", "X X", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.vine), 24), "X  ", "X  ", "X  ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.snowball, 16), "   ", "   ", "XXX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.clay_ball, 48), "XX ", "X  ", "XX ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.waterlily), 64), "X X", " X ", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 15), "XXX", "X  ", "XXX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.bone, 32), "X  ", "XX ", "X  ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.feather, 32), " X ", " X ", "X X", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.dye, 48), " XX", " XX", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 1), "XXX", "X X", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.coal, 5), "  X", "X  ", "  X", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.iron_ore, 2), "X X", " X ", "X X", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.gold_ore, 2), " X ", "XXX", " X ", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.redstone, 24), "   ", " X ", "XXX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.dye, 9, 4), " X ", " X ", " XX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Blocks.emerald_ore, 1), "XX ", "X X", " XX", 'X', ItemRegistry.fluxCrystal);
        GameRegistry.addRecipe(new ItemStack(Items.diamond, 1), "XXX", "XXX", "XXX", 'X', ItemRegistry.fluxCrystal);

        if (OreDictionary.doesOreNameExist("dustTin"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustTin").get(0).copy().getItem(), 10, OreDictionary.getOres("dustTin").get(0).copy().getItemDamage()), "   ", "X X", "  X", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustCopper"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustCopper").get(0).copy().getItem(), 10, OreDictionary.getOres("dustCopper").get(0).copy().getItemDamage()), "  X", "X X", "   ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("gemSapphire"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("gemSapphire").get(0).copy().getItem(), 2, OreDictionary.getOres("gemSapphire").get(0).copy().getItemDamage()), "XX ", "XXX", " XX", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("gemPeridot"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("gemPeridot").get(0).copy().getItem(), 2, OreDictionary.getOres("dustPeridot").get(0).copy().getItemDamage()), " XX", "XXX", " XX", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustNikolite"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustNikolite").get(0).copy().getItem(), 12, OreDictionary.getOres("dustNikolite").get(0).copy().getItemDamage()), "XXX", " X ", "   ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("gemRuby"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("gemRuby").get(0).copy().getItem(), 2, OreDictionary.getOres("gemRuby").get(0).copy().getItemDamage()), " XX", "XXX", "XX ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("gemOlivine"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("gemOlivine").get(0).copy().getItem(), 2, OreDictionary.getOres("gemOlivine").get(0).copy().getItemDamage()), "XX ", "XXX", "XX ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustZinc"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustZinc").get(0).copy().getItem(), 10, OreDictionary.getOres("dustZinc").get(0).copy().getItemDamage()), "   ", "X X", "X  ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustLead"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustLead").get(0).copy().getItem(), 14, OreDictionary.getOres("dustLead").get(0).copy().getItemDamage()), "XXX", "XXX", "X  ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustPlatinum"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustPlatinum").get(0).copy().getItem(), 1, OreDictionary.getOres("dustPlatinum").get(0).copy().getItemDamage()), "  X", "XXX", "XXX", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustTungsten"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustTungsten").get(0).copy().getItem(), 1, OreDictionary.getOres("dustTungsten").get(0).copy().getItemDamage()), "X  ", "XXX", "XXX", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustTitanium"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustTitanium").get(0).copy().getItem(), 2, OreDictionary.getOres("dustTitanium").get(0).copy().getItemDamage()), "XXX", " X ", " X ", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustAluminum"))
        {
            GameRegistry.addRecipe(new ItemStack(OreDictionary.getOres("dustAluminum").get(0).copy().getItem(), 16, OreDictionary.getOres("dustAluminum").get(0).copy().getItemDamage()), " X ", " X ", "XXX", 'X', ItemRegistry.fluxCrystal);
        }

        if (OreDictionary.doesOreNameExist("dustPlutonium") && OreDictionary.doesOreNameExist("dustUranium"))
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(OreDictionary.getOres("dustPlutonium").get(0).copy().getItem(), 1, OreDictionary.getOres("dustPlutonium").get(0).copy().getItemDamage()), "XXX", "XYX", "XXX", 'X', ItemRegistry.fluxCrystal, 'Y', "dustUranium"));
        }

    }
}
