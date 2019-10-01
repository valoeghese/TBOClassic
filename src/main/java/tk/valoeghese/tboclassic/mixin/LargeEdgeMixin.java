package tk.valoeghese.tboclassic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.EaseBiomeEdgeLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import tk.valoeghese.tboclassic.TBOClassic;
import tk.valoeghese.tboclassic.init.TBOBiomes;

@Mixin(EaseBiomeEdgeLayer.class)
public class LargeEdgeMixin {
	
	private static int rainforestId1 = -1;
	private static int rainforestId2 = -1;
	
	@Inject(method = "sample", at = @At("HEAD"), cancellable = true)
	private void mixinSample(LayerRandomnessSource rand, int neighbour1, int neighbour2, int neighbour3, int neighbour4, int centre, CallbackInfoReturnable<Integer> info) {
		if (neighbour1 != centre || neighbour2 != centre || neighbour3 != centre || neighbour4 != centre) {
			Biome biome = Registry.BIOME.get(centre);
			
			// Ease rainforest edge in dry climates
			if (biome.getTemperatureGroup() == Biome.TemperatureGroup.WARM && biome != TBOBiomes.BRUSHLAND) {
				rainforestId1 = Registry.BIOME.getRawId(TBOBiomes.RAINFOREST);
				rainforestId2 = Registry.BIOME.getRawId(TBOBiomes.RAINFOREST_MOUNTAINS);
				
				if (isRainforest(neighbour1) || isRainforest(neighbour2) || isRainforest(neighbour3) || isRainforest(neighbour4)) {
					info.setReturnValue(Registry.BIOME.getRawId(TBOBiomes.BRUSHLAND));
				}
			}
			
			int result = TBOClassic.transformLargeEdge(biome, centre);
			
			if (result != centre) {
				info.setReturnValue(result);
			}
		}
	}
	
	private static boolean isRainforest(int id) {
		return id == rainforestId1 || id == rainforestId2;
	}
}