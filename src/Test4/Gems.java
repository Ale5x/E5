package Test4;

public interface Gems {


    String TOPAZ_NAME = "TOPAZ";
    String DIAMOND_NAME = "DIAMOND";
    String EMERALD_NAME = "EMERALD";
    String SAPPHIRE_NAME = "SAPPHIRE";
    String RUBY_NAME = "RUBY";


    int TOPAZ = 25;
    int DIAMOND = 50;
    int EMERALD = 30;
    int SAPPHIRE = 25;
    int RUBY = 30;

    int getCostTopaz();
    int getCostDiamond();
    int getCostEmerald();
    int getCostSapphire();
    int getCostRuby();
    int setCostTopaz();
    int setCostDiamond();
    int setCostEmerald();
    int setCostSapphire();
    int setCostRuby();

    String getNameTopaz();
    String getNameDiamond();
    String getNameEmerald();
    String getNameSapphire();
    String getNameRuby();
    String setNameTopaz();
    String setNameDiamond();
    String setNameEmerald();
    String setNameSapphire();
    String setNameRuby();
}