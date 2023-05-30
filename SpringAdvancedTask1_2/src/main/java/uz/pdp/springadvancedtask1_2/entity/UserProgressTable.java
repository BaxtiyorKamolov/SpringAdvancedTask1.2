package uz.pdp.springadvancedtask1_2.entity;

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
public class UserProgressTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userProgressId;

    @OneToMany()
    private List<UsersTable> usersTables;

    @OneToMany()
    private List<ProblemsTable> problemsTables;

    @Column(nullable = false)
    private Date lastSubmissionDate;


}
