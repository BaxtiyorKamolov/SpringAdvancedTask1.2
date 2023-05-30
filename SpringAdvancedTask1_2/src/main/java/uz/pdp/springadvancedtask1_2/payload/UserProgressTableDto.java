package uz.pdp.springadvancedtask1_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProgressTableDto {

    private List<Integer> usersTables;


    private List<Integer> problemsTables;


    private Date lastSubmissionDate;
}
