package uz.pdp.springadvancedtask1_2.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemsTableDto {


    private String title;

    private String description;

    private String difficultyLevel;
}
