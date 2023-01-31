package tn.inteldev.helpers;

public enum Services {
    CUSTOMERS_SERVICE("http://cutomer-service/customers");

    public final String baseUrl;
    private Services(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
