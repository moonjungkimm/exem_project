package com.exem.util;
import com.exem.service.AlertServiceImpl;

public class ClientRunner {
    public static void main(String[] args) {
    	AlertServiceImpl alertService = new AlertServiceImpl();
        alertService.client();
    }
}
