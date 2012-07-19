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
 * {@link AtlParametergruppen}.
 */
public abstract class AbstractAtlParametergruppen  implements java.io.Serializable {

     private int id;
     private String name;
     private Double preisfueranalyse;
     private Set<AtlParameter> atlParameters = new HashSet<AtlParameter>(0);

    public AbstractAtlParametergruppen() {
    }

    public AbstractAtlParametergruppen(
    	int id) {
        this.id = id;
    }

    public AbstractAtlParametergruppen(
    	int id, String name, Double preisfueranalyse, Set<AtlParameter> atlParameters) {
        this.id = id;
        this.name = name;
        this.preisfueranalyse = preisfueranalyse;
        this.atlParameters = atlParameters;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPreisfueranalyse() {
        return this.preisfueranalyse;
    }
    public void setPreisfueranalyse(Double preisfueranalyse) {
        this.preisfueranalyse = preisfueranalyse;
    }

    public Set<AtlParameter> getAtlParameters() {
        return this.atlParameters;
    }
    public void setAtlParameters(Set<AtlParameter> atlParameters) {
        this.atlParameters = atlParameters;
    }

}
