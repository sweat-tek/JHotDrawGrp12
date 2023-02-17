package org.jhotdraw.action.edit;

import org.jhotdraw.datatransfer.ClipboardUtil;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class deleteTest {
    public DeleteAction d;
    public JComponent t;

    @Before
    public void setUp() {
        d = new DeleteAction();
        t = new JComponent() {
        };
    }

    @Test
    public void testDelete() {
        assertNotNull(d);
        assertTrue(d instanceof AbstractAction);
    }

    @Test
    public void testActionPerformed() {
        d.actionPerformed(new ActionEvent(t, 0, ""));
        Transferable transferable = ClipboardUtil.getClipboard().getContents(null);
        assertNotNull(transferable);
        assertTrue(transferable.isDataFlavorSupported(DataFlavor.stringFlavor));
    }
}