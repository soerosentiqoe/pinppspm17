package id.go.kemenkeu.djpbn.ditsitp.pinppspm.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.service.KppnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcessorKppn {
	@Autowired	
	private KppnService Kppnservice;
	public File process(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp = "";
		while (( temp = reader.readLine()) != null) {
			String[] z =temp.split(",");
			Kppn kppn = new Kppn();
			kppn.setKdkppn(z[0]);
			kppn.setNmkppn(z[1]);
			System.out.println(kppn.getKdkppn());
			System.out.println(kppn.getNmkppn());
			Kppnservice.create(kppn);
			
		}
		
		return file;
	
	}
	

}
