package enums;

public enum TypeOfOrder {
    WAITINGFOREXPERTSUGGESTION("ws"),WAITINGFORSPECIALISTSELECTION("wse"),
    WAITINGFORTHESPECIALISTTOARRIVE("wa"),STARTED("s"),DONE("d"),PAID("p");
    private String abbr;
    public String getAbbr() {
        return abbr;
    }
    TypeOfOrder(String abbr) {
        this.abbr = abbr;
    }
}
