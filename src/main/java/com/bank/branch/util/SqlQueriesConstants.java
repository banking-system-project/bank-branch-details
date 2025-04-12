package com.bank.branch.util;

public class SqlQueriesConstants {
    public static final String SQL_GET_BRANCH_DETAILS="SELECT * FROM branch_details";
    public static final String SQL_GET_BRANCH_DETAILS_BY_IFSC_CODE = "SELECT * FROM branch_details WHERE ifsc_code = ?";
    public static final String SQL_ADD_NEW_BRANCH_DETAILS = "INSERT INTO branch_details " +
            "(bank_code, ifsc_code, branch_name, address, district, state, pin_code, bank_contact, branch_email, date_of_issue)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
}
