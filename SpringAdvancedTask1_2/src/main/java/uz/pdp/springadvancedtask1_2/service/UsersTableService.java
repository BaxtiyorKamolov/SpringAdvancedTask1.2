package uz.pdp.springadvancedtask1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.UsersTableDto;
import uz.pdp.springadvancedtask1_2.repository.UsersTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersTableService {

    @Autowired
    UsersTableRepository usersTableRepository;

    public List<UsersTable> getAllUsersTable() {
        return usersTableRepository.findAll();
    }

    public UsersTable getUsersTableId(Integer id) {
        return usersTableRepository.findById(id).orElse(null);
    }

    public List<UsersTable> getUsersTableAllByIds(List<Integer> ids) {
        return usersTableRepository.findAllById(ids);
    }

    public ApiResponse addUsersTable(UsersTableDto usersTableDto) {
        boolean existsByUsername = usersTableRepository.existsByUsername(usersTableDto.getUsername());
        if (existsByUsername) {
            return new ApiResponse("Bunday username mavjud", false);
        }
        UsersTable usersTable = new UsersTable();
        usersTable.setUsername(usersTableDto.getUsername());
        usersTable.setPassword(usersTableDto.getPassword());
        usersTable.setEmail(usersTableDto.getEmail());
        usersTable.setRegistrationDate(usersTableDto.getRegistrationDate());
        usersTableRepository.save(usersTable);
        return new ApiResponse("UsersTable saqlandi", true);
    }

    public ApiResponse editUsersTable(Integer id, UsersTableDto usersTableDto) {
        boolean existsByUsernameAndUserIdNot = usersTableRepository.existsByUsernameAndUserIdNot(
                usersTableDto.getUsername(), id);
        if (existsByUsernameAndUserIdNot) {
            return new ApiResponse("Bunday username mavjud", false);
        }
        Optional<UsersTable> optionalUsersTable = usersTableRepository.findById(id);
        if (optionalUsersTable.isEmpty()) {
            return new ApiResponse("Bunday username mavjud emas", false);
        }
        UsersTable usersTable = optionalUsersTable.get();
        usersTable.setUsername(usersTableDto.getUsername());
        usersTable.setPassword(usersTableDto.getPassword());
        usersTable.setEmail(usersTableDto.getEmail());
        usersTable.setRegistrationDate(usersTableDto.getRegistrationDate());
        usersTableRepository.save(usersTable);
        return new ApiResponse("Tahrirlandi", true);
    }

    public ApiResponse deleteUsersTable(Integer id) {
        try {
            usersTableRepository.deleteById(id);
            return new ApiResponse("Mijoz ochirildi", true);
        } catch (Exception e) {
            return new ApiResponse("Mijoz mavjud emas", false);
        }
    }
}
