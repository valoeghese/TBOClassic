package tk.valoeghese.tboclassic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.AddDeepOceanLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import tk.valoeghese.tboclassic.TBOClassic;

@Mixin(AddDeepOceanLayer.class)
public class CoastMixin {

	private static int OCEAN = Registry.BIOME.getRawId(Biomes.OCEAN);
	private static int WARM_OCEAN = Registry.BIOME.getRawId(Biomes.WARM_OCEAN);
	private static int LUKEWARM_OCEAN = Registry.BIOME.getRawId(Biomes.LUKEWARM_OCEAN);
	private static int COLD_OCEAN = Registry.BIOME.getRawId(Biomes.COLD_OCEAN);
	private static int FROZEN_OCEAN = Registry.BIOME.getRawId(Biomes.FROZEN_OCEAN);
	private static int DEEP_WARM_OCEAN = Registry.BIOME.getRawId(Biomes.DEEP_WARM_OCEAN);
	private static int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getRawId(Biomes.DEEP_LUKEWARM_OCEAN);
	private static int DEEP_OCEAN = Registry.BIOME.getRawId(Biomes.DEEP_OCEAN);
	private static int DEEP_COLD_OCEAN = Registry.BIOME.getRawId(Biomes.DEEP_COLD_OCEAN);
	private static int DEEP_FROZEN_OCEAN = Registry.BIOME.getRawId(Biomes.DEEP_FROZEN_OCEAN);

	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource rand, int e1, int e2, int e3, int e4, int centre, CallbackInfoReturnable<Integer> info) {
		int centreModif = centre & -3841;
		if (!isOcean(centreModif)) {
			if (rand.nextInt(4) == 0 && (isOcean(e1) || isOcean(e2) || isOcean(e3) || isOcean(e4))) {
				int result = TBOClassic.transformCoast(centreModif, rand);
				if (result != centreModif) {
					info.setReturnValue(result);
				}
			}
		}
	}

	private static boolean isOcean(int id) {
		return id == WARM_OCEAN || id == LUKEWARM_OCEAN || id == OCEAN || id == COLD_OCEAN || id == FROZEN_OCEAN || id == DEEP_WARM_OCEAN || id == DEEP_LUKEWARM_OCEAN || id == DEEP_OCEAN || id == DEEP_COLD_OCEAN || id == DEEP_FROZEN_OCEAN;
	}
}