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
 * A class that represents a row in the VawsWassereinzugsgebiete database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class VawsWassereinzugsgebiete  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private int id;
    private String ezgbname;
    private boolean enabled;
    private boolean deleted;
    private Set<BasisStandort> basisStandorts = new HashSet<BasisStandort>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public VawsWassereinzugsgebiete() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public VawsWassereinzugsgebiete(
        int id, boolean enabled, boolean deleted) {
        this.id = id;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public VawsWassereinzugsgebiete(
        int id, String ezgbname, boolean enabled, boolean deleted, Set<BasisStandort> basisStandorts) {
        this.id = id;
        this.ezgbname = ezgbname;
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

    public String getEzgbname() {
        return this.ezgbname;
    }

    public void setEzgbname(String ezgbname) {
        this.ezgbname = ezgbname;
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
     * @return <code>VawsWassereinzugsgebiete</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static VawsWassereinzugsgebiete merge(VawsWassereinzugsgebiete detachedInstance) {
        log.debug("Merging VawsWassereinzugsgebiete instance " + detachedInstance);
        return (VawsWassereinzugsgebiete) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return VawsWassereinzugsgebiete.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(VawsWassereinzugsgebiete detachedInstance) {
        log.debug("Deleting VawsWassereinzugsgebiete instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return VawsWassereinzugsgebiete.delete(this);
    }

    /**
     * Find an <code>VawsWassereinzugsgebiete</code> instance by its primary key
     * @param id the primary key value
     * @return <code>VawsWassereinzugsgebiete</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static VawsWassereinzugsgebiete findById(int id) {
        log.debug("Getting VawsWassereinzugsgebiete instance with id: " + id);
        return (VawsWassereinzugsgebiete)
            new DatabaseAccess().get(VawsWassereinzugsgebiete.class, id);
    }

    /**
     * Get a list of all <code>VawsWassereinzugsgebiete</code>
     * @return <code>List&lt;VawsWassereinzugsgebiete&gt;</code>
     *         all <code>VawsWassereinzugsgebiete</code>
     */
    public static List<VawsWassereinzugsgebiete> getAll() {
        log.debug("Getting all VawsWassereinzugsgebiete instances");
        String query = "FROM VawsWassereinzugsgebiete";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<VawsWassereinzugsgebiete> resultList = new ArrayList<VawsWassereinzugsgebiete>();
        VawsWassereinzugsgebiete result = null;
        for (Object object : objectList) {
            result = (VawsWassereinzugsgebiete) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
