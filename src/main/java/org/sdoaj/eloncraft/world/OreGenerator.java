package org.sdoaj.eloncraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.sdoaj.eloncraft.blocks.ModBlocks;

import java.util.Random;
import java.util.function.Predicate;

public class OreGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            // nether
            case -1:
                break;
            // overworld
            case 0:
                runGenerator(ModBlocks.COMPONENTS.getDefaultState(), 10, 15, 8, 63,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);

                runGenerator(ModBlocks.ALUMINUM_ORE.getDefaultState(), 10, 60, 0, 63,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.TITANIUM_ORE.getDefaultState(), 8, 40, 0, 47,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.LITHIUM_ORE.getDefaultState(), 5, 20, 0, 47,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.NICKEL_ORE.getDefaultState(), 8, 25, 0, 47,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.CHROMIUM_ORE.getDefaultState(), 5, 15, 0, 31,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.COPPER_ORE.getDefaultState(), 10, 50, 0, 63,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.NIOBIUM_ORE.getDefaultState(), 8, 30, 0, 31,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.HAFNIUM_ORE.getDefaultState(), 4, 15, 0, 31,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.MAGNESIUM_ORE.getDefaultState(), 6, 20, 0, 47,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                runGenerator(ModBlocks.ZINC_ORE.getDefaultState(), 5, 20, 0, 47,
                        BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                break;
            // end
            case 1:
                break;
            default:
                break;
        }
    }

    private void runGenerator(IBlockState blockToGenerate, int veinSize, int spawnChances, int minY, int maxY,
                              Predicate<IBlockState> blockToReplace, World world, Random random, int chunkX, int chunkZ) {
        if (minY < 0 || maxY > 256 || minY > maxY)
            throw new IllegalArgumentException("illegal height arguments for OreGenerator");

        WorldGenMinable generator = new WorldGenMinable(blockToGenerate, veinSize, (com.google.common.base.Predicate<IBlockState>) blockToReplace);
        int dy = maxY - minY + 1;
        for (int i = 0; i < spawnChances; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = minY + random.nextInt(dy);
            int z = chunkZ * 16 + random.nextInt(16);
            generator.generate(world, random, new BlockPos(x, y, z));
        }
    }
}