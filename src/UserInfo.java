public class UserInfo {

    // Create private variables
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    // Constructor that takes all parameters
    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    // Step 3: Getter methods (to get values)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    // Step 4: Setter methods (to change values)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // display user info in a nice format
    public void displayInfo() {
        System.out.println("---------- User Info ----------");
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Email    : " + email);
        System.out.println("Is Active: " + (isActive ? "Yes" : "No"));
        System.out.println("--------------------------------\n");
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Create 3 user objects
        UserInfo user1 = new UserInfo("Manar", 25, "manar@example.com", true);
        UserInfo user2 = new UserInfo("Ali", 30, "ali@example.com", false);
        UserInfo user3 = new UserInfo("Fatima", 22, "fatima@example.com", true);

        // Display their information
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        // Test setters (update user2's email and active status)
        user2.setEmail("ali.new@example.com");
        user2.setIsActive(true);

        // Display updated user2 info
        System.out.println("Updated Info for Ali:");
        user2.displayInfo(); //set
    }
}
