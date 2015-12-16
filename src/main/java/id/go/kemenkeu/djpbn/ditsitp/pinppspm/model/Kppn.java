package id.go.kemenkeu.djpbn.ditsitp.pinppspm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_KPPN")
public class Kppn {
	@Id
	@Column(name="ID_KPPN")
	private String id_kppn;
	@Column(name="KDKPPN")
	private String kdkppn;
	@Column(name="NMKPPN")
	private String nmkppn;
	public String getId_kppn() {
		return id_kppn;
	}
	public void setId_kppn(String id_kppn) {
		this.id_kppn = id_kppn;
	}
	public String getKdkppn() {
		return kdkppn;
	}
	public void setKdkppn(String kdkppn) {
		this.kdkppn = kdkppn;
	}
	public String getNmkppn() {
		return nmkppn;
	}
	public void setNmkppn(String nmkppn) {
		this.nmkppn = nmkppn;
	}
	

}
