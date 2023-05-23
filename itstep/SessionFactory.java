package itstep;

public class SessionFactory {
    private Configuration config;

    public SessionFactory(Configuration config){
        this.config = config;
    }

    public Configuration getConfig() {
        return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "SessionFactory{" +
                "config=" + config +
                '}';
    }
}
