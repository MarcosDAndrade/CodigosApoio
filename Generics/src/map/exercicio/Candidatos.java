package map.exercicio;

public class Candidatos {
    private String name;
    private String votes;

    public Candidatos(String votes, String name) {
        this.votes = votes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
