package model.enums;

public enum UserStatue {
    NEW("n"),AWAITINGAPPROVAL("a"),CONFIRMED("c");
    private String abbr;
    UserStatue(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
