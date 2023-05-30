package uz.pdp.springadvancedtask1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvancedtask1_2.entity.UsersTable;
import uz.pdp.springadvancedtask1_2.payload.ApiResponse;
import uz.pdp.springadvancedtask1_2.payload.UsersTableDto;
import uz.pdp.springadvancedtask1_2.service.UsersTableService;

import java.util.List;

@RestController
public class UsersTableController {

    @Autowired
    UsersTableService usersTableService;

    @GetMapping("/api/usersTable")
    public ResponseEntity<List<UsersTable>> getAllUsersTable() {
        List<UsersTable> allUsersTable = usersTableService.getAllUsersTable();
        return ResponseEntity.ok(allUsersTable);
    }

    @GetMapping("/api/usersTable/{id}")
    public ResponseEntity<UsersTable> getUsersTableId(@PathVariable Integer id) {
        return ResponseEntity.ok(usersTableService.getUsersTableId(id));
    }

    @PostMapping("/api/usersTable")
    public ResponseEntity<ApiResponse> addUsersTable(@RequestBody UsersTableDto usersTableDto) {
        ApiResponse apiResponse = usersTableService.addUsersTable(usersTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @PutMapping("/api/usersTable/{id}")
    public ResponseEntity<ApiResponse> editUsersTable(@PathVariable Integer id,
                                                      @RequestBody UsersTableDto usersTableDto) {
        ApiResponse apiResponse = usersTableService.editUsersTable(id, usersTableDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(apiResponse);
    }

    @DeleteMapping("/api/usersTable/{id}")
    public ResponseEntity<ApiResponse> deleteUsersTable(@PathVariable Integer id) {
        ApiResponse apiResponse = usersTableService.deleteUsersTable(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }
}
