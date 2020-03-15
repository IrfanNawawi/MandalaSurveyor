package com.mandala.surveyor.data.db.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Penugasan implements Parcelable {

	@SerializedName("idKonsumen")
	private String idKonsumen;

	@SerializedName("rt")
	private String rt;

	@SerializedName("rw")
	private String rw;

	@SerializedName("idSubProduk")
	private String idSubProduk;

	@SerializedName("idProvinsi")
	private String idProvinsi;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("idJenisProduk")
	private String idJenisProduk;

	@SerializedName("idTipeBarang")
	private String idTipeBarang;

	@SerializedName("statusSurvey")
	private Object statusSurvey;

	@SerializedName("statusTaksasi")
	private Object statusTaksasi;

	@SerializedName("tglPenugasan")
	private String tglPenugasan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("idAplikasi")
	private String idAplikasi;

	@SerializedName("model")
	private String model;

	@SerializedName("id")
	private int id;

	@SerializedName("tagLokasi")
	private String tagLokasi;

	@SerializedName("idKota")
	private String idKota;

	@SerializedName("email")
	private String email;

	@SerializedName("idKategoriProduk")
	private String idKategoriProduk;

	@SerializedName("batalSurvey")
	private Object batalSurvey;

	@SerializedName("idMerkBarang")
	private String idMerkBarang;

	@SerializedName("tglAplikasi")
	private String tglAplikasi;

	@SerializedName("idKecamatan")
	private String idKecamatan;

	@SerializedName("noHp2")
	private String noHp2;

	@SerializedName("noHp1")
	private String noHp1;

	@SerializedName("namaKonsumen")
	private String namaKonsumen;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("idPortofolio")
	private String idPortofolio;

	@SerializedName("idSurveyor")
	private String idSurveyor;

	@SerializedName("idKelurahan")
	private String idKelurahan;

	@SerializedName("idCabang")
	private String idCabang;

	@SerializedName("kodePos")
	private String kodePos;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("idJenisAlamat")
	private String idJenisAlamat;

	protected Penugasan(Parcel in) {
		idKonsumen = in.readString();
		rt = in.readString();
		rw = in.readString();
		idSubProduk = in.readString();
		idProvinsi = in.readString();
		createdAt = in.readString();
		idJenisProduk = in.readString();
		idTipeBarang = in.readString();
		tglPenugasan = in.readString();
		updatedAt = in.readString();
		idAplikasi = in.readString();
		model = in.readString();
		id = in.readInt();
		tagLokasi = in.readString();
		idKota = in.readString();
		email = in.readString();
		idKategoriProduk = in.readString();
		idMerkBarang = in.readString();
		tglAplikasi = in.readString();
		idKecamatan = in.readString();
		noHp2 = in.readString();
		noHp1 = in.readString();
		namaKonsumen = in.readString();
		alamat = in.readString();
		idPortofolio = in.readString();
		idSurveyor = in.readString();
		idKelurahan = in.readString();
		idCabang = in.readString();
		kodePos = in.readString();
		noTelp = in.readString();
		idJenisAlamat = in.readString();
	}

	public static final Creator<Penugasan> CREATOR = new Creator<Penugasan>() {
		@Override
		public Penugasan createFromParcel(Parcel in) {
			return new Penugasan(in);
		}

		@Override
		public Penugasan[] newArray(int size) {
			return new Penugasan[size];
		}
	};

	public void setIdKonsumen(String idKonsumen){
		this.idKonsumen = idKonsumen;
	}

	public String getIdKonsumen(){
		return idKonsumen;
	}

	public void setRt(String rt){
		this.rt = rt;
	}

	public String getRt(){
		return rt;
	}

	public void setRw(String rw){
		this.rw = rw;
	}

	public String getRw(){
		return rw;
	}

	public void setIdSubProduk(String idSubProduk){
		this.idSubProduk = idSubProduk;
	}

	public String getIdSubProduk(){
		return idSubProduk;
	}

	public void setIdProvinsi(String idProvinsi){
		this.idProvinsi = idProvinsi;
	}

	public String getIdProvinsi(){
		return idProvinsi;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdJenisProduk(String idJenisProduk){
		this.idJenisProduk = idJenisProduk;
	}

	public String getIdJenisProduk(){
		return idJenisProduk;
	}

	public void setIdTipeBarang(String idTipeBarang){
		this.idTipeBarang = idTipeBarang;
	}

	public String getIdTipeBarang(){
		return idTipeBarang;
	}

	public void setStatusSurvey(Object statusSurvey){
		this.statusSurvey = statusSurvey;
	}

	public Object getStatusSurvey(){
		return statusSurvey;
	}

	public void setStatusTaksasi(Object statusTaksasi){
		this.statusTaksasi = statusTaksasi;
	}

	public Object getStatusTaksasi(){
		return statusTaksasi;
	}

	public void setTglPenugasan(String tglPenugasan){
		this.tglPenugasan = tglPenugasan;
	}

	public String getTglPenugasan(){
		return tglPenugasan;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdAplikasi(String idAplikasi){
		this.idAplikasi = idAplikasi;
	}

	public String getIdAplikasi(){
		return idAplikasi;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTagLokasi(String tagLokasi){
		this.tagLokasi = tagLokasi;
	}

	public String getTagLokasi(){
		return tagLokasi;
	}

	public void setIdKota(String idKota){
		this.idKota = idKota;
	}

	public String getIdKota(){
		return idKota;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setIdKategoriProduk(String idKategoriProduk){
		this.idKategoriProduk = idKategoriProduk;
	}

	public String getIdKategoriProduk(){
		return idKategoriProduk;
	}

	public void setBatalSurvey(Object batalSurvey){
		this.batalSurvey = batalSurvey;
	}

	public Object getBatalSurvey(){
		return batalSurvey;
	}

	public void setIdMerkBarang(String idMerkBarang){
		this.idMerkBarang = idMerkBarang;
	}

	public String getIdMerkBarang(){
		return idMerkBarang;
	}

	public void setTglAplikasi(String tglAplikasi){
		this.tglAplikasi = tglAplikasi;
	}

	public String getTglAplikasi(){
		return tglAplikasi;
	}

	public void setIdKecamatan(String idKecamatan){
		this.idKecamatan = idKecamatan;
	}

	public String getIdKecamatan(){
		return idKecamatan;
	}

	public void setNoHp2(String noHp2){
		this.noHp2 = noHp2;
	}

	public String getNoHp2(){
		return noHp2;
	}

	public void setNoHp1(String noHp1){
		this.noHp1 = noHp1;
	}

	public String getNoHp1(){
		return noHp1;
	}

	public void setNamaKonsumen(String namaKonsumen){
		this.namaKonsumen = namaKonsumen;
	}

	public String getNamaKonsumen(){
		return namaKonsumen;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setIdPortofolio(String idPortofolio){
		this.idPortofolio = idPortofolio;
	}

	public String getIdPortofolio(){
		return idPortofolio;
	}

	public void setIdSurveyor(String idSurveyor){
		this.idSurveyor = idSurveyor;
	}

	public String getIdSurveyor(){
		return idSurveyor;
	}

	public void setIdKelurahan(String idKelurahan){
		this.idKelurahan = idKelurahan;
	}

	public String getIdKelurahan(){
		return idKelurahan;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setKodePos(String kodePos){
		this.kodePos = kodePos;
	}

	public String getKodePos(){
		return kodePos;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setIdJenisAlamat(String idJenisAlamat){
		this.idJenisAlamat = idJenisAlamat;
	}

	public String getIdJenisAlamat(){
		return idJenisAlamat;
	}

	@Override
 	public String toString(){
		return 
			"Penugasan{" + 
			"idKonsumen = '" + idKonsumen + '\'' + 
			",rt = '" + rt + '\'' + 
			",rw = '" + rw + '\'' + 
			",idSubProduk = '" + idSubProduk + '\'' + 
			",idProvinsi = '" + idProvinsi + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",idJenisProduk = '" + idJenisProduk + '\'' + 
			",idTipeBarang = '" + idTipeBarang + '\'' + 
			",statusSurvey = '" + statusSurvey + '\'' + 
			",statusTaksasi = '" + statusTaksasi + '\'' + 
			",tglPenugasan = '" + tglPenugasan + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",idAplikasi = '" + idAplikasi + '\'' + 
			",model = '" + model + '\'' + 
			",id = '" + id + '\'' + 
			",tagLokasi = '" + tagLokasi + '\'' + 
			",idKota = '" + idKota + '\'' + 
			",email = '" + email + '\'' + 
			",idKategoriProduk = '" + idKategoriProduk + '\'' + 
			",batalSurvey = '" + batalSurvey + '\'' + 
			",idMerkBarang = '" + idMerkBarang + '\'' + 
			",tglAplikasi = '" + tglAplikasi + '\'' + 
			",idKecamatan = '" + idKecamatan + '\'' + 
			",noHp2 = '" + noHp2 + '\'' + 
			",noHp1 = '" + noHp1 + '\'' + 
			",namaKonsumen = '" + namaKonsumen + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",idPortofolio = '" + idPortofolio + '\'' + 
			",idSurveyor = '" + idSurveyor + '\'' + 
			",idKelurahan = '" + idKelurahan + '\'' + 
			",idCabang = '" + idCabang + '\'' + 
			",kodePos = '" + kodePos + '\'' + 
			",no_telp = '" + noTelp + '\'' + 
			",idJenisAlamat = '" + idJenisAlamat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(idKonsumen);
		dest.writeString(rt);
		dest.writeString(rw);
		dest.writeString(idSubProduk);
		dest.writeString(idProvinsi);
		dest.writeString(createdAt);
		dest.writeString(idJenisProduk);
		dest.writeString(idTipeBarang);
		dest.writeString(tglPenugasan);
		dest.writeString(updatedAt);
		dest.writeString(idAplikasi);
		dest.writeString(model);
		dest.writeInt(id);
		dest.writeString(tagLokasi);
		dest.writeString(idKota);
		dest.writeString(email);
		dest.writeString(idKategoriProduk);
		dest.writeString(idMerkBarang);
		dest.writeString(tglAplikasi);
		dest.writeString(idKecamatan);
		dest.writeString(noHp2);
		dest.writeString(noHp1);
		dest.writeString(namaKonsumen);
		dest.writeString(alamat);
		dest.writeString(idPortofolio);
		dest.writeString(idSurveyor);
		dest.writeString(idKelurahan);
		dest.writeString(idCabang);
		dest.writeString(kodePos);
		dest.writeString(noTelp);
		dest.writeString(idJenisAlamat);
	}
}