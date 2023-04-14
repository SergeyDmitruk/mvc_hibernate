package by.dmitruk.app.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "name")
private String name;
@Column(name = "city")
private String city;

public User(int id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
}

public User() {
}

public User(String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
}

public int getId() {
    return id;
}


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

@Override
public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
}
}
