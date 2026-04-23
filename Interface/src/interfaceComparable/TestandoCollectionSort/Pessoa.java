package interfaceComparable.TestandoCollectionSort;

public class Pessoa {
    private String name;

    public Pessoa() {
    }

    public Pessoa(String name) {
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
        return  name;
    }
}
