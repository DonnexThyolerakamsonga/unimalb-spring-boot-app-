package com.example.unimalb.unimaadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {
    private  final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<UnimalbAdmin> getUnimalbAdmin(){
       return adminService.getUnimalbAdmin();
    }
    @DeleteMapping(path = "{adminId}")
    public void  deleteAdmin(@PathVariable("adminId") Long adminId){
        adminService.deleteAdmin(adminId);
    }
    @PostMapping
    public void addNewAdmin(@RequestBody UnimalbAdmin unimalbAdmin){
        adminService.addNewAdmin(unimalbAdmin);
    }
    @PutMapping(path = "{adminId}")
    public void updateAdmin(
            @PathVariable("adminId") Long adminId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String fullName

    ){
        adminService.UpdateAdmin(adminId,email, fullName);
    }
}
