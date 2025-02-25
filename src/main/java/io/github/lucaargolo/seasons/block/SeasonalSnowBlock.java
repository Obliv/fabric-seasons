package io.github.lucaargolo.seasons.block;

import io.github.lucaargolo.seasons.FabricSeasons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;

public class SeasonalSnowBlock extends SnowBlock {

    public SeasonalSnowBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY, pos) > 0 && world.getBiome(pos).value().getTemperature(pos) >= 0.15F) {
            Block.dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    public String getTranslationKey() {
        return FabricSeasons.ORIGINAL_SNOW.getTranslationKey();
    }

    @Override
    protected Block asBlock() {
        return FabricSeasons.ORIGINAL_SNOW;
    }

    @Override
    public Item asItem() {
        return FabricSeasons.ORIGINAL_SNOW.asItem();
    }
}