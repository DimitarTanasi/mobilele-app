package training.proj.mobilele.models.binding;

public class UserRegisterBingingModel {
    public String firstName;
    public String lastName;
    public String username;
    public String password;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBingingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBingingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBingingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBingingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
