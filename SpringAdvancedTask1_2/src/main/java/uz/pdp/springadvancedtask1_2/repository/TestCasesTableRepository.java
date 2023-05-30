package uz.pdp.springadvancedtask1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvancedtask1_2.entity.TestCasesTable;

public interface TestCasesTableRepository extends JpaRepository<TestCasesTable,Integer> {

}
