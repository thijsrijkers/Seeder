import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.seedutils.mc.MCVersion;

import java.util.Random;

public class Seeder
{
    private long worldSeed;
    public int searchTimes;

    public void findBiome(String biome, int x, int y , int z)
    {
        makeSeed();

        BiomeSource source = getBiomeSource("OVERWORLD", worldSeed);
        String biomeType = source.getBiome(x, y, z).getName();
        //System.out.println(source.getBiome(0, 70, 0).getName());

        if(biome == biomeType)
        {
            System.out.println(worldSeed + "   "+biome+"");
            searchTimes -= 1;
        }

        if(biome != biomeType || searchTimes >= 0)
        {
            findBiome(biome, x, y, z);
        }
    }

    public static BiomeSource getBiomeSource(String dimension, long worldSeed)
    {
        BiomeSource source = null;
        source = new OverworldBiomeSource(MCVersion.v1_16, worldSeed);

        return source;
    }

    public long makeSeed()
    {
        Random random = new Random();
        worldSeed = random.nextInt(999999999 - 100000000 );

        return worldSeed;
    }

}
