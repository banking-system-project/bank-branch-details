package com.bank.account.info.util;

public class SqlQueriesConstants {
    public static final String SQL_GET_BRANCH_DETAILS="SELECT * FROM BRANCH_DETAILS";
    public static final String SQL_GET_BRANCH_DETAILS_BY_IFSC_CODE = "SELECT * FROM BRANCH_DETAILS WHERE IFSC_CODE = ?";
    public static final String SQL_ADD_NEW_BRANCH_DETAILS = "INSERT INTO BRANCH_DETAILS " +
            "(BANK_CODE, IFSC_CODE, BRANCH_NAME, ADDRESS, DISTRICT, STATE, PIN_CODE, BANK_CONTACT, BRANCH_EMAIL, DATE_OF_ISSUE)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
}
