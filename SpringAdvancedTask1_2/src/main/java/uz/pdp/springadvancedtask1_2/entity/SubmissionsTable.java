package uz.pdp.springadvancedtask1_2.entity;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubmissionsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer submissionId;

    @OneToMany()
    private List<ProblemsTable> problemsTables;

    @OneToMany()
    private List<UsersTable> usersTable;

    @Column(nullable = false)
    private String solution;

    @Column(nullable = false)
    private Date submissionDate;

    private boolean isCorrect;


}
