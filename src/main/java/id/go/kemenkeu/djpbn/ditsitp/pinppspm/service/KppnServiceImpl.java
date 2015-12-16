package id.go.kemenkeu.djpbn.ditsitp.pinppspm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.dao.KppnDao;
import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;

@Service
public class KppnServiceImpl implements KppnService{
	@Autowired
	private KppnDao kppnDao;

	@Override
	public void create(Kppn kppn) {
		// TODO Auto-generated method stub
		String kdkppn = kppn.getKdkppn().trim();
		String nmkppn = kppn.getNmkppn().trim();
		
		kppnDao.insert(kppn);
		
	}

	@Override
	public List<Kppn> read() {
		// TODO Auto-generated method stub
		return kppnDao.read();
	}

	@Override
	public Kppn getByKdkppn(String kdkppn) {
		// TODO Auto-generated method stub
		return kppnDao.getByKdkppn(kdkppn);
	}

}
