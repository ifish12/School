/**
 * Created by ian on 15-10-08.
 */
public enum UserType {
    DEVELOPER("DEVELOPER"),
    CUSTOMER("CUSTOMER"),
    MANAGER("MANAGER"),
    TESTER("TESTER");

    private String text;

    UserType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static UserType fromString(String text) {
        if (text != null) {
            for (UserType b : UserType.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}
