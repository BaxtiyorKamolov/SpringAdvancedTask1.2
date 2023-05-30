package uz.pdp.springadvancedtask1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvancedtask1_2.entity.TestCasesTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.TestCasesTableDto;
import uz.pdp.springadvancedtask1_2.service.TestCasesTableService;

import java.util.List;

@RestController
public class TestCasesTableController {

    @Autowired
    TestCasesTableService testCasesTableService;

    @GetMapping("/api/testCasesTable")
    public ResponseEntity<List<TestCasesTable>> getTestCasesTable() {
        List<TestCasesTable> testCasesTable = testCasesTableService.getTestCasesTable();
        return ResponseEntity.ok(testCasesTable);
    }

    @GetMapping("/api/testCasesTable/{id}")
    public ResponseEntity<TestCasesTable> getTestCasesTableById(@PathVariable Integer id) {
        TestCasesTable testCasesTableById = testCasesTableService.getTestCasesTableById(id);
        return ResponseEntity.ok(testCasesTableById);
    }

    @PostMapping("/api/testCasesTable")
    public ResponseEntity<ApiResponse> addTestCasesTable(@RequestBody TestCasesTableDto testCasesTableDto) {
        ApiResponse apiResponse = testCasesTableService.addTestCasesTable(testCasesTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @PutMapping("/api/testCasesTable/{id}")
    public ResponseEntity<ApiResponse> editTestCasesTable(@PathVariable Integer id,
                                                          @RequestBody TestCasesTableDto testCasesTableDto) {
        ApiResponse apiResponse = testCasesTableService.editTestCasesTable(id, testCasesTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @DeleteMapping("/api/testCasesTable/{id}")
    public ResponseEntity<ApiResponse> deleteTestCasesTable(@PathVariable Integer id) {
        ApiResponse apiResponse = testCasesTableService.deleteTestCasesTable(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }
}
