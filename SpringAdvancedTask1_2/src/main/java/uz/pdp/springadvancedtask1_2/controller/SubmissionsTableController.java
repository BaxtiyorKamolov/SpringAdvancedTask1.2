package uz.pdp.springadvancedtask1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvancedtask1_2.entity.SubmissionsTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.SubmissionsTableDto;
import uz.pdp.springadvancedtask1_2.repository.SubmissionsTableRepository;
import uz.pdp.springadvancedtask1_2.service.SubmissionsTableService;

import java.util.List;

@RestController
public class SubmissionsTableController {
    @Autowired
    SubmissionsTableService submissionsTableService;

    @GetMapping("/api/submissionsTable")
    public ResponseEntity<List<SubmissionsTable>> getAllSubmissionsTable() {
        List<SubmissionsTable> allSubmissionsTable = submissionsTableService.getAllSubmissionsTable();
        return ResponseEntity.ok(allSubmissionsTable);
    }

    @GetMapping("/api/submissionsTable/{id}")
    public ResponseEntity<SubmissionsTable> getSubmissionsTableById(@PathVariable Integer id) {
        SubmissionsTable submissionsTableById = submissionsTableService.getSubmissionsTableById(id);
        return ResponseEntity.ok(submissionsTableById);
    }

    @PostMapping("/api/submissionsTable")
    public ResponseEntity<ApiResponse> addSubmissionsTable(@RequestBody SubmissionsTableDto submissionsTableDto) {
        ApiResponse apiResponse = submissionsTableService.addSubmissionsTable(submissionsTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @PutMapping("/api/submissionsTable/{id}")
    public ResponseEntity<ApiResponse> editSubmissionsTable(
            @PathVariable Integer id,
            @RequestBody SubmissionsTableDto submissionsTableDto) {
        ApiResponse apiResponse = submissionsTableService.editSubmissionsTable(id, submissionsTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @DeleteMapping("/api/submissionsTable/{id}")
    public ResponseEntity<ApiResponse> deleteSubmissionsTable(@PathVariable Integer id) {
        ApiResponse apiResponse = submissionsTableService.deleteSubmissionsTable(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }
}
