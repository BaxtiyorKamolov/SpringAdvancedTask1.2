package uz.pdp.springadvancedtask1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;

import java.util.List;

public interface ProblemsTableRepository extends JpaRepository<ProblemsTable, Integer> {
    boolean existsByDescription(String description);
    boolean existsByDescriptionAndProblemIdNot(String description, Integer problemId);

//    List<ProblemsTable> findAllBy
}
