package kg.ksucta.kgiai.datenbank2.ig1_15.murat.model;

public class Currency {
    private Long id;
    private String name;

    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }

    public Currency(Long id, String name) {
        this(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
