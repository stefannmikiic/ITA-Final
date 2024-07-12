package ita.compass.league.model;

public enum Field {
    FIELD_1("Field 1"),
    FIELD_2("Field 2");

    private final String name;

    Field(String name) {
        this.name = name;
    }

    public static Field fromString(String value) {
        for (Field field : Field.values()) {
            if (field.name.equalsIgnoreCase(value)) {
                return field;
            }
        }
        throw new IllegalArgumentException("Invalid Field: " + value);
    }
}
