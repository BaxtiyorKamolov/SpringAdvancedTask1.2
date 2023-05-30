package uz.pdp.springadvancedtask1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.entity.UserProgressTable;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.UserProgressTableDto;
import uz.pdp.springadvancedtask1_2.repository.UserProgressTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserProgressTableService {
    @Autowired
    UserProgressTableRepository userProgressTableRepository;

    @Autowired
    UsersTableService usersTableService;

    @Autowired
    ProblemsTableService problemsTableService;

    public List<UserProgressTable> getUserProgressTable() {
        return userProgressTableRepository.findAll();
    }

    public UserProgressTable getUserProgressTableById(Integer id) {
        Optional<UserProgressTable> optionalUserProgressTable = userProgressTableRepository.findById(id);
        return optionalUserProgressTable.orElse(null);
    }

    public ApiResponse addUserProgressTable(UserProgressTableDto userProgressTableDto) {
        UserProgressTable userProgressTable = new UserProgressTable();
        userProgressTable.setLastSubmissionDate(userProgressTableDto.getLastSubmissionDate());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                userProgressTableDto.getProblemsTables());
        userProgressTable.setProblemsTables(problemsTableAllByIds);

        List<UsersTable> usersTableAllByIds = usersTableService.getUsersTableAllByIds(
                userProgressTableDto.getUsersTables());
        userProgressTable.setUsersTables(usersTableAllByIds);

        userProgressTableRepository.save(userProgressTable);

        return new ApiResponse("Qo'shildi", true);
    }

    public ApiResponse editUserProgressTable(Integer id, UserProgressTableDto userProgressTableDto) {
        Optional<UserProgressTable> optionalUserProgressTable = userProgressTableRepository.findById(id);
        if (optionalUserProgressTable.isEmpty()) {
            return new ApiResponse("Mavjud emas", false);
        }
        UserProgressTable userProgressTable = optionalUserProgressTable.get();
        userProgressTable.setLastSubmissionDate(userProgressTableDto.getLastSubmissionDate());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                userProgressTableDto.getProblemsTables());
        userProgressTable.setProblemsTables(problemsTableAllByIds);

        List<UsersTable> usersTableAllByIds = usersTableService.getUsersTableAllByIds(
                userProgressTableDto.getUsersTables());
        userProgressTable.setUsersTables(usersTableAllByIds);

        userProgressTableRepository.save(userProgressTable);
        return new ApiResponse("Tahrirlandi", true);
    }

    public ApiResponse deleteUserProgressTable(Integer id) {
        try {
            userProgressTableRepository.deleteById(id);
            return new ApiResponse("O'chirildi", true);
        } catch (Exception e) {
            return new ApiResponse("Topilmadi", false);
        }
    }
}
