package com.example.employeeservice.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record EmployeeServiceErrorResponse(List<String> message,LocalDateTime timeStamp,String status) {	
};
