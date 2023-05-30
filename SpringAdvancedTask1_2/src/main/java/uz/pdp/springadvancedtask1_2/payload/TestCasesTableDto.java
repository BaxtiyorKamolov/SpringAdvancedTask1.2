package uz.pdp.springadvancedtask1_2.payload;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCasesTableDto {

    private List<Integer> problemsTables;


    private String input;


    private String expectedOutput;
}
