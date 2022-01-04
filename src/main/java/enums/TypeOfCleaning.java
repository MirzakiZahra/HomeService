package enums;

public enum TypeOfCleaning {
    CLEAN("cl"),LAUNDRY("l"),CARPETCLEANING("cc"),WASHINGTHESOFA("w"),HOMESPRAYIN("h");
    private String abbr;
   TypeOfCleaning(String abbr) {
        this.abbr = abbr;
    }
    public String getAbbr() {
        return abbr;
    }
}
