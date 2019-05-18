package Contact;

public enum Status {
    SPPROVe("APPROVE"),
    PENDING("PENDING");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
