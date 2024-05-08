package linad.FraimworkHWLes5.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String text;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean status;
}
