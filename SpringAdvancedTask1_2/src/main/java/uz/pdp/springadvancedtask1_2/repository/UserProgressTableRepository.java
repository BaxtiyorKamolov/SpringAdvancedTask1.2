package uz.pdp.springadvancedtask1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvancedtask1_2.entity.UserProgressTable;

public interface UserProgressTableRepository extends JpaRepository<UserProgressTable, Integer> {
}
