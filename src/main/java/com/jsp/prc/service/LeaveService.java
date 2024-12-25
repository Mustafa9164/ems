package com.jsp.prc.service;

import com.jsp.prc.entity.Leave;

public interface LeaveService {

	Leave applyLeave(Leave leave);

	Leave approveLeave(String lid, String status);

}
