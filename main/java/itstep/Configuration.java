package itstep;

public class Configuration {
    private String name;

    public Configuration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "name='" + name + '\'' +
                '}';
    }
}
