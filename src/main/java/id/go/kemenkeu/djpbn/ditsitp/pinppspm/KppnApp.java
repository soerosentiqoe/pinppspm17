package id.go.kemenkeu.djpbn.ditsitp.pinppspm;

import org.springframework.beans.factory.annotation.Autowired;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.dao.KppnDao;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.dao.KppnDaoImpl;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.service.KppnService;

public class KppnApp {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		//KppnService Kppnservice = new KppnService;
		KppnDao k = new KppnDaoImpl();
		Kppn kppn= new Kppn();
		kppn.setKdkppn("018");
		kppn.setNmkppn("JAKARTA II");
		k.insert(kppn);
		//Kppnservice.create(kppn);
		
		
		
		

	}

}
