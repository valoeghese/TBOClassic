package tk.valoeghese.tboclassic.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import tk.valoeghese.tboclassic.util.BlockGenerator;
import tk.valoeghese.tboclassic.util.PublicWorldModifier;

public class BrushlandScrubFeature extends AbstractTreeFeature<DefaultFeatureConfig> implements PublicWorldModifier
{
	private static final BlockState LOG = Blocks.ACACIA_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();

	public BrushlandScrubFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1)
	{
		super(function_1, false);
	}

	public boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random random_1, BlockPos blockPos_1,  MutableIntBoundingBox mibb)
	{
		int height = 3;
		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1, mibb);

		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 && super.isNaturalDirtOrGrass(world, blockPos_1.down()))
		{
			generator.setBlock(blockPos_1.down(), Blocks.DIRT.getDefaultState(), true);
			
			generator.setBlock(blockPos_1.add(0, 0, 0), LOG, false);
			
			generator.setBlock(blockPos_1.add(1, 0, 0), LEAVES, true);
			generator.setBlock(blockPos_1.add(-1, 0, 0), LEAVES, true);
			generator.setBlock(blockPos_1.add(0, 0, 1), LEAVES, true);
			generator.setBlock(blockPos_1.add(0, 0, -1), LEAVES, true);

			generator.setBlock(blockPos_1.add(0, 1, 0), LEAVES, true);

			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}

	@Override
	public void setWorldBlockState(Set<BlockPos> set, ModifiableWorld world, BlockPos pos, BlockState state,  MutableIntBoundingBox mibb)
	{
		super.setBlockState(set, world, pos, state, mibb);
	}
}
