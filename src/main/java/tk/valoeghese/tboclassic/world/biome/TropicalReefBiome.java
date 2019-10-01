package tk.valoeghese.tboclassic.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import tk.valoeghese.tboclassic.world.CustomBiomeFeatures;
import tk.valoeghese.tboclassic.world.biome.BiomeFactory.RiverType;

public class TropicalReefBiome extends TBOBiome {

	public TropicalReefBiome() {
		super(BiomeFactory.create(-0.62F, 0.025F, Biome.Category.OCEAN).setTemperatureDownfall(1.1F, 0.7F).setRiverType(RiverType.NONE).setWaterProperties(4445678, 270131));

		this.setTopBlock(Blocks.SAND.getDefaultState());
		this.setFillerBlock(Blocks.SAND.getDefaultState());
		this.setUnderwaterBlock(Blocks.SAND.getDefaultState());
		this.theBiomeFactory.addDefaultGeneration();
		DefaultBiomeFeatures.addDefaultLakes(this);
		this.theBiomeFactory.addDefaultMineables();
		CustomBiomeFeatures.addPalms(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDefaultGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
	}

}
