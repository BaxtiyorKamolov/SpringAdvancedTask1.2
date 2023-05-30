package uz.pdp.springadvancedtask1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.ProblemsTableDto;
import uz.pdp.springadvancedtask1_2.repository.ProblemsTableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemsTableService {

    @Autowired
    ProblemsTableRepository problemsTableRepository;

    public List<ProblemsTable> getAllProblemsTable() {
        return problemsTableRepository.findAll();
    }

    public ProblemsTable getProblemsTableById(Integer id) {
        Optional<ProblemsTable> optionalProblemsTable = problemsTableRepository.findById(id);
        return optionalProblemsTable.orElse(null);
    }

    public List<ProblemsTable> getProblemsTableAllByIds(List<Integer> problemId) {
        return problemsTableRepository.findAllById(problemId);
    }

    public ApiResponse addProblemsTable(ProblemsTableDto problemsTableDto) {
        boolean existsByDescription = problemsTableRepository.existsByDescription(
                problemsTableDto.getDescription());
        if (existsByDescription) {
            return new ApiResponse("Bunday tavsif mavjud", false);
        }
        ProblemsTable problemsTable = new ProblemsTable();
        problemsTable.setTitle(problemsTableDto.getTitle());
        problemsTable.setDescription(problemsTableDto.getDescription());
        problemsTable.setDifficultyLevel(problemsTableDto.getDifficultyLevel());
        problemsTableRepository.save(problemsTable);
        return new ApiResponse("Saqlandi savol", true);
    }

    public ApiResponse editProblemsTable(Integer id, ProblemsTableDto problemsTableDto) {
        boolean existsByDescriptionAndProblemIdNot = problemsTableRepository.existsByDescriptionAndProblemIdNot(
                problemsTableDto.getDescription(), id);
        if (existsByDescriptionAndProblemIdNot) {
            return new ApiResponse("Bunday tavsif mavjud", false);
        }
        Optional<ProblemsTable> optionalProblemsTable = problemsTableRepository.findById(id);
        if (optionalProblemsTable.isEmpty()) {
            return new ApiResponse("Bunday bunday tavsif mavjud emas", false);
        }
        ProblemsTable problemsTable = optionalProblemsTable.get();
        problemsTable.setTitle(problemsTableDto.getTitle());
        problemsTable.setDescription(problemsTableDto.getDescription());
        problemsTable.setDifficultyLevel(problemsTableDto.getDifficultyLevel());
        problemsTableRepository.save(problemsTable);
        return new ApiResponse("Tahrirlandi", true);
    }

    public ApiResponse deleteProblemsTable(Integer id) {
        try {
            problemsTableRepository.deleteById(id);
            return new ApiResponse("O'chirildi", true);
        } catch (Exception e) {
            return new ApiResponse("mavjud emas", false);
        }
    }
}
