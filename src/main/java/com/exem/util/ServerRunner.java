package com.exem.util;
import com.exem.service.AlertServiceImpl;

public class ServerRunner {
    public static void main(String[] args) {
    	AlertServiceImpl alertService = new AlertServiceImpl();
        alertService.server();
    }
}
