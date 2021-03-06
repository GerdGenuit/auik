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

package de.bielefeld.umweltamt.aui.mappings.atl;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.List;

/**
 * A class that represents a row in the AtlAnalyseposition database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class AtlAnalyseposition  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forAtlAnalyseposition;
    
    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private AtlEinheiten atlEinheiten;
    private AtlParameter atlParameter;
    private AtlProbenahmen atlProbenahmen;
    private String grkl;
    private Float wert;
    private String analyseVon;
    private String bericht;
    private Double normwert;
    private boolean enabled;
    private boolean deleted;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public AtlAnalyseposition() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public AtlAnalyseposition(
        AtlParameter atlParameter, AtlProbenahmen atlProbenahmen, Float wert, boolean enabled, boolean deleted) {
        this.atlParameter = atlParameter;
        this.atlProbenahmen = atlProbenahmen;
        this.wert = wert;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public AtlAnalyseposition(
        AtlEinheiten atlEinheiten, AtlParameter atlParameter, AtlProbenahmen atlProbenahmen, String grkl, Float wert, String analyseVon, String bericht, Double normwert, boolean enabled, boolean deleted) {
        this.atlEinheiten = atlEinheiten;
        this.atlParameter = atlParameter;
        this.atlProbenahmen = atlProbenahmen;
        this.grkl = grkl;
        this.wert = wert;
        this.analyseVon = analyseVon;
        this.bericht = bericht;
        this.normwert = normwert;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /* Setter and getter methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AtlEinheiten getAtlEinheiten() {
        return this.atlEinheiten;
    }

    public void setAtlEinheiten(AtlEinheiten atlEinheiten) {
        this.atlEinheiten = atlEinheiten;
    }

    public AtlParameter getAtlParameter() {
        return this.atlParameter;
    }

    public void setAtlParameter(AtlParameter atlParameter) {
        this.atlParameter = atlParameter;
    }

    public AtlProbenahmen getAtlProbenahmen() {
        return this.atlProbenahmen;
    }

    public void setAtlProbenahmen(AtlProbenahmen atlProbenahmen) {
        this.atlProbenahmen = atlProbenahmen;
    }

    public String getGrkl() {
        return this.grkl;
    }

    public void setGrkl(String grkl) {
        this.grkl = grkl;
    }

    public Float getWert() {
        return this.wert;
    }

    public void setWert(Float wert) {
        this.wert = wert;
    }

    public String getAnalyseVon() {
        return this.analyseVon;
    }

    public void setAnalyseVon(String analyseVon) {
        this.analyseVon = analyseVon;
    }

    public String getBericht() {
        return this.bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public Double getNormwert() {
        return this.normwert;
    }

    public void setNormwert(Double normwert) {
        this.normwert = normwert;
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
        buffer.append("atlEinheiten").append("='").append(getAtlEinheiten()).append("' ");			
        buffer.append("atlParameter").append("='").append(getAtlParameter()).append("' ");			
        buffer.append("atlProbenahmen").append("='").append(getAtlProbenahmen()).append("' ");			
        buffer.append("grkl").append("='").append(getGrkl()).append("' ");			
        buffer.append("wert").append("='").append(getWert()).append("' ");			
        buffer.append("analyseVon").append("='").append(getAnalyseVon()).append("' ");			
        buffer.append("bericht").append("='").append(getBericht()).append("' ");			
        buffer.append("normwert").append("='").append(getNormwert()).append("' ");			
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");			
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");			
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
        if (!(other instanceof AtlAnalyseposition)) return false;
        return (this.getId().equals(
            ((AtlAnalyseposition) other).getId()));
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
     * @return <code>AtlAnalyseposition</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static AtlAnalyseposition merge(AtlAnalyseposition detachedInstance) {
        log.debug("Merging AtlAnalyseposition instance " + detachedInstance);
        return (AtlAnalyseposition) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        AtlAnalyseposition saved = AtlAnalyseposition.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this AtlAnalyseposition with its new values.<br>
     * This is meant to be used after merging!
     * @param copy AtlAnalyseposition
     */
    private void copy(AtlAnalyseposition copy) {
        this.atlEinheiten = copy.getAtlEinheiten();            
        this.atlParameter = copy.getAtlParameter();            
        this.atlProbenahmen = copy.getAtlProbenahmen();            
        this.grkl = copy.getGrkl();            
        this.wert = copy.getWert();            
        this.analyseVon = copy.getAnalyseVon();            
        this.bericht = copy.getBericht();            
        this.normwert = copy.getNormwert();            
        this.enabled = copy.isEnabled();            
        this.deleted = copy.isDeleted();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(AtlAnalyseposition detachedInstance) {
        log.debug("Deleting AtlAnalyseposition instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return AtlAnalyseposition.delete(this);
    }

    /**
     * Find an <code>AtlAnalyseposition</code> instance by its primary key
     * @param id the primary key value
     * @return <code>AtlAnalyseposition</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static AtlAnalyseposition findById(java.lang.Integer id) {
        log.debug("Getting AtlAnalyseposition instance with id: " + id);
        return (AtlAnalyseposition)
            new DatabaseAccess().get(AtlAnalyseposition.class, id);
    }

    /**
     * Get a list of all <code>AtlAnalyseposition</code>
     * @return <code>List&lt;AtlAnalyseposition&gt;</code>
     *         all <code>AtlAnalyseposition</code>
     */
    public static List<AtlAnalyseposition> getAll() {
        return DatabaseQuery.getAll(new AtlAnalyseposition());
    }

    /* Custom code goes below here! */

}
