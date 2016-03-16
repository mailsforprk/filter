package org.prk.dao;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.prk.domain.FilterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FilterServcieImpl implements FilterService{
	public static Map<String,Long> masterTableMap = new HashMap<String, Long>();
	@Autowired
	private FilterDao filterDao;
	@Override
	@Transactional
	public Map<String, Long> getMasterTableMap() {
		// TODO Auto-generated method stub
	if(masterTableMap.entrySet().size() != 0){
		return masterTableMap;
	}else{
		masterTableMap  = filterDao.loadMasterTable();
		return masterTableMap;
	}		
	}

}
