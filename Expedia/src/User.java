public class User {

    String userType;
    String username;
    String password;
    String name;
    String emailAddress;
    int money;

    public User(String username, String password, String userType, String name, String emailAddress) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.name = name;
        this.emailAddress = emailAddress;
        this.money = 0;
    }

    public User thisIsTheUser(String userperson) {
        Userbase userbase = new Userbase();
        int index = userbase.getUserInformation(userperson);
        username = userbase.username(index);
        password = userbase.password(index);
        userType = userbase.userType(index);
        name = userbase.name(index);
        emailAddress = userbase.emailAddress(index);
        User currentUser = new User(username, password, userType, name, emailAddress);
        return currentUser;
    }

    public void subtractMoney(int price) {
        money -= price;
    }

    public void addMoney(int price) {
        money += price;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public int getMoney() {
        return money;
    }
}
