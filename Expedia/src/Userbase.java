import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.io.IOException;


public class Userbase {

    public ArrayList userBase = new ArrayList(100);
    private ArrayList usernameList = new ArrayList(100);
    private ArrayList passwordList = new ArrayList(100);
    private ArrayList nameList = new ArrayList(100);

    public void addUsers(String username, String password, String userType, String name, String emailAddress) {
        User user = new User(username, password, userType, name, emailAddress);
        Interface i = new Interface();
        ObjectMapper objectMapper = new ObjectMapper();
        userBase.add(user);
        usernameList.add(username);
        passwordList.add(password);
        nameList.add(name);
            try {
                objectMapper.writeValue(Interface.userFile, user);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public User thisUser(String airline) {
        try {
            return objectMapper.readValue(new File(Interface.userFile), User.class)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String username(int index) {
        User user;
        user = (User) userBase.get(index);
        return user.getUsername();
    }

    public String password(int index) {
        User user;
        user = (User) userBase.get(index);
        return user.getPassword();
    }

    public String userType(int index) {
        User user;
        user = (User) userBase.get(index);
        return user.getUserType();
    }

    public String name(int index) {
        User user;
        user = (User) userBase.get(index);
        return user.getName();
    }

    public String emailAddress(int index) {
        User user;
        user = (User) userBase.get(index);
        return user.getEmailAddress();
    }

    public boolean validateUsernameSignIn(String userperson) {
        return usernameList.contains(userperson);
    }

    public boolean validatePasswordSignIn(String username, String password) {
        int arrayPosition = usernameList.indexOf(username);
        if (passwordList.get(arrayPosition).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public int getUserInformation(String username) {
        return usernameList.indexOf(username);
    }
}
