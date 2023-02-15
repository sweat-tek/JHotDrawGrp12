package org.jhotdraw.draw.tool;


import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.TextHolderFigure;
import org.jhotdraw.draw.text.FloatingTextField;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class TextEditingHandler extends AbstractTool implements ActionListener {

    private static final long serialVersionUID = 1L;
    private FloatingTextField textField;
    private TextHolderFigure typingTarget;

    public TextEditingHandler(TextHolderFigure typingTarget) {
        this.typingTarget = typingTarget;
        System.out.println("instantiated new editing tool");
    }

    public void beginEdit(TextHolderFigure textHolder) {
        if (textField == null) {
            System.out.println("New text field added");
            textField = new FloatingTextField();
            textField.addActionListener(this);
        }
        if (textHolder != typingTarget && typingTarget != null) {
            System.out.println("Ended edit");
            endEdit();
        }

        textField.createOverlay(getView(), textHolder);
        textField.requestFocus();
        typingTarget = textHolder;
    }

    public void endEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();
            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textField.getText();
            if (newText.length() > 0) {
                typingTarget.willChange();
                typingTarget.setText(newText);
                typingTarget.changed();
            }
            UndoableEdit edit = new AbstractUndoableEdit() {
                private static final long serialVersionUID = 1L;

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("attribute.text.text");
                }

                @Override
                public void undo() {
                    super.undo();
                    editedFigure.willChange();
                    editedFigure.setText(oldText);
                    editedFigure.changed();
                }

                @Override
                public void redo() {
                    super.redo();
                    editedFigure.willChange();
                    editedFigure.setText(newText);
                    editedFigure.changed();
                }
            };
            //getDrawing().fireUndoableEditHappened(edit);
            typingTarget.changed();
            typingTarget = null;
            textField.endOverlay();
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public boolean isEditing() {
        return typingTarget != null;
    }


    @Override
    public void updateCursor(DrawingView view, Point p) {
        if (view.isEnabled()) {
            view.setCursor(Cursor.getPredefinedCursor(isEditing() ? Cursor.DEFAULT_CURSOR : Cursor.CROSSHAIR_CURSOR));
        } else {
            view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
    }


}
