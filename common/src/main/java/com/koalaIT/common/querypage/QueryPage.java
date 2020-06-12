package com.koalaIT.common.querypage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("rawtypes")
public class QueryPage extends PageList implements QueryGetParameters {
	private static final Logger logger = LoggerFactory.getLogger(QueryPage.class);
	private static final long serialVersionUID = -4734192696485746607L;
	Object obj;
	String queryPageClose;
	List<?> items = new ArrayList<Object>();

	public QueryPage() {
		this.setObj(new HashMap<String,Object>());
		this.setParameterMap(new HashMap<String, Object>());
	}

	public QueryPage(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getParameters() {
		Assert.notNull(this.obj);
		if(this.obj instanceof Map){
			return (Map<String, Object>) this.obj;
		}
		Class<? extends Object> clazz = this.obj.getClass();
		HashMap<String,Object> resMap = new HashMap<String,Object>();
		try {
			HashMap<String,Object> map = new HashMap<String,Object>();
			getClass(clazz, map, this.obj);
			resMap = convertHashMap(map);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("{}", e);
			}
		}
		return resMap;
	}

	private static void getClass(Class<? extends Object> clazz, HashMap<String,Object> map, Object obj)
			throws Exception {
		if (clazz.getSimpleName().equals("Object")) {
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		if ((fields != null) && (fields.length > 0)) {
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				String name = fields[i].getName();
				if (!"serialVersionUID".equals(name)) {
					Object value = fields[i].get(obj);
					map.put(name, value);
				}
			}
		}
		Class<?> superClzz = clazz.getSuperclass();
		getClass(superClzz, map, obj);
	}

	private static HashMap<String, Object> convertHashMap(HashMap<String,Object> map)
			throws Exception {
		HashMap<String, Object> newMap = new HashMap<String, Object>();
		
		@SuppressWarnings("rawtypes")
		Set keys = map.keySet();
		
		@SuppressWarnings("rawtypes")
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			convertToString(map.get(key), newMap, key);
		}

		return newMap;
	}

	private static void convertToString(Object value, HashMap<String,Object> newMap, String key) {
		if (value != null) {
			Class<? extends Object> clazz = value.getClass();
			if (isBaseType(clazz)) {
				newMap.put(key, value.toString());
			} else if (clazz == String.class) {
				newMap.put(key, value.toString());
			} else if (clazz == Date.class) {
				Date date = (Date) value;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(date));
			} else if (clazz == Timestamp.class) {
				Timestamp timestamp = (Timestamp) value;
				long times = timestamp.getTime();
				Date date = new Date(times);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(date));
			} else if (clazz == java.sql.Date.class) {
				java.sql.Date sqlDate = (java.sql.Date) value;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(sqlDate));
			} else {
				newMap.put(key, value);
			}
		}
	}

	private static boolean isBaseType(Class clazz) {
		boolean isBaseType = false;

		if (clazz == Integer.class) {
			isBaseType = true;
		}
		if (clazz == Long.class) {
			isBaseType = true;
		}
		if (clazz == Double.class) {
			isBaseType = true;
		}
		if (clazz == Byte.class) {
			isBaseType = true;
		}
		if (clazz == Float.class) {
			isBaseType = true;
		}
		if (clazz == Short.class) {
			isBaseType = true;
		}
		if (clazz == Boolean.class) {
			isBaseType = true;
		}
		return isBaseType;
	}

	public List<?> getItems() {
		return this.items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public Object getObj() {
		return this.obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
