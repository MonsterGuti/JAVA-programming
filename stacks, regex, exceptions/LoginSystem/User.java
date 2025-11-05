package SU3.LoginSystem;

public class User {
    private final String username;
    private final String password;
    private int failedAttempts = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public void login(String inputPassword) throws WrongPasswordException, UserBlockedException {
        if (failedAttempts >= 3) {
            throw new UserBlockedException("Blocked user");
        }

        if (!password.equals(inputPassword)) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                throw new UserBlockedException("Blocked user");
            }
            throw new WrongPasswordException("Wrong password №" + failedAttempts);
        }

        System.out.println("Succeed, hello " + username + "!");
        failedAttempts = 0;
    }
}

