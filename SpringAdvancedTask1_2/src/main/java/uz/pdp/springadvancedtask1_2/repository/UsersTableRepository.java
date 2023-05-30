package uz.pdp.springadvancedtask1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;

public interface UsersTableRepository extends JpaRepository<UsersTable, Integer> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndUserIdNot(String username, Integer userId);
}
