package org.jhotdraw.draw.text;

import static org.testng.Assert.*;

import org.jhotdraw.draw.figure.AbstractFigure;
import org.jhotdraw.draw.figure.AbstractFigureNGTest;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import  org.jhotdraw.draw.figure.TextHolderFigure;
import static org.junit.Assert.assertEquals;
import org.jhotdraw.draw.figure.TextHolderFigure;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Map;
import javax.swing.*;
import org.jhotdraw.draw.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.draw.event.FigureAdapter;
import org.jhotdraw.draw.event.FigureEvent;
import org.jhotdraw.draw.event.FigureListener;
import org.jhotdraw.draw.text.FloatingTextField;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;



public class FloatingTextFieldTest {

    private String testString = "test_string";

    public FloatingTextFieldTest() {

    }

    //Tests for setting the JtextField
    @Test
    public void testTextField() {
        FloatingTextField floatingTextField = new FloatingTextField();
        JTextField field = floatingTextField.getJTextField();

        //Make sure it exists
        assertNotNull(field);

        field.setText(testString);

        //Make sure text is correctly set
        assertEquals(testString, field.getText());

    }

    @Test
    public void testFloatingTextField() {
        throw new UnsupportedOperationException("Not supported yet. Too many dependencies to mock"); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void testFloatingTextFieldMethods() {
        throw new UnsupportedOperationException("Not supported yet. Too many dependencies to mock"); //To change body of generated methods, choose Tools | Templates.
    }


    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

}
