package com.jsp.prc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.prc.entity.Employee;
import com.jsp.prc.entity.Leave;
import com.jsp.prc.repository.EmployeeReposiroty;
import com.jsp.prc.repository.LeaveRepo;
import com.jsp.prc.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	@Autowired
	private EmployeeReposiroty employeeReposiroty;

	@Override
	public Leave applyLeave(Leave leave) {
		Leave savedleave = leaveRepo.save(leave);
		
		sendMailToManager(savedleave);
		return savedleave;
	}

	private String sendMailToManager(Leave leave) {
        // Manager email address (you can make it dynamic based on leave information)
        String managerEmail = "mdmustafa262806@gmail.com";
        
        // Subject and body of the email
        String subject = "Leave Application: " + leave.getLeaveType();
        String body = "Dear Manager,\n\n"
                    + "A new leave application has been submitted.\n"
                    + "Details:\n"
                    + "Leave Type: " + leave.getLeaveType() + "\n"
                    + "Start Date: " + leave.getStartDate() + "\n"
                    + "End Date: " + leave.getEndDate() + "\n"
                    + "Reason: " + leave.getReason() + "\n\n"
                    + "Please review the application.\n\n"
                    + "Regards,\nLeave Management System";

        // Create the email message
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("mdrmustafa1234@gmail.com");  // Sender email
        mail.setTo(managerEmail);  // Recipient email
        mail.setSubject(subject);  // Set subject
        mail.setText(body);  // Set body content

        // Send the email
        javaMailSender.send(mail);
        return "Leave email send to manager";
	}

	@Override
	public Leave approveLeave(String lid, String approvalStatus) {
		Leave leave = leaveRepo.findById(lid).orElseThrow(() -> new RuntimeException("Leave not found"));
		leave.setApprovalStatus(approvalStatus);
		leave.setStatus("Processed");
		leaveRepo.save(leave);
		
		sendApprovalMailToEmployee(leave);
		
		return leave;
	}

	private String sendApprovalMailToEmployee(Leave leave) {
		String employeeEmail = "mdmustafa262806@gmail.com"; // Retrieve employee email from database or other logic
        String subject = "Leave Application " + leave.getApprovalStatus();
        String body = "Dear Employee,\n\n"
                + "Your leave application has been " + leave.getApprovalStatus() + ".\n\n"
                + "Regards,\nLeave Management System";

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("mdrmustafa1234@gmail.com");
        mail.setTo(employeeEmail);
        mail.setText(body);
        javaMailSender.send(mail);
		return "Status mail send to email";
	}

	

}
