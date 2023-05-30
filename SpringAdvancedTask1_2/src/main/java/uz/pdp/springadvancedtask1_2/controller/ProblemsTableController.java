package uz.pdp.springadvancedtask1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvancedtask1_2.entity.ProblemsTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.ProblemsTableDto;
import uz.pdp.springadvancedtask1_2.service.ProblemsTableService;

import java.util.List;

@RestController
public class ProblemsTableController {

    @Autowired
    ProblemsTableService problemsTableService;

    @GetMapping("/api/problemsTable")
    public ResponseEntity<List<ProblemsTable>> getAllProblemsTable() {
        List<ProblemsTable> allProblemsTable = problemsTableService.getAllProblemsTable();
        return ResponseEntity.ok(allProblemsTable);
    }

    @GetMapping("/api/problemsTable/{id}")
    public ResponseEntity<ProblemsTable> getProblemsTableById(@PathVariable Integer id) {
        ProblemsTable problemsTableById = problemsTableService.getProblemsTableById(id);
        return ResponseEntity.ok(problemsTableById);
    }

    @PostMapping("/api/problemsTable")
    public ResponseEntity<ApiResponse> addProblemsTable(@RequestBody ProblemsTableDto problemsTableDto) {
        ApiResponse apiResponse = problemsTableService.addProblemsTable(problemsTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @PutMapping("/api/problemsTable/{id}")
    public ResponseEntity<ApiResponse> editProblemsTable(@PathVariable Integer id,
                                                         @RequestBody ProblemsTableDto problemsTableDto) {
        ApiResponse apiResponse = problemsTableService.addProblemsTable(problemsTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @DeleteMapping("/api/problemsTable/{id}")
    public ResponseEntity<ApiResponse> deleteProblemsTable(@PathVariable Integer id) {
        ApiResponse apiResponse = problemsTableService.deleteProblemsTable(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }
}
