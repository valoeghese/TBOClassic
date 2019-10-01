package tk.valoeghese.tboclassic;

import static tk.valoeghese.tboclassic.util.LoopUtil.repeat;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import tk.valoeghese.tboclassic.init.TBOBiomes;
import tk.valoeghese.tboclassic.world.CustomSurfaceBuilders;

public class TBOClassic implements ModInitializer
{
	private static final Logger logger = LogManager.getLogger("TBO Classic");

	private static final List<Biome> snowyCoastBiomes = Lists.newArrayList();
	private static final List<Biome> coolCoastBiomes = Lists.newArrayList();
	private static final List<Biome> temperateCoastBiomes = Lists.newArrayList();
	private static final List<Biome> dryCoastBiomes = Lists.newArrayList();
	private static final Map<Biome, Biome> largeEdges = Maps.<Biome, Biome>newHashMap();

	private static final int
	DRY = 1,
	TEMPERATE = 2,
	COOL = 3,
	SNOWY = 4;

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public void onInitialize() {
		CustomSurfaceBuilders.registerBuilders();

		TBOBiomes.registerBiomes();
		TBOBiomes.addBiomeGen();

		Biomes.GIANT_TREE_TAIGA.addStructureFeature(Feature.WOODLAND_MANSION, FeatureConfig.DEFAULT);

		LoadMessages.logMessage(new Random());
	}

	public static void addCoast(OverworldClimate temperature, Biome biome, int weight) {
		switch (temperature) {
		case SNOWY:
			repeat(weight, j -> snowyCoastBiomes.add(biome));
			break;
		case COOL:
			repeat(weight, j -> coolCoastBiomes.add(biome));
			break;
		case TEMPERATE:
			repeat(weight, j -> temperateCoastBiomes.add(biome));
			break;
		case DRY:
			repeat(weight, j -> dryCoastBiomes.add(biome));
			break;
		default:
			break;
		}
	}
	
	public static void setLargeEdge(Biome biome, Biome largeEdge) {
		largeEdges.put(biome, largeEdge);
	}

	public static int transformCoast(int id, LayerRandomnessSource rand) {
//		Biome.TemperatureGroup temperature = Registry.BIOME.get(id).getTemperatureGroup();
		
		if (id == SNOWY) {
			return snowyCoastBiomes.isEmpty() ? id : Registry.BIOME.getRawId(snowyCoastBiomes.get(rand.nextInt(snowyCoastBiomes.size())));
		} else if (id == COOL) {
			return coolCoastBiomes.isEmpty() ? id : Registry.BIOME.getRawId(coolCoastBiomes.get(rand.nextInt(coolCoastBiomes.size())));
		} else if (id == TEMPERATE) {
			return temperateCoastBiomes.isEmpty() ? id : Registry.BIOME.getRawId(temperateCoastBiomes.get(rand.nextInt(temperateCoastBiomes.size())));
		} else if (id == DRY) {
			return dryCoastBiomes.isEmpty() ? id : Registry.BIOME.getRawId(dryCoastBiomes.get(rand.nextInt(dryCoastBiomes.size())));
		}

		return id;
	}

	public static int transformLargeEdge(Biome biome, int id) {
		return largeEdges.containsKey(biome) ? Registry.BIOME.getRawId(largeEdges.get(biome)) : id;
	}
}
