public class FakeUserRepository implements UserRepository {

    private Collection < User > users = new ArrayList < User > ();

    public void save(User user) {

        if (findById(user.getId()) == null) {

            users.add(user);
        }
    }

    public User findById(long id) {

        for (User user: users) {
            if (user.getId() == id) return user;
        }
        return null;
    }
    public User findByUsername(String username) {
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

public interface UserRepository {
    void save(User user);
    User findById(long id);
    User findByUsername(String username);
}