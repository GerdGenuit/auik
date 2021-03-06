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

/*
 * Datei:
 * $Id: ProbenEditor.java,v 1.2.2.2 2010-11-23 14:25:23 u633d Exp $
 *
 * Erstellt am 25.5.05 von David Klotz (u633z)
 *
 * CVS-Log:
 * $Log: not supported by cvs2svn $
 * Revision 1.2.2.1  2010/11/23 10:25:57  u633d
 * start auik_pg branch
 *
 * Revision 1.2  2009/03/24 12:35:23  u633d
 * Umstellung auf UTF8
 *
 * Revision 1.1  2008/06/05 11:38:41  u633d
 * Start AUIK auf Informix und Postgresql
 *
 * Revision 1.11  2005/09/14 11:25:36  u633d
 * - Version vom 14.9.
 *
 * Revision 1.10  2005/09/07 10:48:22  u633d
 * - Version vom 7.9.05
 *
 * Revision 1.9  2005/07/06 09:40:13  u633z
 * - Grenzwerte auch für SielhautBearbeiten-Proben
 *
 * Revision 1.8  2005/06/30 11:46:33  u633z
 * *** empty log message ***
 *
 * Revision 1.7  2005/06/14 13:33:39  u633z
 * - Layout korrigiert
 *
 * Revision 1.6  2005/06/10 11:07:21  u633z
 * - Datenbank-Zugriffe komplett in DB-Klassen ausgelagert
 * - Einige DB-Klassen vervollständigt
 *
 * Revision 1.5  2005/06/09 13:45:33  u633z
 * - ProbenEditor auf AbstractBaseEditor umgestellt
 *
 */
package de.bielefeld.umweltamt.aui.module.common.editors;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import net.sf.jasperreports.engine.JRDataSource;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.bielefeld.umweltamt.aui.GUIManager;
import de.bielefeld.umweltamt.aui.HauptFrame;
import de.bielefeld.umweltamt.aui.SettingsManager;
import de.bielefeld.umweltamt.aui.mappings.DatabaseConstants;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlAnalyseposition;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlEinheiten;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlParameter;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlParametergruppen;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlProbeart;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlProbenahmen;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlStatus;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisAdresse;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisSachbearbeiter;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisLage;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.ComboBoxRenderer;
import de.bielefeld.umweltamt.aui.utils.CurrencyDouble;
import de.bielefeld.umweltamt.aui.utils.DateUtils;
import de.bielefeld.umweltamt.aui.utils.DoubleField;
import de.bielefeld.umweltamt.aui.utils.DoubleRenderer;
import de.bielefeld.umweltamt.aui.utils.JRMapDataSource;
import de.bielefeld.umweltamt.aui.utils.KommaDouble;
import de.bielefeld.umweltamt.aui.utils.LimitedTextArea;
import de.bielefeld.umweltamt.aui.utils.PDFExporter;
import de.bielefeld.umweltamt.aui.utils.SelectTable;
import de.bielefeld.umweltamt.aui.utils.TabAction;
import de.bielefeld.umweltamt.aui.utils.TableFocusListener;
import de.bielefeld.umweltamt.aui.utils.TextFieldDateChooser;
import de.bielefeld.umweltamt.aui.utils.dialogbase.OkCancelApplyDialog;
import de.bielefeld.umweltamt.aui.utils.tablemodelbase.EditableListTableModel;
import de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel;

/**
 * Ein Dialog um eine Probenahme mit ihren Analysepositionen zu bearbeiten.
 * (Momentan ist vieles noch auf Kärschlamm-Proben ausgerichtet)
 * @author David Klotz
 */
public class ProbenEditor extends AbstractApplyEditor {
    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();
    private static final long serialVersionUID = 5903518104076020136L;

    public interface OKListener {
        public void onOK(AtlParameter[] params);
    }

    /**
     * Dieser Wert stellt den Preis einer Stunde f&uuml;r Personal- und
     * Sachkosten in Cent dar.
     **/
    public static final double PERSONAL_UND_SACHKOSTEN = 5758;

    /**
     * Dieser Wert gibt an, wieviele Stellen das Feld in der Datei kasse.txt
     * besitzen muss, welches das Rechnungsdatum und den Rechnungsbetrag
     * enth&auml;lt.
     **/
    public static final int ZIFFERN_RECHNUNGS_FELD = 19;

    /**
     * Der Dateiname <i>(kasse.txt)</i> der Kassendatei eines
     * Geb&uuml;hrenbescheides.
     **/
    public static final String KASSE_FILENAME = "kasse.txt";

    private class ParameterModel extends EditableListTableModel {
        private static final long serialVersionUID = 6042681141925302970L;
        private AtlProbenahmen probe;
        private boolean isNew;
        private boolean isSchlamm;
        private boolean isSielhaut;

        public ParameterModel(AtlProbenahmen probe, boolean isNew,
            boolean isSchlamm, boolean isSielhaut) {
            super(new String[] {"Parameter", "GrKl", "Messwert", "Einheit",
                    "Analyse von", "Grenzwert", "% Normwert"}, false, true);
            this.probe = probe;
            this.isNew = isNew;
            this.isSchlamm = isSchlamm;
            this.isSielhaut = isSielhaut;

            updateList();
        }

        @Override
        public void updateList() {
            // Set positionen;
            if (!this.isNew) {
                // AUIKataster.debugOutput("Bearbeite alte Probe: " + probe);
                // if (!probe.isAnalysepositionenInitialized()) {
                // probe = AtlProbenahmen.getProbenahme(probe.getKennummer(),
                // true);
                // AUIKataster.debugOutput("Analysepositionen gefetcht! Probe neu geholt: "
                // + probe);
                // }
                // positionen = probe.getAtlAnalysepositionen();
                this.probe = AtlProbenahmen.findById(this.probe.getId());
                setList(DatabaseQuery.getSortedAnalysepositionen(this.probe));
            } else { // isNew
                if (this.isSchlamm) {
                    String[] paramIDs = {
                        DatabaseConstants.ATL_PARAMETER_ID_AOX,
                        DatabaseConstants.ATL_PARAMETER_ID_BLEI,
                        DatabaseConstants.ATL_PARAMETER_ID_CADMIUM,
                        DatabaseConstants.ATL_PARAMETER_ID_CHROM,
                        DatabaseConstants.ATL_PARAMETER_ID_KUPFER,
                        DatabaseConstants.ATL_PARAMETER_ID_NICKEL,
                        DatabaseConstants.ATL_PARAMETER_ID_QUECKSILBER,
                        DatabaseConstants.ATL_PARAMETER_ID_ZINK
                    };
                    AtlParameter[] params = new AtlParameter[paramIDs.length];
                    for (int i = 0; i < paramIDs.length; i++) {
                        params[i] = AtlParameter.findById(paramIDs[i]);
                    }
                    String analyse_von = "AGROLAB";
                    setList(new ArrayList<Object>());
                    for (AtlParameter param : params) {
                        addParameter(param,
                            DatabaseConstants.ATL_EINHEIT_MG_KG,
                            analyse_von);
                    }
                } else if (this.probe.getKennummer().startsWith("7")) {
                    AtlParameter[] params = {
                        AtlParameter.findById(
                            DatabaseConstants.ATL_PARAMETER_ID_TOC),
                        AtlParameter.findById(
                            DatabaseConstants.ATL_PARAMETER_ID_ABWASSERMENGE)
                    };
                    String analyse_von = "Betriebslabor";
                    setList(new ArrayList<Object>());
                    for (AtlParameter param : params) {
                        addParameter(param,
                            AtlEinheiten.findById(
                                param.getWirdgemessenineinheit()),
                            analyse_von);
                    }
                } else if (!this.isSielhaut) {
                    AtlParameter[] params = {
                        AtlParameter.findById(
                            DatabaseConstants.ATL_PARAMETER_ID_TEMPERATUR),
                        AtlParameter.findById(
                            DatabaseConstants.ATL_PARAMETER_ID_PH_WERT),
                        AtlParameter.findById(
                            DatabaseConstants.ATL_PARAMETER_ID_LEITFAEHIGKEIT)
                    };
                    String analyse_von = "360.33";
                    setList(new ArrayList<Object>());
                    for (AtlParameter param : params) {
                        addParameter(param,
                            AtlEinheiten.findById(
                                param.getWirdgemessenineinheit()),
                            analyse_von);
                    }
                }
            }
            fireTableDataChanged();
        }

        @Override
        public Object getColumnValue(Object objectAtRow, int columnIndex) {
            Object value;
            AtlAnalyseposition pos = (AtlAnalyseposition) objectAtRow;
            switch (columnIndex) {
                // Parameter
                case 0:
                    value = pos.getAtlParameter();
                    break;
                // GrKl
                case 1:
                    value = pos.getGrkl();
                    break;
                // Wert
                case 2:
                    value = new KommaDouble(pos.getWert());
                    break;
                // Einheit
                case 3:
                    value = pos.getAtlEinheiten();
                    break;
                // Analyse von
                case 4:
                    value = pos.getAnalyseVon();
                    break;
                // Grenzwert
                case 5:
                    value = null;
                    Double grenzWert = null;
                    if (pos.getAtlParameter() != null) {
                        if (DatabaseQuery.isKlaerschlammProbe(this.probe)) {
                            grenzWert = pos.getAtlParameter().getKlaerschlammGw();
                        } else if (this.probe.getAtlProbepkt().getAtlProbeart()
                            .getId().equals(
                            DatabaseConstants.ATL_PROBEART_ID_SIELHAUT)) {
                            grenzWert = pos.getAtlParameter().getSielhautGw();
                        }
                    }

                    if (grenzWert != null && !grenzWert.equals(new Double(0.0))) {
                        value = grenzWert;
                    }
                    break;
                // % Normwert
                case 6:
                    value = "-";
                    if (pos.getAtlEinheiten().getId().equals(
                        DatabaseConstants.ATL_EINHEIT_MG_KG.getId())) {
                        double tmpVal = -1;
                        if (DatabaseQuery.isKlaerschlammProbe(this.probe)) {
                            if (pos.getAtlParameter().getKlaerschlammGw() != null) {
                                if (!pos.getAtlParameter().getKlaerschlammGw()
                                    .equals(new Double(0.0))) {
                                    tmpVal = pos.getWert().doubleValue()
                                        / pos.getAtlParameter()
                                            .getKlaerschlammGw().doubleValue();
                                }
                            }
                        } else if (this.probe.getAtlProbepkt().getAtlProbeart().getId().equals(
                            DatabaseConstants.ATL_PROBEART_ID_SIELHAUT)) {
                            if (pos.getAtlParameter().getSielhautGw() != null) {
                                if (!pos.getAtlParameter().getSielhautGw()
                                    .equals(new Double(0.0))) {
                                    tmpVal = pos.getWert().doubleValue()
                                        / pos.getAtlParameter().getSielhautGw()
                                            .doubleValue();
                                }
                            }
                        }
                        if (tmpVal != -1) {
                            NumberFormat percentFormat = NumberFormat
                                .getPercentInstance();
                            percentFormat.setMinimumFractionDigits(1);
                            if (tmpVal > 1.0) {
                                value = "<html><font color=#ff0000>"
                                    + percentFormat.format(tmpVal)
                                    + "</font></html>";
                            } else {
                                value = percentFormat.format(tmpVal);
                            }
                        }
                    }
                    break;
                default:
                    value = null;
            }

            return value;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == 5 || columnIndex == 6) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public void editObject(Object objectAtRow, int columnIndex,
            Object newValue) {
            AtlAnalyseposition tmp = (AtlAnalyseposition) objectAtRow;

            switch (columnIndex) {
                case 0:
                    AtlParameter tmpPara = (AtlParameter) newValue;
                    tmp.setAtlParameter(tmpPara);
//				AtlParameter sParameter = AtlParameter.getParameter(tmpPara.getBezeichnung());
//				parameterBox.setSelectedItem(tmpPara);
                    break;

                case 1:
                    String tmpGrKl = (String) newValue;
                    if (tmpGrKl != null) {
                        tmpGrKl = tmpGrKl.trim();
                        if (tmpGrKl.equals("")) {
                            tmp.setGrkl(null);
                        } else {
                            tmpGrKl = tmpGrKl.substring(0, 1);
                            if (tmpGrKl.equals("<") || tmpGrKl.equals(">")) {
                                tmp.setGrkl(tmpGrKl);
                            }
                        }
                    }
                    break;

                case 2:
                    Float tmpWert = null;
                    if (newValue instanceof Float) {
                        tmpWert = (Float) newValue;
                    } else if (newValue instanceof KommaDouble) {
                        tmpWert = ((KommaDouble) newValue).getValue()
                            .floatValue();
                    }
                    tmp.setWert(tmpWert);
                    break;

                case 3:
                    AtlEinheiten tmpEinheit = (AtlEinheiten) newValue;
                    tmp.setAtlEinheiten(tmpEinheit);
                    break;

                case 4:
                    String tmpAnalyse = (String) newValue;
                    if (tmpAnalyse != null) {
                        tmpAnalyse = tmpAnalyse.trim();
                        if (tmpAnalyse.equals("")) {
                            tmp.setAnalyseVon(null);
                        } else {
                            tmp.setAnalyseVon(tmpAnalyse);
                        }
                    }
                    break;

                default:
                    break;
            }

            log.debug("EDIT: " + tmp);
        }

        @Override
        public Object newObject() {
            AtlAnalyseposition tmp = new AtlAnalyseposition();
            tmp.setAtlProbenahmen(this.probe);
            if (DatabaseQuery.isKlaerschlammProbe(this.probe)
                || this.probe.getAtlProbepkt().getAtlProbeart().getId().equals(
                    DatabaseConstants.ATL_PROBEART_ID_SIELHAUT)) {
                tmp.setAtlEinheiten(DatabaseConstants.ATL_EINHEIT_MG_KG);
            } else {
                tmp.setAtlEinheiten(DatabaseConstants.ATL_EINHEIT_MG_L);
            }
            tmp.setAtlParameter((AtlParameter) ProbenEditor.this.parameterBox
                .getSelectedItem());
            tmp.setWert(new Float(0));
            tmp.setAtlEinheiten(AtlEinheiten.findById(tmp.getAtlParameter()
                .getWirdgemessenineinheit()));
            // tmp.setAnalyseVon("");
            return tmp;
        }

        /**
         * Diese Methode fügt dem Model einen neuen Parameter hinzu. Falls
         * dieser jedoch schon enthalten ist, wird er verworfen - es kommen also
         * keine doppelten Parameter vor.
         * @param parameter Ein neuer Parameter.
         */
        public void addParameter(AtlParameter parameter) {
            if (isParameterAlreadyThere(parameter)) {
                log.debug("Der Parameter wird bereits geprüft.");
                return;
            }

            AtlAnalyseposition pos = new AtlAnalyseposition();

            pos.setAtlProbenahmen(this.probe);
            pos.setAtlParameter(parameter);
            pos.setWert(new Float(0));
            pos.setAtlEinheiten(AtlEinheiten.findById(parameter
                .getWirdgemessenineinheit()));

//            getList().add(pos);
            List<AtlAnalyseposition> list = (List<AtlAnalyseposition>) getList();
            list.add(pos);

            fireTableDataChanged();
        }

        /**
         * Diese Methode fügt dem Model einen neuen Parameter hinzu. Falls
         * dieser jedoch schon enthalten ist, wird er verworfen - es kommen also
         * keine doppelten Parameter vor.
         * @param parameter Ein neuer Parameter.
         */
        public void addParameter(AtlParameter parameter, AtlEinheiten einheit,
            String analysevon) {
            if (isParameterAlreadyThere(parameter)) {
                log.debug("Der Parameter wird bereits geprüft.");
                return;
            }

            AtlAnalyseposition pos = new AtlAnalyseposition();

            pos.setAtlProbenahmen(this.probe);
            pos.setAtlParameter(parameter);
            pos.setWert(new Float(0));
            pos.setAtlEinheiten(einheit);
            pos.setAnalyseVon(analysevon);

//          getList().add(pos);
            List<AtlAnalyseposition> list = (List<AtlAnalyseposition>) getList();
            list.add(pos);

            fireTableDataChanged();
        }

        /**
         * Diese Methode prüft, ob ein Parameter bereits zur Prüfung vorgemerkt
         * ist - also bereits im ParameterModel enthalten ist.
         * @param newParam Ein neu zu probender Parameter.
         * @return true, wenn der Parameter bereits im Model enthalten ist,
         *         andernfalls false.
         */
        public boolean isParameterAlreadyThere(AtlParameter newParam) {
            List<?> data = getList();
            int size = data.size();

            String newOrdnungsbegriff = newParam.getOrdnungsbegriff();

            for (int i = 0; i < size; i++) {
                AtlAnalyseposition pos = (AtlAnalyseposition) data.get(i);
                AtlParameter param = pos.getAtlParameter();

                if (param.getOrdnungsbegriff().equals(newOrdnungsbegriff)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean objectRemoved(Object objectAtRow) {
            AtlAnalyseposition tmp = (AtlAnalyseposition) objectAtRow;
            tmp.delete();

            return true;// probe.getAtlAnalysepositionen().remove(tmp);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> tmp;
            switch (columnIndex) {
                case 0:
                    tmp = AtlParameter.class;
                    break;

                case 2:
                    tmp = KommaDouble.class;
                    break;

                case 3:
                    tmp = AtlEinheiten.class;
                    break;

                case 5:
                    tmp = Double.class;
                    break;

                case 6:
                    tmp = String.class;
                    break;

                default:
                    tmp = super.getColumnClass(columnIndex);
                    break;
            }
            return tmp;
        }
    }

    private Dimension minimumSize;

    private JComboBox vorgangsstatusBox;
    private JButton statusHoch;
    private TextFieldDateChooser datum;
    private JFormattedTextField uhrzeitVon;
    private JFormattedTextField uhrzeitBis;
    private JFormattedTextField fahrtzeit;
    private JTextField bezug;
    private JTextField beteiligte;
    private JTextField probenummer;
    private JLabel rechnungsDatum;
    private JLabel rechnungsBetrag;
    private JTextArea bemerkungsArea;

    private JComboBox sachbearbeiterBox;
    private JButton bescheidDrucken;
    private JButton auftragDrucken;
    private JFileChooser dateiChooser;
    private JLabel betrieb;
    private JLabel entnahmepunkt;
    private DoubleField icpEinwaageFeld;
    private TextFieldDateChooser icpDatum;
    private JTable parameterTabelle;

    private JComboBox parameterBox;
    private JComboBox einheitenBox;
    private JComboBox analysevonBox;

    private ParameterModel parameterModel;
    private boolean isNew;
    private boolean isSchlamm;
    private boolean isSielhaut;

    public ProbenEditor(AtlProbenahmen probe, HauptFrame owner, boolean isNew) {
        super("Probenahme " + probe.getKennummer(), probe, owner);
        this.isNew = isNew;
        this.isSchlamm = false;
        this.isSielhaut = false;

        if (DatabaseQuery.isKlaerschlammProbe(probe)) {
            this.isSchlamm = true;
        }

        if (probe.getAtlProbepkt().getAtlProbeart().getId().equals(
            DatabaseConstants.ATL_PROBEART_ID_SIELHAUT)) {
            this.isSielhaut = true;
        }

        if (!isNew /*probe.isAnalysepositionenInitialized()*/) {
            // TODO: Here we want to get rid of getProbenahmeAndInit
            setEditedObject(AtlProbenahmen.findById(probe.getId()));
        }

        if (isNew) {
            this.sachbearbeiterBox.setSelectedItem(
                DatabaseQuery.getCurrentSachbearbeiter());
            this.uhrzeitVon.setText("");
            this.uhrzeitBis.setText("");
//            doSave();
        }

        this.parameterModel = new ParameterModel(getProbe(), isNew,
            this.isSchlamm, this.isSielhaut);
        this.parameterTabelle.setModel(this.parameterModel);

        initColumns();
    }

    /**
     * Diese Methode erstellt das {@link javax..swing.JPanel} mit
     * {@link javax.swing.JButton}s. Hier werden f&uuml;nf Kn&ouml;pfe
     * hinzugef&uuml;gt, die das Erstellt des Probenahmeauftrags und
     * Geb&uuml;hrenbescheids starten, sowie die Kn&ouml;pfe zum Speichern,
     * Abbrechen und zur Parameterauswahl.
     * @return ein {@link javax.swing.JPanel} mit {@link javax.swing.JButton}s.
     */
    @Override
    protected JPanel createButtonBar() {
        this.bescheidDrucken = new JButton("Bescheid erzeugen");
        this.auftragDrucken = new JButton("Auftrag erzeugen");

        // triggert das Erzeugen eines PDFs und einen Druck-Job an
        this.auftragDrucken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSave();

                AtlProbenahmen probe = getProbe();

                Map<String, Object> params = getAuftragDruckMap(probe);

                String basePath = SettingsManager.getInstance().getSetting(
                    "auik.probenahme.auftraege");

                String filename = probe.getKennummer();
                filename = filename.replace(" ", "");
                if (!filename.endsWith(".pdf")) {
                    filename += ".pdf";
                }

                filename = filename.replace("/", "_");

                File path = new File(basePath, filename);
                // TODO: Check this: (path == null) never happens
//                if (path == null) {
//                    frame.showErrorMessage(
//                        "Kann die Datei nicht speichern, da der Pfad nicht " +
//                        "korrekt ist.",
//                        "Pfad zum Speichern fehlt");
//                    return;
//                }

                params.put("localFile", path.getAbsolutePath());

                try {
                    JRDataSource subdata = DatabaseQuery
                        .getAuftragDataSource(probe);

                    log.debug("Fülle Probenahmeauftrag mit "
                        + ((JRMapDataSource) subdata).size() + " Zeilen.");

                    PDFExporter.getInstance().exportAuftrag(params, subdata,
                        path.getAbsolutePath(), true);

                    updateVorgangsstatus(
                        DatabaseConstants.ATL_STATUS_PROBENAHMEAUFTRAG_GEDRUCKT);
                    probe.setAtlStatus(
                        DatabaseConstants.ATL_STATUS_PROBENAHMEAUFTRAG_GEDRUCKT);

                    probe.merge();

                    GUIManager.getInstance().showInfoMessage(
                        "Der Probenahmeauftrag wurde erfolgreich unter '"
                            + path.getAbsolutePath() + "' gespeichert.",
                        "Probenahmeauftrag erfolgreich");
                    
                    close();
                    
                } catch (Exception ex) {
                    log.error("Druck schlug fehlt: " + ex.getMessage());
                    GUIManager.getInstance().showErrorMessage(
                        "Der Druck des Probenahmeauftrags ist fehlgeschlagen."
                            + "\n" + ex.getLocalizedMessage(),
                        "Probenahmeauftrag-Druck fehlgeschlagen");
                }
            }
        });

        // trigger das Erzeugen eines PDFs und einen Druck-Job an
        this.bescheidDrucken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtlProbenahmen probe = getProbe();

                String basePath = SettingsManager.getInstance().getSetting(
                    "auik.probenahme.bescheide");

                String filename = probe.getKennummer();
                String vFilename = filename;

                filename = filename.replace(" ", "");
                if (!filename.endsWith(".pdf")) {
                    filename += ".pdf";
                    vFilename += "-vfg.pdf";
                } else {
                    vFilename = vFilename.substring(0, vFilename.length() - 5);
                    vFilename += "-vfg.pdf";
                }
                filename = filename.replace("/", "_");
                vFilename = vFilename.replace("/", "_");

                File path = new File(basePath, filename);
                // TODO: Check this: (path == null) never happens
//                if (path == null) {
//                    frame.showErrorMessage(
//                        "Kann die Datei nicht speichern, da der Pfad nicht " +
//                        "korrekt ist.",
//                        "Pfad zum Speichern fehlt");
//                    return;
//                }

                File vPath = new File(basePath, vFilename);

                try {
                    updateRechnungsdatum(probe);

                    doSave();

                    updateRechnungsbetrag(probe);

                    Map<String, Object> params = getBescheidDruckMap(probe);

                    JRDataSource subdata = DatabaseQuery
                        .getBescheidDataSource(probe);

                    PDFExporter.getInstance().exportBescheid(params, subdata,
                        PDFExporter.BESCHEID, path.getAbsolutePath(), true);

                    JRDataSource vSubdata = DatabaseQuery
                        .getBescheidDataSource(probe);

                    PDFExporter.getInstance().exportBescheid(params, vSubdata,
                        PDFExporter.VFG, vPath.getAbsolutePath(), true);

                    if (!(getVorgangsstatus().equals(
                        DatabaseConstants.ATL_STATUS_BESCHEID_GEDRUCKT))) {
                        // Diese Datei soll nur 1x erzeugt werden. Nachdem der
                        // Status auf "Bescheid gedruckt" erhöht wurde, kann
                        // zwar der Bescheid nochmals gedruckt werden, jedoch
                        // wird keine neue kasse.txt angelegt.
                        log.debug("Erstelle kasse.txt für Gebührenbescheid.");
                        try {
                            createKasseFile(path.getAbsolutePath());
                        } catch (ParseException pe) {
                            pe.printStackTrace();
                            GUIManager
                                .getInstance()
                                .showErrorMessage(
                                    "Der Druck des Gebührenbescheids ist fehlgeschlagen."
                                        + "Die Datei kasse.txt konnte nicht erstellt werden.",
                                    "Gebührenbescheid-Druck fehlgeschlagen");

                            return;
                        }
                    }

                    updateVorgangsstatus(
                        DatabaseConstants.ATL_STATUS_BESCHEID_GEDRUCKT);

                    probe.setAtlStatus(
                        DatabaseConstants.ATL_STATUS_BESCHEID_GEDRUCKT);

                    probe.merge();

                    GUIManager.getInstance().showInfoMessage(
                        "Der Gebührenbescheid wurde erfolgreich unter ' "
                            + path.getAbsolutePath() + "' gespeichert.",
                        "Gebührenbescheid erfolgreich");
                } catch (Exception ex) {
                    log.error("Druck schlug fehlt.");

                    ex.printStackTrace();

                    GUIManager.getInstance().showErrorMessage(
                        "Der Druck des Gebührenbescheids ist fehlgeschlagen."
                            + "\n" + ex.getLocalizedMessage(),
                        "Gebührenbescheid-Druck fehlgeschlagen");
                }
            }
        });

        return ButtonBarFactory.buildRightAlignedBar(new JButton[] {
                this.button1, this.button2, this.button3, this.auftragDrucken,
                this.bescheidDrucken}, true);
    }

    @Override
    protected JComponent buildContentArea() {
//        NumberFormat     nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");

        this.entnahmepunkt = new JLabel();
        this.datum = new TextFieldDateChooser();
        this.rechnungsDatum = new JLabel();
        this.uhrzeitVon = new JFormattedTextField(f);
        this.uhrzeitBis = new JFormattedTextField(f);
        this.fahrtzeit = new JFormattedTextField(f);
        this.rechnungsBetrag = new JLabel();
        this.bezug = new JTextField();
        this.beteiligte = new JTextField();
        this.probenummer = new JTextField();
        this.vorgangsstatusBox = new JComboBox();
        this.statusHoch = new JButton("erhöhen");
        this.sachbearbeiterBox = new JComboBox();
        this.icpEinwaageFeld = new DoubleField(0);
        this.icpDatum = new TextFieldDateChooser();
        this.bemerkungsArea = new LimitedTextArea(255);
        this.betrieb = new JLabel();
        this.parameterTabelle = new SelectTable();

        this.vorgangsstatusBox.setModel(
            new DefaultComboBoxModel(DatabaseQuery.getStatus()));

        this.sachbearbeiterBox.setModel(new DefaultComboBoxModel(
            DatabaseQuery.getEnabledSachbearbeiter()));
        this.sachbearbeiterBox.setEditable(true);

        this.statusHoch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVorgangsstatus(
                    DatabaseQuery.getNextStatus(getVorgangsstatus()));
            }
        });

        this.bemerkungsArea.setLineWrap(true);
        this.bemerkungsArea.setWrapStyleWord(true);

        JScrollPane bemerkungsScroller = new JScrollPane(this.bemerkungsArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bemerkungsScroller.setPreferredSize(new Dimension(0, 50));

        this.parameterTabelle.setRowHeight(20);

        Action aposRemoveAction = new AbstractAction("Analyseposition löschen") {
            private static final long serialVersionUID = -5755536713201543469L;

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ProbenEditor.this.parameterTabelle.getSelectedRow();
                if (row != -1
                    && ProbenEditor.this.parameterTabelle.getEditingRow() == -1) {
                    ProbenEditor.this.parameterModel.removeRow(row);
                }
            }
        };

        KeyStroke deleteKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,
            0, false);

        aposRemoveAction.putValue(Action.ACCELERATOR_KEY, deleteKeyStroke);

        this.parameterTabelle.getInputMap().put(deleteKeyStroke,
            aposRemoveAction.getValue(Action.NAME));

        this.parameterTabelle.getActionMap().put(
            aposRemoveAction.getValue(Action.NAME), aposRemoveAction);

        JScrollPane parameterScroller = new JScrollPane(this.parameterTabelle,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        FormLayout layout = new FormLayout(
            "70dlu, 60dlu, 40dlu, 5dlu, 30dlu, 5dlu, 60dlu, 5dlu, 30dlu, 50dlu, 5dlu, 50dlu",
            "pref, 8dlu, pref, 8dlu, pref, 8dlu, pref, 8dlu, pref, 8dlu,"
                + "pref, 8dlu, pref, 8dlu, pref, 8dlu, "
                + "pref, 16dlu,pref, 16dlu, pref, 16dlu, pref, 8dlu, 250dlu");

        PanelBuilder builder = new PanelBuilder(layout);
        CellConstraints cc = new CellConstraints();

        int row = 1;
        builder.addSeparator("Probe", cc.xyw(1, row, 12));

        row += 2;
        builder.addLabel("Probenummer:", cc.xyw(1, row, 1));
        builder.add(this.probenummer, cc.xyw(2, row, 4));

        row += 2;
        builder.add(new JLabel("Vorgangsstatus:"), cc.xyw(1, row, 1));
        builder.add(this.vorgangsstatusBox, cc.xyw(2, row, 4));
        builder.addLabel("", cc.xyw(1, row, 1));
        builder.add(this.statusHoch, cc.xyw(7, row, 1));

        row += 2;
        builder.addLabel("Sachbearbeiter:", cc.xyw(1, row, 1));
        builder.add(this.sachbearbeiterBox, cc.xyw(2, row, 4));

        row += 2;
        builder.addLabel("Name des Betriebs:", cc.xyw(1, row, 1));
        builder.add(this.betrieb, cc.xyw(2, row, 8));

        row += 2;
        builder.addLabel("Entnahmepunkt:", cc.xyw(1, row, 1));
        builder.add(this.entnahmepunkt, cc.xyw(2, row, 8));

        row += 2;
        builder.add(new JLabel("Datum:"), cc.xyw(1, row, 1));
        builder.add(this.datum, cc.xyw(2, row, 1));
        builder.addLabel("von:",
            cc.xyw(3, row, 1, CellConstraints.RIGHT, CellConstraints.CENTER));
        builder.addLabel("", cc.xyw(4, row, 1)); // just to create a small gap
        builder.add(this.uhrzeitVon, cc.xyw(5, row, 1));
        builder.addLabel("", cc.xyw(6, row, 1));
        builder.addLabel("bis:",
            cc.xyw(7, row, 1, CellConstraints.RIGHT, CellConstraints.CENTER));
        builder.addLabel("", cc.xyw(8, row, 1)); // just to create a small gap
        builder.add(this.uhrzeitBis, cc.xyw(9, row, 1));
        builder.addLabel("Fahrtzeit:",
            cc.xyw(10, row, 1, CellConstraints.RIGHT, CellConstraints.CENTER));
        builder.addLabel("", cc.xyw(11, row, 1)); // just to create a small gap
        builder.add(this.fahrtzeit, cc.xyw(12, row, 1));

        row += 2;
        builder.addLabel("Bezug:", cc.xyw(1, row, 1));
        builder.add(this.bezug, cc.xyw(2, row, 4));
        builder.addLabel("", cc.xyw(6, row, 1));
        builder.addLabel("Beteiligte:",
            cc.xyw(7, row, 1, CellConstraints.RIGHT, CellConstraints.CENTER));
        builder.addLabel("", cc.xyw(8, row, 1)); // just to create a small gap
        builder.add(this.beteiligte, cc.xyw(9, row, 1));

        row += 2;
        builder.addLabel("Rechnungsdatum:", cc.xyw(1, row, 1));
        builder.add(this.rechnungsDatum, cc.xyw(2, row, 2));
        builder.addLabel("Rechnungsbetrag:",
            cc.xyw(4, row, 4, CellConstraints.RIGHT, CellConstraints.CENTER));
        builder.addLabel("", cc.xyw(8, row, 1)); // just to create a small gap
        builder.add(this.rechnungsBetrag, cc.xyw(9, row, 1));

        row += 2;
        builder.addSeparator("Bemerkung", cc.xyw(1, row, 12));

        row += 2;
        builder.add(bemerkungsScroller, cc.xyw(1, row, 12));

        row += 2;
        builder.addSeparator("Parameter", cc.xyw(1, row, 12));

        row += 2;
        builder.add(parameterScroller, cc.xyw(1, row, 12));

        return builder.getPanel();
    }

    /**
     * Diese Methode &ouml;ffnet einen Dateidialog. Falls eine Datei ausgew
     */
    protected void openFileChooser(JTextField datei) {
        this.dateiChooser.showSaveDialog(this);

        File file = this.dateiChooser.getSelectedFile();

        if (file != null) {
            log.debug("Speichere Datei unter: " + file.getAbsolutePath());

            datei.setText(file.getAbsolutePath());
        }
    }

    /**
     * Diese Methode erzeugt neben dem PDF des Geb&uuml;hrenbescheids eine Datei
     * namens kasse.txt, die Informationen &uuml;ber den Betreiber sowie die
     * H&ouml;he des Rechnungsbetrags und des Rechnungsdatums enth&auml;lt. Eine
     * Zeile in dieser Datei entspricht einem Bescheid und hat folgendes Format:
     * Feldname Länge Kassenzeichen 12 ohne Punkte Ansprechpartner Name 28
     * Ansprechpartner Vorname 28 Ansprechpartner Straße, Hausnummer 28 PLZ 05
     * Ort 23 Kommentar 28 Fälligkeitsdatum 08 Betrag 11 ohne Tausender oder
     * Cent Trennzeichen mit führenden Nullen
     * @param bescheid Der Pfad, an dem das PDF gespeichert wurde.
     */
    protected void createKasseFile(String bescheid) throws ParseException {
        File path = new File(bescheid).getParentFile();
        File kasse = new File(path, KASSE_FILENAME);

        AtlProbenahmen probe = getProbe();

        BasisAdresse basisBetr =
            probe.getAtlProbepkt().getBasisObjekt().getBasisAdresse();

        Date rechnungsdatum = DateUtils.getDateOfBill(probe.getBescheid());
        CurrencyDouble cd = new CurrencyDouble(getRechnungsbetrag(probe),
            Locale.GERMANY);

        String kassenzeichen = basisBetr.getKassenzeichen().toString();
        kassenzeichen = kassenzeichen.replace(".", "");

        String rechnungsbetrag = cd.toString();
        rechnungsbetrag = rechnungsbetrag.replace("€", "");
        rechnungsbetrag = rechnungsbetrag.replace(",", "");
        rechnungsbetrag = rechnungsbetrag.trim();

        String kasseDatum = DateUtils.format(rechnungsdatum,
            DateUtils.FORMAT_KASSE);

        StringBuilder sb = new StringBuilder();

        int fill = ZIFFERN_RECHNUNGS_FELD;
        fill -= kasseDatum.length();
        fill -= rechnungsbetrag.length();

        sb.append(kassenzeichen);
        if (basisBetr.getBetrname().length() > 28) {
            sb.append(basisBetr.getBetrname().substring(0, 28));
        } else
            sb.append(basisBetr.getBetrname());

        for (int i = 1; i <= 28 - basisBetr.getBetrname().length(); i++) {
            sb.append(" ");
        }

        int anrede = 0;
        if (basisBetr.getBetranrede() != null) {
            sb.append(basisBetr.getBetranrede());
            anrede = basisBetr.getBetranrede().length();
        }

        for (int i = 1; i <= 28 - anrede; i++) {
            sb.append(" ");
        }

        String addr = DatabaseQuery.getBetriebsgrundstueck(basisBetr);
        if (addr.length()>28) {
        	addr = addr.substring(0, 28);
        }
        sb.append(addr);
        for (int i = 1; i <= 28 - addr.length(); i++) {
            sb.append(" ");
        }

        sb.append(basisBetr.getPlz().toString());
        sb.append(basisBetr.getOrt().toString());

        for (int i = 1; i <= 23 - basisBetr.getOrt().length(); i++) {
            sb.append(" ");
        }

        sb.append("Gebühr für Abwasserunters.  ");
        sb.append(kasseDatum);

        for (int i = 1; i <= fill; i++) {
            sb.append("0");
        }

        sb.append(rechnungsbetrag);

        String row = sb.toString();

        BufferedWriter writer = null;
        boolean exists = kasse.exists();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(kasse, true), "cp1252"));

            if (exists) {
                writer.newLine();
            }

            writer.write(row, 0, row.length());
            writer.flush();
        } catch (IOException ioe) {
            GUIManager.getInstance().showErrorMessage(
                ioe.getLocalizedMessage(), "Fehler");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ioe) { /* do nothing */
            }
        }
    }

    @Override
    protected void fillForm() {
//        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        this.minimumSize = new Dimension(this.getSize());

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) {
                ProbenEditor.this.setSize(Math.max(
                    ProbenEditor.this.minimumSize.width,
                    ProbenEditor.this.getWidth()), Math.max(
                    ProbenEditor.this.minimumSize.height,
                    ProbenEditor.this.getHeight()));
            }
        });

        AtlProbenahmen probe = getProbe();
        BasisAdresse basisBetr =
            probe.getAtlProbepkt().getBasisObjekt().getBasisAdresse();

        this.probenummer.setText(probe.getKennummer());
        this.probenummer.setEnabled(false);
        this.entnahmepunkt.setText(probe.getAtlProbepkt().getBasisObjekt()
            .getBeschreibung());
        Date entnahmeDatum = probe.getDatumDerEntnahme();
        this.datum.setDate(entnahmeDatum);

        if (probe.getUhrzeitbeginn() != null) {
            this.uhrzeitVon.setText(probe.getUhrzeitbeginn());
        } else {
            this.uhrzeitVon.setText("00:00");
        }

        if (probe.getUhrzeitende() != null) {
            this.uhrzeitBis.setText(probe.getUhrzeitende());
        } else {
            this.uhrzeitBis.setText("00:00");
        }

        if (probe.getFahrtzeit() != null) {
            this.fahrtzeit.setText(probe.getFahrtzeit());
        } else {
            this.fahrtzeit.setText("01:00");
        }

        if (basisBetr != null) {
            String name = basisBetr.getBetrname();
            String addr = DatabaseQuery.getBetriebsgrundstueck(basisBetr);

            StringBuilder sb = new StringBuilder();

            if (name != null) {
                sb.append(name);
            }

            if (addr != null) {
                sb.append(", ");
                sb.append(addr);
            }

            this.betrieb.setText(sb.toString());
        }

        if (probe.getAnzahlbeteiligte() != null) {
            this.beteiligte.setText(Integer.toString(probe
                .getAnzahlbeteiligte()));
        } else {
            this.beteiligte.setText("1");
        }

        Date bescheid = probe.getBescheid();
        if (bescheid != null) {
            this.rechnungsDatum.setText(DateUtils.format(bescheid,
                DateUtils.FORMAT_DATE));
        }

        // For some reason, there occur a NullPointerException when creating a
        // new AtlProbenahmen.
        try {
            double kosten = getProbe().getKosten();
            CurrencyDouble cd = new CurrencyDouble(kosten, Locale.GERMANY);
            this.rechnungsBetrag.setText(cd.toString());
        } catch (NullPointerException npe) {
            // do nothing
        }

        // TODO Datei

        fillVorgangsstatus();

        if (DatabaseQuery.isKlaerschlammProbe(getProbe())) {
            this.icpEinwaageFeld.setValue(getProbe().getEinwaage());
        } else {
            this.icpEinwaageFeld.setEditable(false);
            this.icpEinwaageFeld.setEnabled(false);
        }
        Date icpDate = getProbe().getDatumIcp();
        this.icpDatum.setDate(icpDate);

        this.bemerkungsArea.setText(getProbe().getBemerkung());
        this.sachbearbeiterBox.setSelectedItem(probe.getBasisSachbearbeiter());
    }

    /** Initialisiert die Spalten der Analysepositionen-Tabelle */
    private void initColumns() {

        // Messwert... (alle Doubles)
        this.parameterTabelle.setDefaultRenderer(Double.class,
            new DoubleRenderer());
        this.parameterTabelle.setDefaultRenderer(KommaDouble.class,
            new DoubleRenderer());

        // Parameter
        TableColumn parameterColumn = this.parameterTabelle.getColumnModel()
            .getColumn(0);
        parameterColumn.setPreferredWidth(150);

        AtlParameter[] parameter = DatabaseQuery.getGroupedParameter();

        this.parameterBox = new JComboBox(parameter);
        this.parameterBox.setEditable(false);
        // Funktioniert leider beides nicht, geht evtl.
        // mit ComboBoxCelleditor und Java 1.5
        // parameterBox.setKeySelectionManager(new MyKeySelectionManager());
        // AutoCompletion.enable(parameterBox);
        // parameterBox.setBorder(BorderFactory.createEmptyBorder());
        this.parameterBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ProbenEditor.this.parameterBox.showPopup();
            }
        });

        parameterColumn.setCellEditor(new DefaultCellEditor(this.parameterBox));
        parameterColumn.setCellRenderer(new ComboBoxRenderer());

        // Einheit
        TableColumn einheitenColumn = this.parameterTabelle.getColumnModel()
            .getColumn(3);
        einheitenColumn.setPreferredWidth(100);

//        AtlEinheiten[] einheiten = AtlEinheiten.getEinheiten();

//        this.einheitenBox = new JComboBox(einheiten);
        this.einheitenBox = new JComboBox(DatabaseQuery.getAtlEinheiten());
        this.einheitenBox.setEditable(false);
        this.einheitenBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ProbenEditor.this.einheitenBox.showPopup();
            }
        });
        this.einheitenBox.setBorder(BorderFactory.createEmptyBorder());

        einheitenColumn.setCellEditor(new DefaultCellEditor(this.einheitenBox));
        einheitenColumn.setCellRenderer(new ComboBoxRenderer());

        // Analyse von
        TableColumn analyseColumn = this.parameterTabelle.getColumnModel()
            .getColumn(4);
        analyseColumn.setPreferredWidth(100);

        String[] analyse_von_auswahl = {"700.44", "360.33", "AGROLAB", "HBICON",
                "Schwarze vdH", "Dr. Kludas", "Fresenius"};

        this.analysevonBox = new JComboBox(analyse_von_auswahl);
        this.analysevonBox.setEditable(true);
        this.analysevonBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ProbenEditor.this.analysevonBox.showPopup();
            }
        });
        this.analysevonBox.setBorder(BorderFactory.createEmptyBorder());

        analyseColumn.setCellEditor(new DefaultCellEditor(this.analysevonBox));
        analyseColumn.setCellRenderer(new ComboBoxRenderer());

        // Normwert
        TableColumn normwertColumn = this.parameterTabelle.getColumnModel()
            .getColumn(6);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.TRAILING);
        normwertColumn.setCellRenderer(renderer);
    }

    /**
     * Diese Methode setzt den initialen Wert der Combobox des Parameters
     * <i>Vorgangsstatus</i>. Handelt es sich bei der aktuellen Ansicht um eine
     * neue Probenahme, ist der initiale Wert <i>erstellt</i>, ansonsten wird
     * der Status ausgew&auml;hlt, der am {@link AtlProbenahmen} Objekt
     * gespeichert ist.
     */
    protected void fillVorgangsstatus() {
        AtlProbenahmen probe = getProbe();

        if (probe == null || probe.getAtlStatus() == null)
            return;

        AtlStatus status = probe.getAtlStatus();
        log.debug("Aktueller Status: " + status.getBezeichnung());

        updateVorgangsstatus(status);
    }

    protected AtlStatus getVorgangsstatus() {
        return (AtlStatus) this.vorgangsstatusBox.getSelectedItem();
    }

    protected BasisSachbearbeiter getSachbearbeiter() {
        ComboBoxModel model = this.sachbearbeiterBox.getModel();

        return (BasisSachbearbeiter) model.getSelectedItem();
    }

    protected void updateVorgangsstatus(AtlStatus newStatus) {
        this.vorgangsstatusBox.setSelectedItem(newStatus);
    }

    @Override
    protected boolean canSave() {
        return true;
    }

    @Override
    public boolean doSave() {
        log.debug("Speichere Probenahmedetails");

        AtlProbenahmen probe = getProbe();

        // Vorgangsstatus
        probe.setAtlStatus((AtlStatus) this.vorgangsstatusBox.getSelectedItem());

        // Von
        // TODO: This does not seem to make sense...
//        String uhrzeitVonVal = uhrzeitVon.getText();
//        if (probe.getUhrzeitbeginn() != null || probe.getUhrzeitbeginn() != "") {
//            probe.setUhrzeitbeginn(uhrzeitVonVal);
//        }
//        else {
//        	uhrzeitVonVal = "00:00";
//        	probe.setUhrzeitbeginn(uhrzeitVonVal);
//        }
        String uhrzeitVonVal = this.uhrzeitVon.getText();
        if (uhrzeitVonVal == null || uhrzeitVonVal.equals("")) {
            uhrzeitVonVal = "00:00";
        }
        probe.setUhrzeitbeginn(uhrzeitVonVal);

        // Bis
        String uhrzeitBisVal = this.uhrzeitBis.getText();
        if (uhrzeitBisVal != null) {
            probe.setUhrzeitende(uhrzeitBisVal);
        }

        // Datum der Entnahme
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String datumVal = df.format(this.datum.getDate());
        String timestring = (String) datumVal.subSequence(0, 11) + " "
            + uhrzeitVonVal;
        Date convertedDate = new Date();
        try {
            convertedDate = df.parse(timestring);
            probe.setDatumDerEntnahme(new Timestamp(convertedDate.getTime()));
        } catch (ParseException e) {
            log.error("Fehler beim Speichern von 'datumDerEntnahme'.");
        }

        // Fahrtzeit
        String fahrtzeitVal = this.fahrtzeit.getText();
        if (fahrtzeitVal != null) {
            probe.setFahrtzeit(fahrtzeitVal);
        }

        // Beteiligte
        try {
            int anzahl = Integer.parseInt(this.beteiligte.getText());
            probe.setAnzahlbeteiligte(anzahl);
        } catch (NumberFormatException nfe) {
            log.error("Fehler beim Speichern von 'beteiligte'.");
        }

        // Sachbearbeiter
        BasisSachbearbeiter b = (BasisSachbearbeiter) this.sachbearbeiterBox
            .getSelectedItem();
        if (b != null) {
            probe.setBasisSachbearbeiter(b);
        }

        // Kennnummer
        String kennnummer = this.probenummer.getText();
        if (kennnummer != null) {
            probe.setKennummer(kennnummer);
        }

        // Bemerkung
        String newBemerkung = this.bemerkungsArea.getText();
        if (newBemerkung != null) {
            newBemerkung = newBemerkung.trim();
        }

        if (!"".equals(newBemerkung)) {
            probe.setBemerkung(newBemerkung);
        } else {
            probe.setBemerkung(null);
        }

        boolean success = true;

        probe = AtlProbenahmen.merge(probe);
        setProbe(probe);
        success = (probe != null);
        if (this.isNew) {
            this.isNew = false;
        }

        // Analysepositionen
//        Set<AtlAnalyseposition> newPositionen = new HashSet<AtlAnalyseposition>(
//            this.parameterModel.getList());
//        getProbe().getAtlAnalysepositionen().clear();
//        getProbe().getAtlAnalysepositionen().addAll(newPositionen);
//        // getProbe().setAtlAnalysepositionen(newPositionen);
//        log.debug("Analysepositionen geändert: "
//            + getProbe().getAtlAnalysepositionen());
        List<?> objects = this.parameterModel.getList();
        AtlAnalyseposition position;
        for (Object object : objects) {
            position = (AtlAnalyseposition) object;
            position.setAtlProbenahmen(probe);
            if (position.getAtlParameter().getSielhautGw() != null) {
            	position.setNormwert(position.getWert()/position.getAtlParameter().getSielhautGw());
            }            
            success = success && position.merge();
        }

        return success;
    }

    /**
     * Diese Methode liefert die Parameter-Map für den Druck/Export eines
     * Probenahmeauftrages.
     * @return die Variablen für den Probenahmeauftrag als Map.
     */
    public Map<String, Object> getAuftragDruckMap(AtlProbenahmen probe) {
        BasisAdresse betr = probe.getAtlProbepkt().getBasisObjekt()
            .getBasisAdresse();
        BasisAdresse std = probe.getAtlProbepkt().getBasisObjekt()
            .getBasisStandort();
        AtlProbeart art = probe.getAtlProbepkt().getAtlProbeart();

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("kennnummer", this.probenummer.getText());
        params.put("name", betr.toString());
        params.put("art", art.getArt());
		if (std.getHausnrzus() != null) {
			params.put(
					"betriebsgrundstueck",
					std.getStrasse() + " " + std.getHausnr()
							+ betr.getHausnrzus());
		} else {
			params.put("betriebsgrundstueck",
					std.getStrasse() + " " + std.getHausnr());
		}
        try {
            Integer anzahl = Integer.parseInt(this.beteiligte.getText());
            params.put("anzahlMitarbeiter", anzahl.toString());
        } catch (NumberFormatException nfe) {
            // do nothing
        }

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        params.put("entnahmeDatum", df.format(this.datum.getDate()));
        params.put("beginn", this.uhrzeitVon.getText());
        params.put("ende", this.uhrzeitBis.getText());
        params.put("fahrtzeit", this.fahrtzeit.getText());
        params.put("entnahmestelle", this.entnahmepunkt.getText());
        params.put("bemerkungen", this.bemerkungsArea.getText());

        BasisSachbearbeiter sb = (BasisSachbearbeiter) this.sachbearbeiterBox
            .getSelectedItem();

        StringBuilder info = new StringBuilder();
        if (sb != null) {
            info.append(sb.getName());
            info.append(", ");
            info.append(sb.getGehoertzuarbeitsgr());
            info.append(", ");
            info.append("0521/51-" + sb.getTelefon());
        }
        params.put("sachbearbeiterInfo", info.toString());

        // TODO fill in the correct values if they exist
        params.put("anzahlEntnahmestellen", "1");

        params.put("branche", probe.getAtlProbepkt().getBranche());

        return params;
    }

    /**
     * Diese Methode liefert eine Map, mit allen Variablen, die für den
     * Druck/Export des Geb&uuml;hrenbescheid notwendig sind.
     * @return die Variablen des Geb&uuml;hrenbescheids als Map.
     */
    public Map<String, Object> getBescheidDruckMap(AtlProbenahmen probe)
        throws IllegalArgumentException {
        BasisAdresse betr =
            probe.getAtlProbepkt().getBasisObjekt().getBasisAdresse();
        BasisAdresse basisStandort =
            probe.getAtlProbepkt().getBasisObjekt().getBasisStandort();
        BasisLage basisLage =
                probe.getAtlProbepkt().getBasisObjekt().getBasisLage();

        HashMap<String, Object> params = new HashMap<String, Object>();

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        String entnahmedatum = DateUtils.format(this.datum.getDate(),
            DateUtils.FORMAT_DATE);
        String entnahmezeit = DateUtils.format(this.datum.getDate(),
            DateUtils.FORMAT_TIME);

        String entnahmezeitpunkt = entnahmedatum + ", " + entnahmezeit + " Uhr";

        Date now = new Date();
        params.put("datum", DateUtils.format(now, DateUtils.FORMAT_DATE));
        params.put("entnahmedatum", entnahmezeitpunkt);
        params.put("entnahmeort", basisStandort.toString());//basisStandort.toString());
        params.put("entnahmestelle", probe.getAtlProbepkt().getBasisObjekt()
            .getBeschreibung());
        params.put("entnahmestellen", "1");
        params.put("maxdatum", DateUtils.format(DateUtils.getDateOfBill(now),
            DateUtils.FORMAT_DATE));
        params.put("kosten",
            Double.toString(PERSONAL_UND_SACHKOSTEN/100).replace(".", ","));
        params.put("kassenzeichen", betr.getKassenzeichen());
        params.put("firmaAnrede", betr.getBetranrede());
        if (betr.getBetrvorname() != null)
            params.put("firmaName",
                betr.getBetrvorname() + " " + betr.getBetrname());
        else
            params.put("firmaName", betr.getBetrname());
        params.put("firmaNameZus", betr.getBetrnamezus());
        params.put("firmaStrasse", DatabaseQuery.getBetriebsgrundstueck(betr));
        params.put("firmaOrt", betr.getPlz() + " " + betr.getOrt());

        try {
            Integer anzahl = Integer.parseInt(this.beteiligte.getText());
            params.put("probenehmer", anzahl.toString());
        } catch (NumberFormatException nfe) {
            params.put("probenehmer", "1");
        }

        try {
            String beginn = this.uhrzeitVon.getText();
            String ende = this.uhrzeitBis.getText();
            String fahrt = this.fahrtzeit.getText();

            Date beginnDate = DateUtils.parse(beginn, DateUtils.FORMAT_TIME);
            Date fahrtDate = DateUtils.parse(fahrt, DateUtils.FORMAT_TIME);
            Date endeDate = DateUtils.parse(ende, DateUtils.FORMAT_TIME);
            String mitFahrt = DateUtils.getAddition(endeDate, fahrtDate);
            Date mitFahrtDate = DateUtils
                .parse(mitFahrt, DateUtils.FORMAT_TIME);

            String dauer = DateUtils.getDuration(beginnDate, mitFahrtDate);
            double kosten = Math.round((getSachUndPersonalkosten()) * 100) / 100.0;
            double gesamt = Math
                .round((kosten + getAnalysekosten(probe)) * 100) / 100.0;

            params.put("personalsachkosten", nf.format(kosten) + " €");
            params.put("analysekosten", nf.format(getAnalysekosten(probe))
                + " €");
            params.put("gesamtkosten", nf.format(gesamt) + " €");

            params.put("dauer", dauer);
        } catch (ParseException pe) {
            params.put("dauer", "hh:mm");
            params.put("gesamtkosten", "xx,xx");
        }

        return params;
    }

    /**
     * Diese Funktion berechnet die Dauer der Probenahme anhand Start- und
     * Endzeit.
     */
    protected double getDauer() throws ParseException {
        String beginn = this.uhrzeitVon.getText();
        String ende = this.uhrzeitBis.getText();
        String fahrt = this.fahrtzeit.getText();

        Date beginnDate = DateUtils.parse(beginn, DateUtils.FORMAT_TIME);
        Date fahrtDate = DateUtils.parse(fahrt, DateUtils.FORMAT_TIME);
        Date endeDate = DateUtils.parse(ende, DateUtils.FORMAT_TIME);
        String mitFahrt = DateUtils.getAddition(endeDate, fahrtDate);
        Date mitFahrtDate = DateUtils.parse(mitFahrt, DateUtils.FORMAT_TIME);

        return DateUtils.getDurationHours(beginnDate, mitFahrtDate);
    }

    /**
     * Diese Funktion liefert die Anzahl der beteiligten Probenehmer.
     */
    protected Integer getAnzahl() {
        Integer anzahl = new Integer(this.beteiligte.getText());

        return anzahl;
    }

    /**
     * Diese Methode liefert die Sach- und Personalkosten.
     * @return die Personal- und Sachkosten.
     */
    public double getSachUndPersonalkosten() throws ParseException {
    	double kosten = PERSONAL_UND_SACHKOSTEN * getDauer() * getAnzahl();
    	double round = Math.round(kosten);
    	return round/100;
    }

    /**
     * Diese Methode liefert die Analysekosten der <i>probe</i>.
     * @return die Analysekosten.
     */
    public double getAnalysekosten(AtlProbenahmen probe)
        throws IllegalArgumentException {
        List<AtlAnalyseposition> sorted =
            DatabaseQuery.getSortedAnalysepositionen(probe);
        HashMap<Integer, List<AtlParameter>> gruppen = new HashMap<Integer, List<AtlParameter>>();
        double single = 0d;
        double group = 0d;

        AtlAnalyseposition pos = null;
        AtlParameter para = null;
        AtlParametergruppen gruppe = null;
        for (int i = 0; i < sorted.size(); i++) {
            pos = sorted.get(i);
            para = pos.getAtlParameter();
            gruppe = para.getAtlParametergruppen();

            if (gruppe == null) {
                single += para.getPreisfueranalyse();
            } else {
                Integer id = gruppe.getId();

                if (gruppen.containsKey(id)) {
                    gruppen.get(id).add(para);
                } else {
                    List<AtlParameter> neu = new ArrayList<AtlParameter>();
                    neu.add(para);

                    gruppen.put(id, neu);
                }
            }
        }

        int anzahlGruppen = gruppen.size();
        if (anzahlGruppen == 0) {
            return single;
        }

        Set<Integer> keys = gruppen.keySet();
        Iterator<Integer> iter = keys.iterator();

        while (iter.hasNext()) {
            Integer id = iter.next();
            group += getGruppierteAnalysekosten(id, gruppen.get(id));
        }

        return single + group;
    }

    /**
     * Diese Methode errechnet den Preis einer Parametergruppe. Wenn alle
     * Parameter einer Parametergruppen in der Probenahme enthalten sind, wird
     * der entsprechende Gruppenpreis zur&uuml;ckgegeben. Sind nicht alle
     * Parameter enthalten, werden die Preise jedes Parameters addiert, und
     * dieser Wert zur&uuml;ckgegeben. Falls eine Gruppe jedoch nicht komplett
     * ist, aber die Parameter nicht einzeln gepr&uuml;ft werden k&ouml;nnen,
     * wird ein Fehler geworfen.
     * @param gruppe Die ID der Paramtergruppe
     * @param params Eine Liste, die die Parameter einer Gruppe enth&auml;lt
     * @return den Preis der Parameter.
     * @throws IllegalArgumentException
     */
    public double getGruppierteAnalysekosten(int gruppe,
        List<AtlParameter> params) throws IllegalArgumentException {
        double preis = 0d;

        if (DatabaseQuery.isCompleteParameterGroup(gruppe, params)) {
            AtlParametergruppen g = AtlParametergruppen.findById(gruppe);

            if (g == null) {
                log.debug("No such group with id: " + gruppe);
                return 0;
            }

            preis += g.getPreisfueranalyse();
        } else {
            int parameter = params.size();

            for (int i = 0; i < parameter; i++) {
                AtlParameter p = params.get(i);

                if (p.getEinzelnbeauftragbar()) {
                    preis += p.getPreisfueranalyse();
                } else {
                    String msg = "Parameter " + p.getOrdnungsbegriff()
                        + " ist nicht " + "einzeln prüfbar.";

                    log.error(msg);

                    throw new IllegalArgumentException(msg);
                }
            }
        }

        return preis;
    }

    /**
     * Dies Funktion liefert den Rechnungsbetrag der Probenhame bestehend aus
     * Sach- und Personalkosten und der Analysekosten.
     * @return den Rechnungsbetrag.
     */
    public double getRechnungsbetrag(AtlProbenahmen probe)
        throws ParseException, IllegalArgumentException {
        return Math.round(getSachUndPersonalkosten() * 100.) / 100.
            + Math.round(getAnalysekosten(probe) * 100.) / 100.;
    }

    /**
     * Diese Funktion berechnet den Rechnungsbetrag der <i>probe</i>, setzt den
     * Betrag am Objekt und aktualisiert die GUI.
     */
    protected void updateRechnungsbetrag(AtlProbenahmen probe)
        throws ParseException {
        double betrag = getRechnungsbetrag(probe);

        probe.setKosten(betrag);

        CurrencyDouble cd = new CurrencyDouble(betrag, Locale.GERMANY);
        this.rechnungsBetrag.setText(cd.toString());
    }

    /**
     * Diese Funktion berechnet das Rechnugnsdatum, setzt dies am AtlProbenahmen
     * Objekt und aktualisiert die GUI mit dem aktuellen Datum.
     */
    protected void updateRechnungsdatum(AtlProbenahmen probe) {
        Date now = new Date();
        // TODO: Check this: This variable was not used, but should it really
        // not?
//        Date datum = DateUtils.getDateOfBill(now);

        probe.setBescheid(now);

        this.rechnungsDatum.setText(DateUtils
            .format(now, DateUtils.FORMAT_DATE));
    }

    @Override
    protected void doApply() {
        ParameterChooser chooser = new ParameterChooser(this.frame);
        chooser.addOKListener(new OKListener() {
            @Override
            public void onOK(AtlParameter[] params) {
                for (AtlParameter param : params) {
                    ProbenEditor.this.parameterModel.addParameter(param);
                }
            }
        });
        chooser.setVisible(true);
    }

    public AtlProbenahmen getProbe() {
        return (AtlProbenahmen) getEditedObject();
    }

    public void setProbe(AtlProbenahmen probe) {
        setEditedObject(probe);
    }

}

class ParameterChooser extends OkCancelApplyDialog {
    private static final long serialVersionUID = -5057778595979307787L;

    private JTable ergebnisTabelle;

    private ParameterAuswahlModel parameterAuswahlModel;
    private AtlParameter chosenParameter = null;
    private ProbenEditor.OKListener oklistener;

    public ParameterChooser(HauptFrame owner) {
        super("Parameter auswählen", owner);

        this.parameterAuswahlModel = new ParameterAuswahlModel();
        getErgebnisTabelle().setModel(this.parameterAuswahlModel);
        this.ergebnisTabelle.setColumnSelectionInterval(0, 0);

        this.ergebnisTabelle.getColumnModel().getColumn(0)
            .setPreferredWidth(20);
        this.ergebnisTabelle.getColumnModel().getColumn(1)
            .setPreferredWidth(230);

        setResizable(true);

        this.parameterAuswahlModel.filterList();
        this.parameterAuswahlModel.fireTableDataChanged();
    }

    @Override
    public Action getSecondButtonAction() {
        return new AbstractAction("Alle Parameter zeigen") {
            private static final long serialVersionUID = 5342325510907705899L;

            @Override
            public void actionPerformed(ActionEvent e) {
                doApply();
            }
        };
    }

    @Override
    public Action getThirdButtonAction() {
        return new AbstractAction("Abbrechen") {
            private static final long serialVersionUID = -5702077878210981297L;

            @Override
            public void actionPerformed(ActionEvent e) {
                doCancel();
            }
        };
    }

    public void addOKListener(ProbenEditor.OKListener listener) {
        this.oklistener = listener;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.bielefeld.umweltamt.aui.utils.dialogbase.OkCancelDialog#doOk()
     */
    @Override
    protected void doOk() {
        AtlParameter[] selected = this.parameterAuswahlModel
            .getSelectedParameter();
        fireOKEvent(selected);

        dispose();
    }

    @Override
    protected void doApply() {

        this.parameterAuswahlModel.AlleParameter();
        this.parameterAuswahlModel.fireTableDataChanged();
    }

    protected void fireOKEvent(AtlParameter[] parameter) {
        if (this.oklistener == null) {
            return;
        }

        this.oklistener.onOK(parameter);
    }

    public AtlParameter getChosenParameter() {
        return this.chosenParameter;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * de.bielefeld.umweltamt.aui.utils.dialogbase.SimpleDialog#buildContentArea
     * ()
     */
    @Override
    protected JComponent buildContentArea() {
        JScrollPane tabellenScroller = new JScrollPane(getErgebnisTabelle(),
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        TabAction ta = new TabAction();
        ta.addComp(this.ergebnisTabelle);

        FormLayout layout = new FormLayout("180dlu:g, 3dlu, min(16dlu;p)", // spalten
            "20dlu, 3dlu, 300dlu:g"); // zeilen
        PanelBuilder builder = new PanelBuilder(layout);
        CellConstraints cc = new CellConstraints();

        builder.add(tabellenScroller, cc.xyw(1, 3, 3));

        return builder.getPanel();
    }

    private JTable getErgebnisTabelle() {
        if (this.ergebnisTabelle == null) {
            this.ergebnisTabelle = new SelectTable();

            Action submitAction = new AbstractAction("Auswählen") {
                private static final long serialVersionUID = -6645922378885851686L;

                @Override
                public void actionPerformed(ActionEvent e) {
                    doOk();
                }
            };
            submitAction.putValue(Action.ACCELERATOR_KEY,
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false));

            this.ergebnisTabelle.getInputMap().put(
                (KeyStroke) submitAction.getValue(Action.ACCELERATOR_KEY),
                submitAction.getValue(Action.NAME));
            this.ergebnisTabelle.getActionMap().put(
                submitAction.getValue(Action.NAME), submitAction);

            this.ergebnisTabelle.addFocusListener(TableFocusListener
                .getInstance());
            this.ergebnisTabelle.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if ((e.getClickCount() == 2) && (e.getButton() == 1)) {
                        // TODO: Check this: Nothing happens here
//                        Point origin = e.getPoint();
//                        int row = ergebnisTabelle.rowAtPoint(origin);
                    }
                }
            });

        }

        return this.ergebnisTabelle;
    }

}

class ParameterAuswahlModel extends ListTableModel {
    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();
    private static final long serialVersionUID = -502436804713980533L;
    protected boolean[] selection;

    public ParameterAuswahlModel() {
        super(new String[] {"wählen", "Parameter"}, false);
    }

    @Override
    public void setList(List<?> newList) {
        super.setList(newList);

        this.selection = new boolean[newList.size()];
        Arrays.fill(this.selection, false);
    }

    public AtlParameter[] getSelectedParameter() {
        List<AtlParameter> params = new ArrayList<AtlParameter>();
        List<?> data = getList();
        int rows = getRowCount();

        for (int idx = 0; idx < rows; idx++) {
            if (this.selection[idx]) {
                params.add((AtlParameter) data.get(idx));
            }
        }

        return params.toArray(new AtlParameter[params.size()]);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel#getColumnValue
     * (java.lang.Object, int)
     */
    @Override
    public Object getColumnValue(Object objectAtRow, int columnIndex) {
        // we don't need this method
        return null;
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (rowExists(row)) {
            if (col < this.columns.length) {

                switch (col) {
                    case 0:
                        return new Boolean(this.selection[row]);
                    case 1:
                        AtlParameter p = (AtlParameter) getObjectAtRow(row);
                        return p.getBezeichnung();
                    default:
                        return "FEHLER!";
                }
            }
        }

        return null;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        log.debug("ParameterAuswahlModel - setValueAt(" + row + ", " + col
            + ")");

        if (rowExists(row)) {
            if (col < this.columns.length) {
                switch (col) {
                    case 0:
                        boolean cur = this.selection[row];
                        this.selection[row] = cur ? false : true;
                }
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class;
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 0 ? true : false;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel#updateList
     * ()
     */
    @Override
    public void updateList() {
    }

    public void filterList() {
        setList(DatabaseQuery.getGroupedParameterAsList());
        log.debug("Suche nach '" + getList().size() + " Ergebnisse)");
    }

    public void AlleParameter() {
        setList(DatabaseQuery.getAllParameterAsList());
        log.debug("Suche nach '" + getList().size() + " Ergebnisse)");
    }
}
