package fr.mauritius.Backpacker.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookedperiods")

public class BookedPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private LocalDate bookedDate;

    @Column(nullable = true)
    private int typea;
    @Column(nullable = true)
    private int typeb;
    @Column(nullable = true)
    private int typec;
    @Column(nullable = true)
    private int typed;
    @Column(nullable = true)
    private int typee;
    @Column(nullable = true)
    private int typef;

    @Column(nullable = true)
    private String bka;
    @Column(nullable = true)
    private String bkb;
    @Column(nullable = true)
    private String bkc;
    @Column(nullable = true)
    private String bkd;
    @Column(nullable = true)
    private String bke;
    @Column(nullable = true)
    private String bkf;

    public BookedPeriod() {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public LocalDate getBookedDate() {
	return bookedDate;
    }

    public void setBookedDate(LocalDate bookedDate) {
	this.bookedDate = bookedDate;
    }

    public int getTypea() {
	return typea;
    }

    public void setTypea(int typea) {
	this.typea = typea;
    }

    public int getTypeb() {
	return typeb;
    }

    public void setTypeb(int typeb) {
	this.typeb = typeb;
    }

    public int getTypec() {
	return typec;
    }

    public void setTypec(int typec) {
	this.typec = typec;
    }

    public int getTyped() {
	return typed;
    }

    public void setTyped(int typed) {
	this.typed = typed;
    }

    public int getTypee() {
	return typee;
    }

    public void setTypee(int typee) {
	this.typee = typee;
    }

    public int getTypef() {
	return typef;
    }

    public void setTypef(int typef) {
	this.typef = typef;
    }

    public String getBka() {
	return bka;
    }

    public void setBka(String bka) {
	this.bka = bka;
    }

    public String getBkb() {
	return bkb;
    }

    public void setBkb(String bkb) {
	this.bkb = bkb;
    }

    public String getBkc() {
	return bkc;
    }

    public void setBkc(String bkc) {
	this.bkc = bkc;
    }

    public String getBkd() {
	return bkd;
    }

    public void setBkd(String bkd) {
	this.bkd = bkd;
    }

    public String getBke() {
	return bke;
    }

    public void setBke(String bke) {
	this.bke = bke;
    }

    public String getBkf() {
	return bkf;
    }

    public void setBkf(String bkf) {
	this.bkf = bkf;
    }

    @Override
    public String toString() {
	return "BookedPeriod [id=" + id + ", bookedDate=" + bookedDate + ", typea=" + typea + ", typeb=" + typeb
		+ ", typec=" + typec + ", typed=" + typed + ", typee=" + typee + ", typef=" + typef + ", bka=" + bka
		+ ", bkb=" + bkb + ", bkc=" + bkc + ", bkd=" + bkd + ", bke=" + bke + ", bkf=" + bkf + "]";
    }

}
