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

package de.bielefeld.umweltamt.aui.mappings.generated.tipi;


/**
 * A class that represents a row in the DeaWasserbehoerdenId database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class DeaWasserbehoerdenId  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private String behoerdenId;
    private int behoerdenVersion;

    /** Default constructor */
    public DeaWasserbehoerdenId() {
        // This place is intentionally left blank.
    }


    /** Full constructor */
    public DeaWasserbehoerdenId(
        String behoerdenId, int behoerdenVersion) {
        this.behoerdenId = behoerdenId;
        this.behoerdenVersion = behoerdenVersion;
    }

    /* Setter and getter methods */
    public String getBehoerdenId() {
        return this.behoerdenId;
    }

    public void setBehoerdenId(String behoerdenId) {
        this.behoerdenId = behoerdenId;
    }

    public int getBehoerdenVersion() {
        return this.behoerdenVersion;
    }

    public void setBehoerdenVersion(int behoerdenVersion) {
        this.behoerdenVersion = behoerdenVersion;
    }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
         if ( (other == null ) ) return false;
         if ( !(other instanceof DeaWasserbehoerdenId) ) return false;
         DeaWasserbehoerdenId castOther = ( DeaWasserbehoerdenId ) other; 
         
         return ( (this.getBehoerdenId()==castOther.getBehoerdenId()) || ( this.getBehoerdenId()!=null && castOther.getBehoerdenId()!=null && this.getBehoerdenId().equals(castOther.getBehoerdenId()) ) )
 && (this.getBehoerdenVersion()==castOther.getBehoerdenVersion());
   }

   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getBehoerdenId() == null ? 0 : this.getBehoerdenId().hashCode() );
         result = 37 * result + this.getBehoerdenVersion();
         return result;
   }   
    /* Custom code goes below here! */

}
