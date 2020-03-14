package com.mandala.surveyor.data.db.models;

import com.google.gson.annotations.SerializedName;

public class KlarifikasiTempatTinggal{

	@SerializedName("idKonsumen")
	private String idKonsumen;

	@SerializedName("idSurveyor")
	private String idSurveyor;

	@SerializedName("tglPenugasan")
	private String tglPenugasan;

	@SerializedName("idCabang")
	private String idCabang;

	@SerializedName("idAplikasi")
	private String idAplikasi;

	@SerializedName("tglAplikasi")
	private String tglAplikasi;

	@SerializedName("idKepemilikanTempatTinggal")
	private String idKepemilikanTempatTinggal;

	@SerializedName("idLamaTinggal")
	private String idLamaTinggal;

	@SerializedName("idDayaListrik")
	private String idDayaListrik;

	@SerializedName("idNilaiKepemilikanAssetLainnya")
	private String idNilaiKepemilikanAssetLainnya;

	@SerializedName("namaKonsumen")
	private String namaKonsumen;

	@SerializedName("idKondisiBangunanRumah")
	private String idKondisiBangunanRumah;

	public void setIdKonsumen(String idKonsumen){
		this.idKonsumen = idKonsumen;
	}

	public String getIdKonsumen(){
		return idKonsumen;
	}

	public void setIdSurveyor(String idSurveyor){
		this.idSurveyor = idSurveyor;
	}

	public String getIdSurveyor(){
		return idSurveyor;
	}

	public void setTglPenugasan(String tglPenugasan){
		this.tglPenugasan = tglPenugasan;
	}

	public String getTglPenugasan(){
		return tglPenugasan;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setIdAplikasi(String idAplikasi){
		this.idAplikasi = idAplikasi;
	}

	public String getIdAplikasi(){
		return idAplikasi;
	}

	public void setTglAplikasi(String tglAplikasi){
		this.tglAplikasi = tglAplikasi;
	}

	public String getTglAplikasi(){
		return tglAplikasi;
	}

	public void setIdKepemilikanTempatTinggal(String idKepemilikanTempatTinggal){
		this.idKepemilikanTempatTinggal = idKepemilikanTempatTinggal;
	}

	public String getIdKepemilikanTempatTinggal(){
		return idKepemilikanTempatTinggal;
	}

	public void setIdLamaTinggal(String idLamaTinggal){
		this.idLamaTinggal = idLamaTinggal;
	}

	public String getIdLamaTinggal(){
		return idLamaTinggal;
	}

	public void setIdDayaListrik(String idDayaListrik){
		this.idDayaListrik = idDayaListrik;
	}

	public String getIdDayaListrik(){
		return idDayaListrik;
	}

	public void setIdNilaiKepemilikanAssetLainnya(String idNilaiKepemilikanAssetLainnya){
		this.idNilaiKepemilikanAssetLainnya = idNilaiKepemilikanAssetLainnya;
	}

	public String getIdNilaiKepemilikanAssetLainnya(){
		return idNilaiKepemilikanAssetLainnya;
	}

	public void setNamaKonsumen(String namaKonsumen){
		this.namaKonsumen = namaKonsumen;
	}

	public String getNamaKonsumen(){
		return namaKonsumen;
	}

	public void setIdKondisiBangunanRumah(String idKondisiBangunanRumah){
		this.idKondisiBangunanRumah = idKondisiBangunanRumah;
	}

	public String getIdKondisiBangunanRumah(){
		return idKondisiBangunanRumah;
	}

	@Override
 	public String toString(){
		return 
			"KlarifikasiTempatTinggal{" + 
			"idKonsumen = '" + idKonsumen + '\'' + 
			",idSurveyor = '" + idSurveyor + '\'' + 
			",tglPenugasan = '" + tglPenugasan + '\'' + 
			",idCabang = '" + idCabang + '\'' + 
			",idAplikasi = '" + idAplikasi + '\'' + 
			",tglAplikasi = '" + tglAplikasi + '\'' + 
			",idKepemilikanTempatTinggal = '" + idKepemilikanTempatTinggal + '\'' + 
			",idLamaTinggal = '" + idLamaTinggal + '\'' + 
			",idDayaListrik = '" + idDayaListrik + '\'' + 
			",idNilaiKepemilikanAssetLainnya = '" + idNilaiKepemilikanAssetLainnya + '\'' + 
			",namaKonsumen = '" + namaKonsumen + '\'' + 
			",idKondisiBangunanRumah = '" + idKondisiBangunanRumah + '\'' + 
			"}";
		}
}