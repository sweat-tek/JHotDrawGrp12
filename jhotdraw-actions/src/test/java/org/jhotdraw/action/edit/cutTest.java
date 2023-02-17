package org.jhotdraw.action.edit;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import org.jhotdraw.datatransfer.ClipboardUtil;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class cutTest {
    private CutAction c;
    private JComponent t;

    @Before
    public void setUp() {
        c = new CutAction();
        t = new JComponent() {
        };
    }

    @Test
    public void testCut() {
        // Test that the CutAction was constructed correctly
        assertNotNull(c);
        assertTrue(c instanceof AbstractSelectionAction);
    }

    @Test
    public void testActionPerformed() {
        // Test that the actionPerformed method works as expected
        c.actionPerformed(new ActionEvent(t, 0, ""));

        Transferable transferable = ClipboardUtil.getClipboard().getContents(null);
        assertNotNull(transferable);
        assertTrue(transferable.isDataFlavorSupported(DataFlavor.stringFlavor));
    }
}