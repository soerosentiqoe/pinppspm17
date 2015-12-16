package id.go.kemenkeu.djpbn.ditsitp.pinppspm.service;

import java.util.List;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;

public interface KppnService {
	public void create(Kppn kppn);
	public List<Kppn> read();
	public Kppn getByKdkppn(String kdkppn);

}
