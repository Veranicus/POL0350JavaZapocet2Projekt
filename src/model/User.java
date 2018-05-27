package model;

public class User {

    private String loggingName;
    private String informations;


    public User(String loggingName, String informations) {
        this.loggingName = loggingName;
        this.informations = informations;
    }


    public User(String loggingName) {
        this.loggingName = loggingName;
    }

    public String getLoggingName() {
        return loggingName;
    }

    public void setLoggingName(String loggingName) {
        this.loggingName = loggingName;
    }

    public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }
}
