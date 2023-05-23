package itstep;

public class UserDao {
    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "sessionFactory=" + sessionFactory +
                '}';
    }
}
