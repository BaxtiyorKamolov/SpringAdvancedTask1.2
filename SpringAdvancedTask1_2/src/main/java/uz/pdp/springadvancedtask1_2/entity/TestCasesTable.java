package uz.pdp.springadvancedtask1_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TestCasesTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testCaseId;

    @OneToMany()
    private List<ProblemsTable> problemsTables;

    @Column(nullable = false)
    private String input;

    @Column(nullable = false)
    private String expectedOutput;


}
