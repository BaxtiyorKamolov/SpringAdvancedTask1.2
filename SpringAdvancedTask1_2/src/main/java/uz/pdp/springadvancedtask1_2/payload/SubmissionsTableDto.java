package uz.pdp.springadvancedtask1_2.payload;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionsTableDto {

    private List<Integer> problemsTablesIds;


    private List<Integer> usersTableIds;


    private String solution;


    private Date submissionDate;

    private boolean isCorrect;
}
