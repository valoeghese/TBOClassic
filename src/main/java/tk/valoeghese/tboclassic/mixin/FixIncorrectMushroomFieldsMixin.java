package tk.valoeghese.tboclassic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.SetBaseBiomesLayer;

@Mixin(SetBaseBiomesLayer.class)
public class FixIncorrectMushroomFieldsMixin {
	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void onSample(LayerRandomnessSource rand, int value, CallbackInfoReturnable<Integer> info) {
		int trueValue = value &= -3841;
		if (trueValue > 50) { // Basically is it a value that would only be found here due to mods
			info.setReturnValue(trueValue);
		}
	}
}
