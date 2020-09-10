public class Searcher
{
    public static void main(String[] args) {
        Seeder seed = new Seeder();
        seed.searchTimes = 10;
        seed.findBiome("forest", 0, 70 ,0);
    }
}
