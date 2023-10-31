package com.oops.interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        UUID recordId = UUID.randomUUID();
        dbManager.insertRecord(recordId, "John Doe", "123 Main St", "555-123-4567", "12345", "Some comments");
        System.out.println("Record inserted successfully.");

        // Retrieve all records
        Map<UUID, Map<String, String>> allRecords = dbManager.getListOfAllRecords();
        System.out.println("All Records: ");
        for (Map.Entry<UUID, Map<String, String>> entry : allRecords.entrySet()) {
            System.out.println("Record key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Update a record
        Map<String, String> updateData = new HashMap<>();
        updateData.put("name", "Updated Name");
        dbManager.updateRecord(recordId, updateData);
        System.out.println("Record updated successfully.");

        // Retrieve the updated record
        Map<String, String> updatedRecord = dbManager.getListOfAllRecords().get(recordId);
        System.out.println("Updated Record: " + updatedRecord);
        
        //Delete a record
        dbManager.deleteRecord(recordId);
        System.out.println("record deleted successfully. ");
        
        //verify that the record was deleted 
        allRecords = dbManager.getListOfAllRecords();
        System.out.println("All Records after deletion: ");
        for (Map.Entry<UUID, Map<String, String>> entry : allRecords.entrySet()) {
            System.out.println("Record key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
