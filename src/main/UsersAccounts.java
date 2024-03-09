import java.util.ArrayList;

public class UsersAccounts {
    private ArrayList<Pair<User, String>> users;

    public UsersAccounts(){
        users = new ArrayList<Pair<User, String>>();
    }

    public boolean createUser(String userName, String password) throws Exception {
        for (Pair<User, String> acc : users)
        {
            if (acc.getFirst().getUserName().equals(userName)){
                throw new Exception("An account with the same name already exists.");
            }
        }
        users.add(new Pair<User, String>(new User(0, userName), password));
        return true;
    }

    public User getUser(String userName, String password) throws Exception {
        boolean userIsFind = false;
        Pair<User, String> findUser = null;
        for (Pair<User, String> acc : users)
        {
            if (acc.getFirst().getUserName().equals(userName)){
                userIsFind = true;
                findUser = acc;
                break;
            }
        }
        if (!userIsFind)
        {
            throw new Exception("User is not found.");
        }
        if (!findUser.getSecond().equals(password)){
            throw new Exception("Incorrect password.");
        }

        return findUser.getFirst();
    }

}

