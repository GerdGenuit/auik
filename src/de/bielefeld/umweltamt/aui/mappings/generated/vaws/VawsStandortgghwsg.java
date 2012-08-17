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

// Generated by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.vaws;

import de.bielefeld.umweltamt.aui.mappings.generated.basis.BasisStandort;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the VawsStandortgghwsg database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class VawsStandortgghwsg  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private int id;
    private String standortgg;
    private boolean enabled;
    private boolean deleted;
    private Set<BasisStandort> basisStandorts = new HashSet<BasisStandort>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public VawsStandortgghwsg() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public VawsStandortgghwsg(
        int id, boolean enabled, boolean deleted) {
        this.id = id;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public VawsStandortgghwsg(
        int id, String standortgg, boolean enabled, boolean deleted, Set<BasisStandort> basisStandorts) {
        this.id = id;
        this.standortgg = standortgg;
        this.enabled = enabled;
        this.deleted = deleted;
        this.basisStandorts = basisStandorts;
    }

    /* Setter and getter methods */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandortgg() {
        return this.standortgg;
    }

    public void setStandortgg(String standortgg) {
        this.standortgg = standortgg;
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

    public Set<BasisStandort> getBasisStandorts() {
        return this.basisStandorts;
    }

    public void setBasisStandorts(Set<BasisStandort> basisStandorts) {
        this.basisStandorts = basisStandorts;
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>VawsStandortgghwsg</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static VawsStandortgghwsg merge(VawsStandortgghwsg detachedInstance) {
        log.debug("Merging VawsStandortgghwsg instance " + detachedInstance);
        return (VawsStandortgghwsg) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return VawsStandortgghwsg.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(VawsStandortgghwsg detachedInstance) {
        log.debug("Deleting VawsStandortgghwsg instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return VawsStandortgghwsg.delete(this);
    }

    /**
     * Find an <code>VawsStandortgghwsg</code> instance by its primary key
     * @param id the primary key value
     * @return <code>VawsStandortgghwsg</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static VawsStandortgghwsg findById(int id) {
        log.debug("Getting VawsStandortgghwsg instance with id: " + id);
        return (VawsStandortgghwsg)
            new DatabaseAccess().get(VawsStandortgghwsg.class, id);
    }

    /**
     * Get a list of all <code>VawsStandortgghwsg</code>
     * @return <code>List&lt;VawsStandortgghwsg&gt;</code>
     *         all <code>VawsStandortgghwsg</code>
     */
    public static List<VawsStandortgghwsg> getAll() {
        log.debug("Getting all VawsStandortgghwsg instances");
        String query = "FROM VawsStandortgghwsg";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<VawsStandortgghwsg> resultList = new ArrayList<VawsStandortgghwsg>();
        VawsStandortgghwsg result = null;
        for (Object object : objectList) {
            result = (VawsStandortgghwsg) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
