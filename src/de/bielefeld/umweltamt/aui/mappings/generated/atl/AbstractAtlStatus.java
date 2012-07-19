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

package de.bielefeld.umweltamt.aui.mappings.generated.atl;


import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link AtlStatus}.
 */
public abstract class AbstractAtlStatus  implements java.io.Serializable {

     private int id;
     private String bezeichnung;
     private Set<AtlProbenahmen> atlProbenahmens = new HashSet<AtlProbenahmen>(0);

    public AbstractAtlStatus() {
    }

    public AbstractAtlStatus(
    	int id) {
        this.id = id;
    }

    public AbstractAtlStatus(
    	int id, String bezeichnung, Set<AtlProbenahmen> atlProbenahmens) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.atlProbenahmens = atlProbenahmens;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Set<AtlProbenahmen> getAtlProbenahmens() {
        return this.atlProbenahmens;
    }
    public void setAtlProbenahmens(Set<AtlProbenahmen> atlProbenahmens) {
        this.atlProbenahmens = atlProbenahmens;
    }

}
