package no.netcompany.edu.springboot.model;

public enum Status {

    AVAILABLE("available"),

    PENDING("pending"),

    SOLD("sold");

    private final String value;

    public String getValue() {
        return value;
    }

    Status(final String value) {
        this.value = value;
    }
}
