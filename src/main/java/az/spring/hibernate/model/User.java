package az.spring.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usertest")
@Data
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;

    private String name;
    private String surname;
    private int age;
    private int salary;
}
