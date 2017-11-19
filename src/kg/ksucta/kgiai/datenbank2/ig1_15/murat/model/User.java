package kg.ksucta.kgiai.datenbank2.ig1_15.murat.model;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String middleName;

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String middleName) {
        this(name, surname);
        this.middleName = middleName;
    }

    public User(Long id, String name, String surname, String middleName) {
        this(name, surname, middleName);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
