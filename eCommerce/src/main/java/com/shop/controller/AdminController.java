package com.shop.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class AdminController {

	@Autowired
	private AdminService aservice;

	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdminHandler(@Valid @RequestBody Admin admin) throws AdminException {

		Admin savedAdmin = aservice.registerAdmin(admin);

		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin, @RequestParam String key)
			throws AdminException, LoginException {

		Admin savedAdmin = aservice.updateAdmin(admin, key);

		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteAdminHandler(@RequestParam Integer adminId, @RequestParam String key)
			throws AdminException, LoginException {

		String message = aservice.deleteAdmin(adminId, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAdmin")
	public ResponseEntity<Admin> getAdminByIdHandler(@RequestParam Integer adminId, @RequestParam String key)
			throws AdminException, LoginException {

		Admin savedAdmin = aservice.getAdminById(adminId, key);

		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.ACCEPTED);
	}
}