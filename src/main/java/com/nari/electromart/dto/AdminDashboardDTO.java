package com.nari.electromart.dto;

public class AdminDashboardDTO {

    private long totalUsers;
    private long totalProducts;
    private long totalCategories;

    public AdminDashboardDTO() {
    }

    public AdminDashboardDTO(
            long totalUsers,
            long totalProducts,
            long totalCategories) {

        this.totalUsers = totalUsers;
        this.totalProducts = totalProducts;
        this.totalCategories = totalCategories;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(long totalCategories) {
        this.totalCategories = totalCategories;
    }
}