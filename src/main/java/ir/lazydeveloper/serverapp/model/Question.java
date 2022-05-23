package ir.lazydeveloper.serverapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="question-seq")
    @SequenceGenerator(name = "question-seq",sequenceName = "QUESTION_SEQ")
    private int id;
    @Column(columnDefinition="TEXT")
    private String question;
    @Column(columnDefinition="TEXT")
    private String description;
    private short difficulty;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgrammingLanguage language;
    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private List<Answer> answers = new ArrayList<>();
}
