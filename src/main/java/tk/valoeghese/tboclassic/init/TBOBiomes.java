package tk.valoeghese.tboclassic.init;

import java.util.List;

import com.google.common.collect.Lists;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import tk.valoeghese.tboclassic.TBOClassic;
import tk.valoeghese.tboclassic.world.biome.AlpsBiome;
import tk.valoeghese.tboclassic.world.biome.AlpsEdgeBiome;
import tk.valoeghese.tboclassic.world.biome.BayouBiome;
import tk.valoeghese.tboclassic.world.biome.BayouHillsBiome;
import tk.valoeghese.tboclassic.world.biome.BiomeFactory.RiverType;
import tk.valoeghese.tboclassic.world.biome.BrushlandBiome;
import tk.valoeghese.tboclassic.world.biome.ChaparralBiome;
import tk.valoeghese.tboclassic.world.biome.CliffsBiome;
import tk.valoeghese.tboclassic.world.biome.DunesBiome;
import tk.valoeghese.tboclassic.world.biome.FenBiome;
import tk.valoeghese.tboclassic.world.biome.FlowerFieldBiome;
import tk.valoeghese.tboclassic.world.biome.ForestedFenBiome;
import tk.valoeghese.tboclassic.world.biome.ForestedSpiresBiome;
import tk.valoeghese.tboclassic.world.biome.GlacierBiome;
import tk.valoeghese.tboclassic.world.biome.GrasslandBiome;
import tk.valoeghese.tboclassic.world.biome.GravellyMountainPeaksBiome;
import tk.valoeghese.tboclassic.world.biome.GroveBiome;
import tk.valoeghese.tboclassic.world.biome.IcePlainsBiome;
import tk.valoeghese.tboclassic.world.biome.MarshBiome;
import tk.valoeghese.tboclassic.world.biome.MireBiome;
import tk.valoeghese.tboclassic.world.biome.MoorBiome;
import tk.valoeghese.tboclassic.world.biome.MountainPeaksBiome;
import tk.valoeghese.tboclassic.world.biome.MurkyBayouBiome;
import tk.valoeghese.tboclassic.world.biome.OakenThicketBiome;
import tk.valoeghese.tboclassic.world.biome.OasisBiome;
import tk.valoeghese.tboclassic.world.biome.OutbackBiome;
import tk.valoeghese.tboclassic.world.biome.OutbackUluruBiome;
import tk.valoeghese.tboclassic.world.biome.PeatBogBiome;
import tk.valoeghese.tboclassic.world.biome.RainforestBiome;
import tk.valoeghese.tboclassic.world.biome.RainforestMountainsBiome;
import tk.valoeghese.tboclassic.world.biome.RedwoodsBiome;
import tk.valoeghese.tboclassic.world.biome.ShieldBiome;
import tk.valoeghese.tboclassic.world.biome.ShrublandBiome;
import tk.valoeghese.tboclassic.world.biome.SteppeBiome;
import tk.valoeghese.tboclassic.world.biome.SubtropicalRainforestBiome;
import tk.valoeghese.tboclassic.world.biome.TBOBiome;
import tk.valoeghese.tboclassic.world.biome.TemperateRainforestBiome;
import tk.valoeghese.tboclassic.world.biome.TropicalIslandBiome;
import tk.valoeghese.tboclassic.world.biome.TropicalIslandShoreBiome;
import tk.valoeghese.tboclassic.world.biome.TropicalReefBiome;
import tk.valoeghese.tboclassic.world.biome.TundraBiome;
import tk.valoeghese.tboclassic.world.biome.WoodedMountainPeaksBiome;

public class TBOBiomes
{
	public static Biome ALPS;
	public static Biome ALPS_EDGE;
	public static Biome BAYOU;
	public static Biome BAYOU_HILLS;
	public static Biome BRUSHLAND;
	public static Biome CHAPARRAL;
	public static Biome CLIFFS;
	public static Biome DUNES;
	public static Biome FEN;
	public static Biome FLOWER_FIELD;
	public static Biome FORESTED_FEN;
	public static Biome FORESTED_SPIRES;
	public static Biome GLACIER;
	public static Biome GRASSLAND;
	public static Biome GRAVELLY_MOUNTAIN_PEAKS;
	public static Biome GROVE;
	public static Biome HIGHLAND;
	public static Biome ICE_PLAINS;
	public static Biome MARSH;
	public static Biome MIRE;
	public static Biome MURKY_BAYOU;
	public static Biome MOOR;
	public static Biome MOUNTAIN_PEAKS;
	public static Biome OAKEN_THICKET;
	public static Biome OASIS;
	public static Biome OUTBACK;
	public static Biome OUTBACK_ULURU;
	public static Biome PEAT_BOG;
	public static Biome RAINFOREST;
	public static Biome RAINFOREST_MOUNTAINS;
	public static Biome REDWOODS;
	public static Biome SHIELD;
	public static Biome SHRUBLAND;
	public static Biome STEPPE;
	public static Biome SUBTROPICAL_RAINFOREST;
	public static Biome TEMPERATE_RAINFOREST;
	public static Biome TUNDRA;
	public static Biome TROPICAL_ISLAND;
	public static Biome TROPICAL_ISLAND_SHORE;
	public static Biome TROPICAL_REEF;
	public static Biome WOODED_MOUNTAIN_PEAKS;

	private static final List<TBOBiome> tboBiomes = Lists.newArrayList();

	public static void registerBiomes()
	{
		// Before TheBiomeOverhaul 1.2.0

		ALPS = register(new AlpsBiome(), "tbo:alps");
		BAYOU = register(new BayouBiome(), "tbo:bayou");
		BRUSHLAND = register(new BrushlandBiome(), "tbo:brushland");
		CHAPARRAL = register(new ChaparralBiome(), "tbo:chaparral");
		CLIFFS = register(new CliffsBiome(), "tbo:cliffs");
		GLACIER = register(new GlacierBiome(), "tbo:glacier");
		GRASSLAND = register(new GrasslandBiome(0.2F, 0.3F), "tbo:grassland");
		GROVE = register(new GroveBiome(), "tbo:grove");
		FEN = register(new FenBiome(), "tbo:fen");
		HIGHLAND = register(new GrasslandBiome(2.75F, 0.36F), "tbo:highland");
		ICE_PLAINS = register(new IcePlainsBiome(), "tbo:ice_plains");
		MARSH = register(new MarshBiome(), "tbo:marsh");
		MIRE = register(new MireBiome(), "tbo:mire");
		MOOR = register(new MoorBiome(), "tbo:moor");
		OASIS = register(new OasisBiome(), "tbo:oasis");
		OAKEN_THICKET = register(new OakenThicketBiome(), "tbo:oaken_thicket");
		OUTBACK = register(new OutbackBiome(), "tbo:outback");
		RAINFOREST = register(new RainforestBiome(), "tbo:rainforest");
		REDWOODS = register(new RedwoodsBiome(), "tbo:redwoods");
		SHIELD = register(new ShieldBiome(), "tbo:shield");
		SHRUBLAND = register(new ShrublandBiome(), "tbo:shrubland");
		STEPPE = register(new SteppeBiome(), "tbo:steppe");
		SUBTROPICAL_RAINFOREST = register(new SubtropicalRainforestBiome(), "tbo:subtropical_rainforest");
		TEMPERATE_RAINFOREST = register(new TemperateRainforestBiome(), "tbo:temperate_rainforest");
		TUNDRA = register(new TundraBiome(), "tbo:tundra");
		TROPICAL_ISLAND = register(new TropicalIslandBiome(), "tbo:tropical_island");
		TROPICAL_ISLAND_SHORE = register(new TropicalIslandShoreBiome(), "tbo:tropical_island_shore");

		ALPS_EDGE = register(new AlpsEdgeBiome(), "tbo:alps_edge");
		BAYOU_HILLS = register(new BayouHillsBiome(), "tbo:bayou_hills");
		GRAVELLY_MOUNTAIN_PEAKS = register(new GravellyMountainPeaksBiome(), "tbo:gravelly_mountain_peaks");
		FORESTED_FEN = register(new ForestedFenBiome(), "tbo:forested_fen");
		MOUNTAIN_PEAKS = register(new MountainPeaksBiome(), "tbo:mountain_peaks");
		OUTBACK_ULURU = register(new OutbackUluruBiome(), "tbo:modified_outback");
		RAINFOREST_MOUNTAINS = register(new RainforestMountainsBiome(), "tbo:modified_rainforest");
		WOODED_MOUNTAIN_PEAKS = register(new WoodedMountainPeaksBiome(), "tbo:wooded_mountain_peaks");

		//===================================================================================

		// TheBiomeOverhaul 1.2.0
		DUNES = register(new DunesBiome(), "tbo:dunes");
		FLOWER_FIELD = register(new FlowerFieldBiome(), "tbo:flower_field");
		FORESTED_SPIRES = register(new ForestedSpiresBiome(), "tbo:forested_spires");
		PEAT_BOG = register(new PeatBogBiome(), "tbo:peat_bog");

		MURKY_BAYOU = register(new MurkyBayouBiome(), "tbo:murky_bayou");
		
		// TBOClassic, for easier world generation of the TBO Biomes
		TROPICAL_REEF = register(new TropicalReefBiome(), "tbo:tropical_reef");

		TBOClassic.getLogger().debug("Registered Biomes");

		// Players cannot spawn in Alps, Mountain Peaks biomes, Mire, Murky Bayou, Oasis, Uluru, Tropical Reef, and [Wasteland biomes]
		// (N.B. Wastelands never ended up getting added to tbo)
		addSpawnBiomes(
				ALPS_EDGE,
				BAYOU, BAYOU_HILLS, BRUSHLAND,
				CHAPARRAL, CLIFFS,
				DUNES,
				FEN, FLOWER_FIELD, FORESTED_FEN, FORESTED_SPIRES,
				GLACIER, GRASSLAND, GROVE,
				HIGHLAND,
				ICE_PLAINS,
				MARSH, MOOR,
				OAKEN_THICKET, OUTBACK,
				PEAT_BOG,
				RAINFOREST, RAINFOREST_MOUNTAINS, REDWOODS,
				SHIELD, SHRUBLAND, STEPPE, SUBTROPICAL_RAINFOREST,
				TEMPERATE_RAINFOREST, TUNDRA, TROPICAL_ISLAND, TROPICAL_ISLAND_SHORE
				);

		TBOClassic.getLogger().debug("Added Spawn Biomes");
	}

	public static void addBiomeGen() {
		// Tweaking mountain edges
		OverworldBiomes.addEdgeBiome(Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE, 1D);
		OverworldBiomes.addEdgeBiome(Biomes.GRAVELLY_MOUNTAINS, Biomes.MOUNTAIN_EDGE, 1D);

		// Alps
		OverworldBiomes.addContinentalBiome(ALPS, OverworldClimate.SNOWY, 1D);
		TBOClassic.setLargeEdge(ALPS, ALPS_EDGE);

		// Bayou
		OverworldBiomes.addContinentalBiome(BAYOU, OverworldClimate.DRY, 1D);
		OverworldBiomes.addHillsBiome(BAYOU, BAYOU_HILLS, 1D);

		OverworldBiomes.addBiomeVariant(BAYOU, MURKY_BAYOU, 0.2D);
		OverworldBiomes.addHillsBiome(MURKY_BAYOU, BAYOU_HILLS, 1D);
		TBOClassic.setLargeEdge(MURKY_BAYOU, BAYOU);

		// Brushland
		OverworldBiomes.addContinentalBiome(BRUSHLAND, OverworldClimate.DRY, 2D);

		// Chaparral
		OverworldBiomes.addContinentalBiome(CHAPARRAL, OverworldClimate.TEMPERATE, 1D);
		OverworldBiomes.addHillsBiome(CHAPARRAL, CHAPARRAL, 4D);
		OverworldBiomes.addHillsBiome(CHAPARRAL, GROVE, 1D);

		// Cliffs
		TBOClassic.addCoast(OverworldClimate.TEMPERATE, CLIFFS, 1);
		TBOClassic.addCoast(OverworldClimate.COOL, CLIFFS, 1);
		OverworldBiomes.addShoreBiome(CLIFFS, CLIFFS, 1D);

		// Dunes
		OverworldBiomes.addContinentalBiome(DUNES, OverworldClimate.DRY, 1D);

		// Flower Field
		OverworldBiomes.addHillsBiome(Biomes.PLAINS, FLOWER_FIELD, 0.5D);

		// Fen
		OverworldBiomes.addContinentalBiome(FEN, OverworldClimate.TEMPERATE, 1D);
		OverworldBiomes.addHillsBiome(FEN, FORESTED_FEN, 1D);

		// Grassland
		OverworldBiomes.addBiomeVariant(Biomes.PLAINS, GRASSLAND, 0.4D, OverworldClimate.COOL);

		// Grove
		OverworldBiomes.addContinentalBiome(GROVE, OverworldClimate.TEMPERATE, 1D);

		// Highlands
		OverworldBiomes.addContinentalBiome(HIGHLAND, OverworldClimate.COOL, 1D);

		// Ice Plains
		OverworldBiomes.addBiomeVariant(Biomes.SNOWY_TUNDRA, ICE_PLAINS, 0.4D);
		OverworldBiomes.addHillsBiome(ICE_PLAINS, Biomes.SNOWY_TAIGA, 2D);
		OverworldBiomes.addHillsBiome(ICE_PLAINS, GLACIER, 1D);

		// Marsh
		OverworldBiomes.addContinentalBiome(MARSH, OverworldClimate.COOL, 1D);

		// Mire
		OverworldBiomes.addContinentalBiome(MIRE, OverworldClimate.COOL, 1D);

		// Moor
		OverworldBiomes.addContinentalBiome(MOOR, OverworldClimate.COOL, 1D);

		// Mountain Peaks
		OverworldBiomes.addContinentalBiome(WOODED_MOUNTAIN_PEAKS, OverworldClimate.TEMPERATE, 1D);
		TBOClassic.setLargeEdge(WOODED_MOUNTAIN_PEAKS, Biomes.MOUNTAINS);
		OverworldBiomes.addHillsBiome(WOODED_MOUNTAIN_PEAKS, MOUNTAIN_PEAKS, 1D);
		OverworldBiomes.addHillsBiome(WOODED_MOUNTAIN_PEAKS, GRAVELLY_MOUNTAIN_PEAKS, 1D);

		// Oaken Thicket
		OverworldBiomes.addContinentalBiome(OAKEN_THICKET, OverworldClimate.TEMPERATE, 0.5D);
		OverworldBiomes.addHillsBiome(Biomes.FOREST, OAKEN_THICKET, 1D);

		// Oasis
		OverworldBiomes.addHillsBiome(Biomes.DESERT, OASIS, 0.5D);

		// Outback
		OverworldBiomes.addContinentalBiome(OUTBACK, OverworldClimate.DRY, 1D);
		OverworldBiomes.addHillsBiome(OUTBACK, OUTBACK, 1D);
		OverworldBiomes.addHillsBiome(OUTBACK, OUTBACK_ULURU, 0.4D);

		// Peat Bog
		TBOClassic.addCoast(OverworldClimate.DRY, PEAT_BOG, 1);

		// Rainforest
		OverworldBiomes.addContinentalBiome(RAINFOREST, OverworldClimate.DRY, 1D);
		OverworldBiomes.addBiomeVariant(RAINFOREST, RAINFOREST_MOUNTAINS, 0.35D);
		
		OverworldBiomes.addHillsBiome(RAINFOREST, RAINFOREST_MOUNTAINS, 1D);
		OverworldBiomes.addHillsBiome(RAINFOREST_MOUNTAINS, RAINFOREST, 1D);

		// Redwoods
		OverworldBiomes.addContinentalBiome(REDWOODS, OverworldClimate.TEMPERATE, 1D);

		// Shield
		OverworldBiomes.addContinentalBiome(SHIELD, OverworldClimate.COOL, 1D);
		OverworldBiomes.addHillsBiome(SHIELD, SHIELD, 1D);
		OverworldBiomes.addHillsBiome(SHIELD, Biomes.MOUNTAIN_EDGE, 1D);

		// Shrubland
		OverworldBiomes.addContinentalBiome(SHRUBLAND, OverworldClimate.TEMPERATE, 1D);
		
		// Steppe
		OverworldBiomes.addContinentalBiome(STEPPE, OverworldClimate.COOL, 1D);

		// Subtropical Rainforest
		OverworldBiomes.addContinentalBiome(SUBTROPICAL_RAINFOREST, OverworldClimate.TEMPERATE, 1D);
		OverworldBiomes.addHillsBiome(SUBTROPICAL_RAINFOREST, SUBTROPICAL_RAINFOREST, 1D);
		OverworldBiomes.addHillsBiome(SUBTROPICAL_RAINFOREST, FORESTED_SPIRES, 0.25D);
		
		// Subtropical Rainforest : Forested Spires, Continental Biome
		OverworldBiomes.addContinentalBiome(SUBTROPICAL_RAINFOREST, OverworldClimate.TEMPERATE, 0.1D);

		// Temperate Rainforest
		OverworldBiomes.addContinentalBiome(TEMPERATE_RAINFOREST, OverworldClimate.TEMPERATE, 1D);
		
		// Tropical Island
		OverworldBiomes.addBiomeVariant(Biomes.DEEP_OCEAN, TROPICAL_REEF, 0.15D);
		OverworldBiomes.addHillsBiome(TROPICAL_REEF, TROPICAL_ISLAND, 1D);
		OverworldBiomes.addShoreBiome(TROPICAL_REEF, TROPICAL_REEF, 1D);
		OverworldBiomes.addShoreBiome(TROPICAL_ISLAND, TROPICAL_ISLAND_SHORE, 1D);

		for (TBOBiome biome : tboBiomes) {
			RiverType riverType = biome.theBiomeFactory.getRiverType();
			if (riverType != RiverType.WATER) {
				OverworldBiomes.setRiverBiome(biome, biome.theBiomeFactory.getRiverType() == RiverType.ICY ? Biomes.FROZEN_RIVER : null);
			}
		}
	}

	private static Biome register(Biome biome, String id) {
		if (biome instanceof TBOBiome) {
			tboBiomes.add((TBOBiome) biome);
		}
		return Registry.register(Registry.BIOME, id, biome);
	}

	private static void addSpawnBiomes(Biome...biomes) {
		for (Biome b : biomes) {
			FabricBiomes.addSpawnBiome(b);
		}
	}
}
