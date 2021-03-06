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

package de.bielefeld.umweltamt.aui.module.common.tablemodels;

import java.util.ArrayList;
import java.util.List;

import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisAdresse;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisLage;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;
import de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel;
import de.bielefeld.umweltamt.aui.mappings.vaws.VawsWassereinzugsgebiete;
import de.bielefeld.umweltamt.aui.mappings.vaws.VawsStandortgghwsg;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisMapAdresseLage;

/**
 * Ein TableModel für die Basis-Standortdaten.
 * 
 * @author David Klotz
 */
public class BasisLageModel extends ListTableModel
{
	private static final long serialVersionUID = 3532697905957103920L;
	private String lastStrasse = null;
	private String lastOrt = null;
	private int lastHausNr = -1;
    private static final AuikLogger log = AuikLogger.getLogger();

	public BasisLageModel()
	{
		super(new String[] {
				/* "St.ID", */
				"Straße",
				"Hausnr.",
				"PLZ",
				"Ort",
				"Entw.-Gebiet",
				"Übersch.-Gebiet",
				"Wasserschutzgebiet",
				"VAwS-Gebiet" }, true, true);
        log.debug("Creating new BasisLagemodel");
	}
    
    
	/**
	 * Aktualisiert die aktuell angezeigte Liste.
	 * Falls noch keine Suche durchgeführt wurde, werden die
	 * ersten 30 Einträge angezeigt.
	 */
	@Override
	public void updateList()
	{
		if (lastStrasse != null)
		{
			filterList(lastStrasse, lastHausNr, lastOrt);
		}
	}

	/**
	 * Liefert das Objekt aus einer bestimmten Zeile.
	 * 
	 * @param rowIndex
	 *            Die Zeile
	 * @return Das Objekt bei rowIndex
	 */
	public BasisMapAdresseLage getRow(int rowIndex)
	{
		return (BasisMapAdresseLage) getObjectAtRow(rowIndex);
	}
    
	/**
	 * Filtert den Tabelleninhalt nach der Straße und der Hausnr.
	 * 
	 * @param strasse
	 *            Der Straßenname
	 * @param hausnr
	 *            Die Hausnr (oder -1 falls alle Standorte in dieser Straßen
	 *            gesucht werden sollen)
	 */
	public void filterList(String strasse, int hausnr, String ort)
	{
        log.debug("Fetching BasisAdresse and BasisLage Objects");
        //Fetch all BasisAdresse and BasisLage Objects
        List<Object[]> list = DatabaseQuery.findStandorteNew(strasse, hausnr, ort);
        log.debug("Fetched " + list.size() + " Objects");
        List<BasisMapAdresseLage> standorte = new ArrayList<BasisMapAdresseLage>();
        //Add fetched objects to a list of BasisMapAdresseLage
        for(Object[] i: list){
        	BasisMapAdresseLage adr = (BasisMapAdresseLage)i[1];
            standorte.add(adr);
        }
        setList(standorte);
        log.debug("Created list");
		lastOrt = ort;
		lastStrasse = strasse;
		lastHausNr = hausnr;
        
	}
	
	/**
	 * Filtert den Tabelleninhalt nach einem Standort.
	 * 
	 * @param std
	 *            BasisLage
	 */
	public void filterList(BasisMapAdresseLage std)
	{
		List<BasisMapAdresseLage> oneItemList = new ArrayList<BasisMapAdresseLage>();
		oneItemList.add(std);
		setList(oneItemList);
	}

	/**
	 * Liefert den Inhalt der Spalte mit den gegebenen Koordinaten.
	 * 
	 * @see de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel#getColumnValue(Object,
	 *      int)
	 * @param objectAtRow
	 *            Das Object in dieser Zeile
	 * @param columnIndex
	 *            Die Spalte der Tabelle
	 * @return Den Wert der Zelle oder null (falls die Zelle nicht existiert)
	 */
	@Override
	public Object getColumnValue(Object objectAtRow, int columnIndex)
	{
		Object value = null;
		BasisMapAdresseLage bsta = (BasisMapAdresseLage) objectAtRow;
		if (bsta != null && bsta.getBasisLage() != null){
		switch (columnIndex)
		{
		/*
		 * case 0: value = bsta.getStandortid(); break;
		 */
			case 0:
				value = bsta.getBasisAdresse().getStrasse();
				break;
			case 1:
				if (bsta.getHausnrzus() != null)
				{
					String tmp = bsta.getBasisAdresse().getHausnr() + bsta.getBasisAdresse().getHausnrzus();
					value = tmp;
				}
				else
				{
					value = bsta.getBasisAdresse().getHausnr();
				}
				break;
			case 2:
				value = bsta.getBasisAdresse().getPlz();
				break;
			case 3:
				value = bsta.getBasisAdresse().getOrt();
				break;
			case 4:
				if (bsta.getBasisLage() != null || bsta.getBasisLage().getEntgebid() != null)
				{
					value = bsta.getBasisLage().getEntgebid();
				}
				else
					value = "";
				break;
			case 5:
				if (bsta.getBasisLage() != null && bsta.getBasisLage().getVawsStandortgghwsg() != null)
				{
					Integer sggh = bsta.getBasisLage().getVawsStandortgghwsg().getId();
					if (sggh.equals(6))
					{
						value = new Boolean(true);
					}
					else
					{
						value = new Boolean(false);
					}
				}
				else
				{
					value = new Boolean(false);
				}
				break;
			case 6:
				if (bsta.getBasisLage() != null && bsta.getBasisLage().getVawsStandortgghwsg() != null)
				{
					Integer sggh = bsta.getBasisLage().getVawsStandortgghwsg().getId();
					if (sggh.equals(1))
					{
						value = new String("Zone I");
					}
					else if (sggh.equals(2))
					{
						value = new String("Zone II");
					}
					else if (sggh.equals(3))
					{
						value = new String("Zone III/III A");
					}
					else if (sggh.equals(4))
					{
						value = new String("Zone III B");
					}
				}
				else
				{
					value = new String("");
				}
				break;
			case 7:
				if (bsta.getBasisLage() != null || bsta.getBasisLage().getVawsWassereinzugsgebiete() != null) {
					value = bsta.getBasisLage().getVawsWassereinzugsgebiete();					
				}
				break;
			default:
				value = null;
		}
		}
		return value;
		
	}

	@Override
	public boolean objectRemoved(Object objectAtRow)
	{
		BasisMapAdresseLage removedStandort = (BasisMapAdresseLage) objectAtRow;
		return BasisMapAdresseLage.delete(removedStandort);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		switch (columnIndex)
		{
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return String.class;
			case 3:
				return String.class;
			case 4:
				return String.class;
			case 5:
				return Boolean.class;
			case 6:
				return String.class;
			case 7:
				return String.class;
			default:
				return null;
		}
	}
}
