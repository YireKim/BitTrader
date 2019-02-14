package iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import domain.CustomersDTO;
import service.CustomersServiceImpl;

public class PhoneBook {
	public static void main(String[] args) {
		
		HashMap<String, Object> map = (HashMap<String, Object>) 
				CustomersServiceImpl.getInstance().retrievePhoneNum(null);
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry ent = (Entry) it.next();
			String id = (String) ent.getKey();
			CustomersDTO cust = (CustomersDTO) ent.getValue();
			
			System.out.println("Phone: "+cust.getPhone()+"		Name: "+cust.getContactName());
			
		}
	}
}
