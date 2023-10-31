package com.oops.interfaces;

import java.util.Map;
import java.util.UUID;

public interface DatabaseInterface {
	boolean insertRecord(UUID id, String name,String address,String phone,String zip,String comments);
	
	public boolean deleteRecord(UUID id);
	
	 Map<UUID, Map<String, String>> getListOfAllRecords();
	
	boolean updateRecord(UUID id,Map<String, String> records);
	
	
}
