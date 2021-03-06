/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import view.CityConnPanel;
import view.CityPanel;
import view.MainFrame;
import view.MapPanel;
import view.RoutePanel;

/**
 *
 * @author Krisztian
 */
public class Routes {

    private static final String frameTitle = "European flight routes";
    private static final Integer width = 800;
    private static final Integer height = 500;
    private static final Boolean resizable = false;
    private static final String tab1Title = "Flight routes";
    private static final String tab2Title = "Cities";
    private static final String tab3Title = "City Connections";


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setFrame();
    }

    public static void setFrame() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle(frameTitle);
        mainFrame.setSize(width, height);
        mainFrame.setResizable(resizable);
        mainFrame.getContentPane().setLayout(new GridLayout(1, 1));
        
        
        //Tab1
        JPanel tab1 = new JPanel(new BorderLayout());
        RoutePanel rPanel = new RoutePanel();
        MapPanel mPanel = new MapPanel();
        rPanel.addListener(mPanel);
        tab1.add(rPanel,BorderLayout.WEST);
        tab1.add(mPanel,BorderLayout.EAST);
        
        
        //Tab2
        JPanel tab2 = new JPanel(new BorderLayout());
        CityPanel cPanel = new CityPanel();
        MapPanel mPanel2 = new MapPanel();
        mPanel2.addListener(cPanel);
        cPanel.addListener(mPanel2);
        tab2.add(cPanel,BorderLayout.WEST);
        tab2.add(mPanel2,BorderLayout.EAST);
        
        //Tab3
        JPanel tab3 = new JPanel(new BorderLayout());
        CityConnPanel ccPanel = new CityConnPanel();
        MapPanel mPanel3 = new MapPanel();
        ccPanel.addListener(mPanel3);
        tab3.add(ccPanel,BorderLayout.WEST);
        tab3.add(mPanel3,BorderLayout.EAST);
        
        
        JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
        tabPane.addTab(tab1Title, tab1);
        tabPane.addTab(tab2Title, tab2);
        tabPane.addTab(tab3Title, tab3);
        
        
        
               
        mainFrame.add(tabPane);
        mainFrame.setVisible(true);
    }

}
