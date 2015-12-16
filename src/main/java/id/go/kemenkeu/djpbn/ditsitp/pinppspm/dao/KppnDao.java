package id.go.kemenkeu.djpbn.ditsitp.pinppspm.dao;

import java.util.List;

import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.Kppn;

public interface KppnDao {
	public void insert(Kppn kppn) ;
	public List<Kppn> read();
	public Kppn getByKdkppn(String kdkppn);

}
