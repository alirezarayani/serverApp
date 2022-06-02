package ir.lazydeveloper.serverapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq-language")
    @SequenceGenerator(name = "seq-language", sequenceName = "LANGUAGE_SEQ")
    private int id;

    @Column(unique = true, nullable = false)
    private String language;
}
