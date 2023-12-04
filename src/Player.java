public class Player {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 20) {
            this.name = name;
        }
        else {
            this.name = name.substring(0, 19);
        }
    }
}
