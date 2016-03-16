package org.prk.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.Transformers;
import org.prk.dao.ParentDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class FilterDaoImpl extends ParentDaoImpl implements FilterDao    {

	@Override
	public Map<String,Long> loadMasterTable() {
		
		String queryString="select filedName,filedId from MasterData ";
		List<List<Object>> permission= getCurrentSession().createQuery(queryString)
		      .setResultTransformer(Transformers.TO_LIST).list();
		//now you just expect two columns 
		HashMap<String,Long> map= new HashMap<String,Long>();
		for(List<Object> x: permission){ 
		     map.put((String)x.get(0),(Long)x.get(1));
		}
		
		//Use below if you want to use hibernate mapping for master tale
		
		/*String HQL_QUERY = "select new map(Masterdata.filedId as id ,Masterdata.filedName as name) from MasterData Masterdata";        
		List<Map<String,String>> usersList = getCurrentSession().createQuery(HQL_QUERY).list(); 
		HashMap<String,Long> map= new HashMap<String,Long>();
		
		for(Map<String,String> tempmap: usersList){
			for(Map.Entry<String,String> entry:tempmap.entrySet()){
				map.put(entry.getValue(), Long.parseLong(entry.getKey()));
			}
			
		}*/
		
		return map;
	}

}
