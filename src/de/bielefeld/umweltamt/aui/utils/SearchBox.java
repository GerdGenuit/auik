/*
 * Created on 21.03.2005 by u633z
 */
package de.bielefeld.umweltamt.aui.utils;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 * Eine ComboBox mit automatischer Suche und Vervollständigung.
 * @author David Klotz
 */
public class SearchBox extends JComboBox {

    /**
     * Erleichterungs-Konstruktor, der eine leere JComboBox erzeugt.
     */
    public SearchBox() {
        this(new Object[]{});
    }

    /**
     * Erleichterungs-Konstruktor, der die gegebene Liste automatisch
     * in einen Array konvertiert.
     * @param list Eine Liste mit Objekten, die in dieser ComboBox angezeigt werden sollen
     */
    public SearchBox(final List list) {
        this(list.toArray());
    }

    /**
     * Erzeugt eine neue ComboBox mit automatischer Suche und Vervollständigung.
     * Das Popup dieser ComboBox kann dabei breiter sein, als die Box selbst.
     * @param items Ein Array mit Objekten, die in dieser ComboBox angezeigt werden sollen.
     */
    public SearchBox(Object[] items) {
        super(items);

        this.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuCanceled(PopupMenuEvent e) {}

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                Object comp = box.getUI().getAccessibleChild(box, 0);
                if (!(comp instanceof JPopupMenu)) return;
                JComponent scrollPane = (JComponent) ((JPopupMenu) comp).getComponent(0);

                // Variante Eins
                Dimension size = new Dimension();
                size.width = box.getPreferredSize().width;
                size.height = scrollPane.getPreferredSize().height;

                // Variante Zwei
                //Dimension size = scrollPane.getPreferredSize();
                //size.width = size.width * 2;

                scrollPane.setPreferredSize(size);

                //  following line for Tiger
                scrollPane.setMaximumSize(size);
            }
        });

        AutoCompletion.enable(this);
    }
}
