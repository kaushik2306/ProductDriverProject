package com.company.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OperationUtils {

	private static Map<String, Object> operationsInstancePerKeyMap = new ConcurrentHashMap<>();

	private OperationUtils(){}

	@SuppressWarnings("unchecked")
	public static synchronized <T> T getInstance(String key, Class<T> type) throws Exception {
		//String currentThreadName = Thread.currentThread().getName();
		//String key = currentThreadName+"-"+type.getName();
		if(operationsInstancePerKeyMap.containsKey(key)){
			return (T) operationsInstancePerKeyMap.get(key);
		}else{
			try {
				T object = type.newInstance();
				operationsInstancePerKeyMap.put(key, object);
				return object;
			} catch (Exception e) {
				throw new Exception("Could not create instance of operations "+type.getName(),e);
			}
		}
	}
}
