package uz.pdp.springadvancedtask1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.entity.TestCasesTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.TestCasesTableDto;
import uz.pdp.springadvancedtask1_2.repository.TestCasesTableRepository;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Service
public class TestCasesTableService {

    @Autowired
    TestCasesTableRepository testCasesTableRepository;

    @Autowired
    ProblemsTableService problemsTableService;

    public List<TestCasesTable> getTestCasesTable() {
        return testCasesTableRepository.findAll();
    }

    public TestCasesTable getTestCasesTableById(Integer id) {
        Optional<TestCasesTable> byId = testCasesTableRepository.findById(id);
        return byId.orElse(null);
    }

    public ApiResponse addTestCasesTable(TestCasesTableDto testCasesTableDto) {
        TestCasesTable testCasesTable = new TestCasesTable();
        testCasesTable.setInput(testCasesTableDto.getInput());
        testCasesTable.setExpectedOutput(testCasesTableDto.getExpectedOutput());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                testCasesTableDto.getProblemsTables());
        testCasesTable.setProblemsTables(problemsTableAllByIds);

        testCasesTableRepository.save(testCasesTable);
        return new ApiResponse("Qoshildi", true);
    }

    public ApiResponse editTestCasesTable(Integer id, TestCasesTableDto testCasesTableDto) {
        Optional<TestCasesTable> optionalTestCasesTable = testCasesTableRepository.findById(id);
        if (optionalTestCasesTable.isEmpty()) {
            return new ApiResponse("Mavjud emas", false);
        }
        TestCasesTable testCasesTable = optionalTestCasesTable.get();
        testCasesTable.setInput(testCasesTableDto.getInput());
        testCasesTable.setExpectedOutput(testCasesTableDto.getExpectedOutput());

        List<ProblemsTable> problemsTableAllByIds = problemsTableService.getProblemsTableAllByIds(
                testCasesTableDto.getProblemsTables());
        testCasesTable.setProblemsTables(problemsTableAllByIds);

        testCasesTableRepository.save(testCasesTable);

        return new ApiResponse("Tahrirlandi", true);
    }

    public ApiResponse deleteTestCasesTable(Integer id) {
        try {
            testCasesTableRepository.deleteById(id);
            return new ApiResponse("O'chirildi", true);
        } catch (Exception e) {
            return new ApiResponse("Topilmadi", false);
        }
    }
}
