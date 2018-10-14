package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Schritt1.SubstitutionCipher;
import Schritt3.KeywordCipher;

public class CipherController implements ActionListener {
	private CipherModel Model;
	private CipherView View;
	private SubstitutionCipher s1;
	private ShiftCipher sh1;
	private boolean alphT;
	private boolean shT;
	private boolean kCT;
	private KeywordCipher kC;
	public CipherController() {
		this.alphT = false;
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.View.klickSA(e)) {
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getAlphabet());
			this.alphT = true;
		}
		if (this.View.klickShA(e)) {
			this.View.refresh();
			this.View.setWert();
			this.sh1 = new ShiftCipher(this.Model.getVer());
			this.shT = true;
		}
		if (this.View.klickUKW(e)) {
			this.View.refresh();
			this.View.setKW();
			this.kC = new KeywordCipher(this.Model.getKeyWord());
			this.kCT = true;
		}
		if(this.View.klickDe(e)) {
			this.View.setDe();
			if (this.alphT) this.Model.setDtext(this.s1.decrypt(this.Model.getDtext()));
			if (this.shT) this.Model.setDtext(this.sh1.decrypt(this.Model.getDtext()));
			if (this.kCT) this.Model.setDtext(this.kC.decrypt(this.Model.getDtext()));
			this.View.refresh();
		}
		if(this.View.klickEn(e)) {
			this.View.setEn();
			if (this.alphT) this.Model.setEtext(this.s1.encrypt(this.Model.getEtext()));
			if (this.shT) this.Model.setEtext(this.sh1.encrypt(this.Model.getEtext()));
			if (this.kCT) this.Model.setEtext(this.kC.encrypt(this.Model.getEtext()));
			this.View.refresh();
		}
	}
	
}
