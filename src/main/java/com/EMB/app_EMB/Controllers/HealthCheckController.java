package com.EMB.app_EMB.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/health")
  public ResponseEntity<String> healthCheck() {
    try {
      jdbcTemplate.execute("SELECT 1 FROM DUAL");
      return ResponseEntity.ok("OK");
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
  }
}
