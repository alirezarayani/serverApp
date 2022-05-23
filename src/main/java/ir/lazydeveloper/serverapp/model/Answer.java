package ir.lazydeveloper.serverapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="answer-seq")
    @SequenceGenerator(name = "answer-seq",sequenceName = "ANSWER_SEQ")
    private int id;
    private String answer;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_question_id")
    private Question question;
}
