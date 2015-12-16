package id.go.kemenkeu.djpbn.ditsitp.pinppspm.controller;

import java.util.List;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.service.KppnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/kppn")
public class KppnController {
	@Autowired
	private KppnService kppnService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Kppn> get(){
		return kppnService.read();
	}

}
