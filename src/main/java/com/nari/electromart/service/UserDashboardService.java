package com.nari.electromart.service;

import com.nari.electromart.dto.UserDashboardDTO;

public interface UserDashboardService {

    UserDashboardDTO getDashboard(Long userId);
}