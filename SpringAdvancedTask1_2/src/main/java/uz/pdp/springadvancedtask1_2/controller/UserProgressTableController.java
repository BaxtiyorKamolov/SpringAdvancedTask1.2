package uz.pdp.springadvancedtask1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvancedtask1_2.entity.UserProgressTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.UserProgressTableDto;
import uz.pdp.springadvancedtask1_2.service.UserProgressTableService;

import java.util.List;

@RestController
public class UserProgressTableController {

    @Autowired
    UserProgressTableService userProgressTableService;

    @GetMapping("/api/userProgress")
    public ResponseEntity<List<UserProgressTable>> getUserProgressTable() {
        List<UserProgressTable> userProgressTable = userProgressTableService.getUserProgressTable();
        return ResponseEntity.ok(userProgressTable);
    }

    @GetMapping("/api/userProgress/{id}")
    public ResponseEntity<UserProgressTable> getUserProgressTableById(@PathVariable Integer id) {
        UserProgressTable userProgressTableById = userProgressTableService.getUserProgressTableById(id);
        return ResponseEntity.ok(userProgressTableById);
    }

    @PostMapping("/api/userProgress")
    public ResponseEntity<ApiResponse> addUserProgressTable(
            @RequestBody UserProgressTableDto userProgressTableDto) {
        ApiResponse apiResponse = userProgressTableService.addUserProgressTable(userProgressTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @PutMapping("/api/userProgress/{id}")
    public ResponseEntity<ApiResponse> editUserProgressTable(
            @PathVariable Integer id,
            @RequestBody UserProgressTableDto userProgressTableDto) {
        ApiResponse apiResponse = userProgressTableService.editUserProgressTable(id, userProgressTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @DeleteMapping("/api/userProgress/{id}")
    public ResponseEntity<ApiResponse> deleteUserProgressTable(@PathVariable Integer id) {
        ApiResponse apiResponse = userProgressTableService.deleteUserProgressTable(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }
}
