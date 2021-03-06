/**
 * Copyright 2005-2042, Stadt Bielefeld
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

// Generated by Hibernate Tools 5.0.0.Final

package de.bielefeld.umweltamt.aui.mappings.basis;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlProbenahmen;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlProbepkt;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the BasisSachbearbeiter database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class BasisSachbearbeiter  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forBasisSachbearbeiter;
    
    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private String kennummer;
    private String name;
    private String zeichen;
    private String zimmer;
    private String telefon;
    private String email;
    private String gehoertzuarbeitsgr;
    private boolean enabled;
    private boolean deleted;
    private Set<AtlProbepkt> atlProbepkts = new HashSet<AtlProbepkt>(0);
    private Set<BasisObjekt> basisObjekts = new HashSet<BasisObjekt>(0);
    private Set<AtlProbenahmen> atlProbenahmens = new HashSet<AtlProbenahmen>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public BasisSachbearbeiter() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public BasisSachbearbeiter(
        Integer id, String kennummer, String name, boolean enabled, boolean deleted) {
        this.id = id;
        this.kennummer = kennummer;
        this.name = name;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public BasisSachbearbeiter(
        Integer id, String kennummer, String name, String zeichen, String zimmer, String telefon, String email, String gehoertzuarbeitsgr, boolean enabled, boolean deleted, Set<AtlProbepkt> atlProbepkts, Set<BasisObjekt> basisObjekts, Set<AtlProbenahmen> atlProbenahmens) {
        this.id = id;
        this.kennummer = kennummer;
        this.name = name;
        this.zeichen = zeichen;
        this.zimmer = zimmer;
        this.telefon = telefon;
        this.email = email;
        this.gehoertzuarbeitsgr = gehoertzuarbeitsgr;
        this.enabled = enabled;
        this.deleted = deleted;
        this.atlProbepkts = atlProbepkts;
        this.basisObjekts = basisObjekts;
        this.atlProbenahmens = atlProbenahmens;
    }

    /* Setter and getter methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKennummer() {
        return this.kennummer;
    }

    public void setKennummer(String kennummer) {
        this.kennummer = kennummer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZeichen() {
        return this.zeichen;
    }

    public void setZeichen(String zeichen) {
        this.zeichen = zeichen;
    }

    public String getZimmer() {
        return this.zimmer;
    }

    public void setZimmer(String zimmer) {
        this.zimmer = zimmer;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGehoertzuarbeitsgr() {
        return this.gehoertzuarbeitsgr;
    }

    public void setGehoertzuarbeitsgr(String gehoertzuarbeitsgr) {
        this.gehoertzuarbeitsgr = gehoertzuarbeitsgr;
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

    public Set<AtlProbepkt> getAtlProbepkts() {
        return this.atlProbepkts;
    }

    public void setAtlProbepkts(Set<AtlProbepkt> atlProbepkts) {
        this.atlProbepkts = atlProbepkts;
    }

    public Set<BasisObjekt> getBasisObjekts() {
        return this.basisObjekts;
    }

    public void setBasisObjekts(Set<BasisObjekt> basisObjekts) {
        this.basisObjekts = basisObjekts;
    }

    public Set<AtlProbenahmen> getAtlProbenahmens() {
        return this.atlProbenahmens;
    }

    public void setAtlProbenahmens(Set<AtlProbenahmen> atlProbenahmens) {
        this.atlProbenahmens = atlProbenahmens;
    }

    /**
     * To implement custom toString methods, jump to not generated code.<br>
     * Basically we either call on <code>toDebugString</code> for a debug
     * string, call on <code>toGuiString</code> for a gui representation or do
     * something completely different.
     * @return String
     */
    @Override
    public String toString() {
        return DatabaseClassToString.toStringForClass(this); 
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");			
        buffer.append("kennummer").append("='").append(getKennummer()).append("' ");			
        buffer.append("name").append("='").append(getName()).append("' ");			
        buffer.append("zeichen").append("='").append(getZeichen()).append("' ");			
        buffer.append("zimmer").append("='").append(getZimmer()).append("' ");			
        buffer.append("telefon").append("='").append(getTelefon()).append("' ");			
        buffer.append("email").append("='").append(getEmail()).append("' ");			
        buffer.append("gehoertzuarbeitsgr").append("='").append(getGehoertzuarbeitsgr()).append("' ");			
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");			
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");			
        buffer.append("atlProbepkts").append("='").append(getAtlProbepkts()).append("' ");			
        buffer.append("basisObjekts").append("='").append(getBasisObjekts()).append("' ");			
        buffer.append("atlProbenahmens").append("='").append(getAtlProbenahmens()).append("' ");			
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * @param other
     * @return <code>true</code>, if this and other are equal,
     *         <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof BasisSachbearbeiter)) return false;
        return (this.getId().equals(
            ((BasisSachbearbeiter) other).getId()));
    }

    /**
     * Calculate a unique hashCode
     * @return <code>int</code>
     */
    @Override
    public int hashCode() {
        int result = 17;
        int idValue = this.getId() == null ?
            0 : this.getId().hashCode();
        result = result * 37 + idValue;
        return result;
    }
    
    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>BasisSachbearbeiter</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static BasisSachbearbeiter merge(BasisSachbearbeiter detachedInstance) {
        log.debug("Merging BasisSachbearbeiter instance " + detachedInstance);
        return (BasisSachbearbeiter) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        BasisSachbearbeiter saved = BasisSachbearbeiter.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this BasisSachbearbeiter with its new values.<br>
     * This is meant to be used after merging!
     * @param copy BasisSachbearbeiter
     */
    private void copy(BasisSachbearbeiter copy) {
        this.id = copy.getId();            
        this.kennummer = copy.getKennummer();            
        this.name = copy.getName();            
        this.zeichen = copy.getZeichen();            
        this.zimmer = copy.getZimmer();            
        this.telefon = copy.getTelefon();            
        this.email = copy.getEmail();            
        this.gehoertzuarbeitsgr = copy.getGehoertzuarbeitsgr();            
        this.enabled = copy.isEnabled();            
        this.deleted = copy.isDeleted();            
        this.atlProbepkts = copy.getAtlProbepkts();            
        this.basisObjekts = copy.getBasisObjekts();            
        this.atlProbenahmens = copy.getAtlProbenahmens();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(BasisSachbearbeiter detachedInstance) {
        log.debug("Deleting BasisSachbearbeiter instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return BasisSachbearbeiter.delete(this);
    }

    /**
     * Find an <code>BasisSachbearbeiter</code> instance by its primary key
     * @param id the primary key value
     * @return <code>BasisSachbearbeiter</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static BasisSachbearbeiter findById(java.lang.Integer id) {
        log.debug("Getting BasisSachbearbeiter instance with id: " + id);
        return (BasisSachbearbeiter)
            new DatabaseAccess().get(BasisSachbearbeiter.class, id);
    }

    /**
     * Get a list of all <code>BasisSachbearbeiter</code>
     * @return <code>List&lt;BasisSachbearbeiter&gt;</code>
     *         all <code>BasisSachbearbeiter</code>
     */
    public static List<BasisSachbearbeiter> getAll() {
        return DatabaseQuery.getAll(new BasisSachbearbeiter());
    }

    /* Custom code goes below here! */
	public static BasisSachbearbeiter findByKennummer(String nr){
		List<BasisSachbearbeiter> list = BasisSachbearbeiter.getAll();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getKennummer().equals(nr)){
				return list.get(i);
			}
		}
		return null;
	}
}
