/**
 * Copyright 2005-2011, Stadt Bielefeld
 *
 * This file is part of AUIK (Anlagen- und Indirekteinleiter-Kataster).
 *
 * AUIK is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 2 of the License, or (at your
 * option) any later version.
 *
 * AUIK is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with AUIK. If not, see <http://www.gnu.org/licenses/>.
 *
 * AUIK has been developed by Stadt Bielefeld and Intevation GmbH.
 */

// Generated 17.07.2012 18:33:28 by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.indeinl;


import de.bielefeld.umweltamt.aui.mappings.generated.basis.BasisObjekt;
import java.util.Date;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link Anh56Fachdaten}.
 */
public abstract class AbstractAnh56Fachdaten  implements java.io.Serializable {

     private int objektid;
     private BasisObjekt basisObjekt;
     private String druckverfahren;
     private String verbrauch;
     private String sachbearbeiterrav;
     private String sachbearbeiterheepen;
     private String entsorgung;
     private Boolean abwasseranfall;
     private Boolean genpflicht;
     private Boolean aba;
     private Date gen58;
     private Date gen59;
     private String bemerkungen;
     private Boolean abfallrechtlentsorg;
     private Boolean spuelwasser;
     private Boolean leimabwasser;
     private Date erfasstam;
     private boolean enabled;
     private boolean deleted;

    public AbstractAnh56Fachdaten() {
    }

    public AbstractAnh56Fachdaten(
    	BasisObjekt basisObjekt, boolean enabled, boolean deleted) {
        this.basisObjekt = basisObjekt;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    public AbstractAnh56Fachdaten(
    	BasisObjekt basisObjekt, String druckverfahren, String verbrauch, String sachbearbeiterrav, String sachbearbeiterheepen, String entsorgung, Boolean abwasseranfall, Boolean genpflicht, Boolean aba, Date gen58, Date gen59, String bemerkungen, Boolean abfallrechtlentsorg, Boolean spuelwasser, Boolean leimabwasser, Date erfasstam, boolean enabled, boolean deleted) {
        this.basisObjekt = basisObjekt;
        this.druckverfahren = druckverfahren;
        this.verbrauch = verbrauch;
        this.sachbearbeiterrav = sachbearbeiterrav;
        this.sachbearbeiterheepen = sachbearbeiterheepen;
        this.entsorgung = entsorgung;
        this.abwasseranfall = abwasseranfall;
        this.genpflicht = genpflicht;
        this.aba = aba;
        this.gen58 = gen58;
        this.gen59 = gen59;
        this.bemerkungen = bemerkungen;
        this.abfallrechtlentsorg = abfallrechtlentsorg;
        this.spuelwasser = spuelwasser;
        this.leimabwasser = leimabwasser;
        this.erfasstam = erfasstam;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    public int getObjektid() {
        return this.objektid;
    }
    public void setObjektid(int objektid) {
        this.objektid = objektid;
    }

    public BasisObjekt getBasisObjekt() {
        return this.basisObjekt;
    }
    public void setBasisObjekt(BasisObjekt basisObjekt) {
        this.basisObjekt = basisObjekt;
    }

    public String getDruckverfahren() {
        return this.druckverfahren;
    }
    public void setDruckverfahren(String druckverfahren) {
        this.druckverfahren = druckverfahren;
    }

    public String getVerbrauch() {
        return this.verbrauch;
    }
    public void setVerbrauch(String verbrauch) {
        this.verbrauch = verbrauch;
    }

    public String getSachbearbeiterrav() {
        return this.sachbearbeiterrav;
    }
    public void setSachbearbeiterrav(String sachbearbeiterrav) {
        this.sachbearbeiterrav = sachbearbeiterrav;
    }

    public String getSachbearbeiterheepen() {
        return this.sachbearbeiterheepen;
    }
    public void setSachbearbeiterheepen(String sachbearbeiterheepen) {
        this.sachbearbeiterheepen = sachbearbeiterheepen;
    }

    public String getEntsorgung() {
        return this.entsorgung;
    }
    public void setEntsorgung(String entsorgung) {
        this.entsorgung = entsorgung;
    }

    public Boolean getAbwasseranfall() {
        return this.abwasseranfall;
    }
    public void setAbwasseranfall(Boolean abwasseranfall) {
        this.abwasseranfall = abwasseranfall;
    }

    public Boolean getGenpflicht() {
        return this.genpflicht;
    }
    public void setGenpflicht(Boolean genpflicht) {
        this.genpflicht = genpflicht;
    }

    public Boolean getAba() {
        return this.aba;
    }
    public void setAba(Boolean aba) {
        this.aba = aba;
    }

    public Date getGen58() {
        return this.gen58;
    }
    public void setGen58(Date gen58) {
        this.gen58 = gen58;
    }

    public Date getGen59() {
        return this.gen59;
    }
    public void setGen59(Date gen59) {
        this.gen59 = gen59;
    }

    public String getBemerkungen() {
        return this.bemerkungen;
    }
    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public Boolean getAbfallrechtlentsorg() {
        return this.abfallrechtlentsorg;
    }
    public void setAbfallrechtlentsorg(Boolean abfallrechtlentsorg) {
        this.abfallrechtlentsorg = abfallrechtlentsorg;
    }

    public Boolean getSpuelwasser() {
        return this.spuelwasser;
    }
    public void setSpuelwasser(Boolean spuelwasser) {
        this.spuelwasser = spuelwasser;
    }

    public Boolean getLeimabwasser() {
        return this.leimabwasser;
    }
    public void setLeimabwasser(Boolean leimabwasser) {
        this.leimabwasser = leimabwasser;
    }

    public Date getErfasstam() {
        return this.erfasstam;
    }
    public void setErfasstam(Date erfasstam) {
        this.erfasstam = erfasstam;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDeleted() {
        return this.deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
