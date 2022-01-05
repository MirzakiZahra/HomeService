package enums;

public enum TypeOfService {
    BUILDINGDECORATION("bd"),BUILDINGFACILITIES("bf"),VEHICLES("v")
    ,MOVING("m")
    ,HOMEAPPLIANCES("h"),CLEANING("c");
    private String abbr;
    TypeOfService(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
