package uz.pdp.springadvancedtask1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.entity.SubmissionsTable;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.SubmissionsTableDto;
import uz.pdp.springadvancedtask1_2.repository.SubmissionsTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionsTableService {

    @Autowired
    SubmissionsTableRepository submissionsTableRepository;

    @Autowired
    ProblemsTableService problemsTableService;

    @Autowired
    UsersTableService usersTableService;

    public List<SubmissionsTable> getAllSubmissionsTable() {
        return submissionsTableRepository.findAll();
    }

    public SubmissionsTable getSubmissionsTableById(Integer id) {
        Optional<SubmissionsTable> optionalSubmissionsTable = submissionsTableRepository.findById(id);
        return optionalSubmissionsTable.orElse(null);
    }

    public ApiResponse addSubmissionsTable(SubmissionsTableDto submissionsTableDto) {
        SubmissionsTable submissionsTable = new SubmissionsTable();
        submissionsTable.setSubmissionDate(submissionsTableDto.getSubmissionDate());
        submissionsTable.setSolution(submissionsTableDto.getSolution());
        submissionsTable.setCorrect(submissionsTableDto.isCorrect());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                submissionsTableDto.getProblemsTablesIds());
        submissionsTable.setProblemsTables(problemsTableAllByIds);

        List<UsersTable> usersTableAllByIds = usersTableService.getUsersTableAllByIds(
                submissionsTableDto.getUsersTableIds());
        submissionsTable.setUsersTable(usersTableAllByIds);

        submissionsTableRepository.save(submissionsTable);
        return new ApiResponse("Qo'shildi", true);
    }

    public ApiResponse editSubmissionsTable(Integer id, SubmissionsTableDto submissionsTableDto) {
        Optional<SubmissionsTable> optionalSubmissionsTable = submissionsTableRepository.findById(id);
        SubmissionsTable submissionsTable = optionalSubmissionsTable.get();
        submissionsTable.setSolution(submissionsTableDto.getSolution());
        submissionsTable.setSubmissionDate(submissionsTableDto.getSubmissionDate());
        submissionsTable.setCorrect(submissionsTableDto.isCorrect());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                submissionsTableDto.getProblemsTablesIds());
        submissionsTable.setProblemsTables(problemsTableAllByIds);

        List<UsersTable> usersTableAllByIds = usersTableService.getUsersTableAllByIds(
                submissionsTableDto.getUsersTableIds());
        submissionsTable.setUsersTable(usersTableAllByIds);

        submissionsTableRepository.save(submissionsTable);
        return new ApiResponse("Tahrirlandi", true);
    }

    public ApiResponse deleteSubmissionsTable(Integer id) {
        try {
            submissionsTableRepository.deleteById(id);
            return new ApiResponse("O'chirildi", true);
        } catch (Exception e) {
            return new ApiResponse("O'chirilmadi", false);
        }
    }
}
