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

import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a row in the VawsBehaelterart database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class VawsBehaelterart  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private int id;
    private String behaelterart;
    private boolean enabled;
    private boolean deleted;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public VawsBehaelterart() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public VawsBehaelterart(
        int id, boolean enabled, boolean deleted) {
        this.id = id;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public VawsBehaelterart(
        int id, String behaelterart, boolean enabled, boolean deleted) {
        this.id = id;
        this.behaelterart = behaelterart;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /* Setter and getter methods */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBehaelterart() {
        return this.behaelterart;
    }

    public void setBehaelterart(String behaelterart) {
        this.behaelterart = behaelterart;
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
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>VawsBehaelterart</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static VawsBehaelterart merge(VawsBehaelterart detachedInstance) {
        log.debug("Merging VawsBehaelterart instance " + detachedInstance);
        return (VawsBehaelterart) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return VawsBehaelterart.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(VawsBehaelterart detachedInstance) {
        log.debug("Deleting VawsBehaelterart instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return VawsBehaelterart.delete(this);
    }

    /**
     * Find an <code>VawsBehaelterart</code> instance by its primary key
     * @param id the primary key value
     * @return <code>VawsBehaelterart</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static VawsBehaelterart findById(int id) {
        log.debug("Getting VawsBehaelterart instance with id: " + id);
        return (VawsBehaelterart)
            new DatabaseAccess().get(VawsBehaelterart.class, id);
    }

    /**
     * Get a list of all <code>VawsBehaelterart</code>
     * @return <code>List&lt;VawsBehaelterart&gt;</code>
     *         all <code>VawsBehaelterart</code>
     */
    public static List<VawsBehaelterart> getAll() {
        log.debug("Getting all VawsBehaelterart instances");
        String query = "FROM VawsBehaelterart";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<VawsBehaelterart> resultList = new ArrayList<VawsBehaelterart>();
        VawsBehaelterart result = null;
        for (Object object : objectList) {
            result = (VawsBehaelterart) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
