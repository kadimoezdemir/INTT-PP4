/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steuerungslogik;

import datenlogik.Inventory;
import datenlogik.Products;
import geschaeftslogik.InventoryFacade;
import geschaeftslogik.ProductsFacade;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author chris
 */
@ManagedBean
public class ChartView implements Serializable {

    private PieChartModel pieModel;
    private BarChartModel barModel;
    private LineChartModel animatedModel;
    
    @EJB
    private ProductsFacade productFacade; 
    @EJB
    private InventoryFacade inventoryFacade;
    
    @PostConstruct
    public void init(){
        createPieModel();
        createBarModel();
        createAnimatedModel();
    }
    
    public PieChartModel getPieModel(){
        return pieModel;
    }
    
    public BarChartModel getBarModel(){
        return barModel;
    }
    
    // Anteil eines Produktes am Gesamtlagerbestand
    private void createPieModel(){
        pieModel = new PieChartModel();
        List<Products> inventoryList = productFacade.findAll();
        Iterator<Products> iterator = inventoryList.iterator();
        while(iterator.hasNext()){
            Products prod = (Products) iterator.next();
            pieModel.set(prod.getName(), getSelectedProductAmount(prod.getProductID()));
        }
        
        pieModel.setTitle("Anteile eines Produktes am Gesamtlagerbestand");
        pieModel.setLegendPosition("e");
        pieModel.setFill(true);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }
    
    private void createBarModel(){
        barModel = new BarChartModel();
        ChartSeries price = new ChartSeries();
        price.setLabel("Preis");
        ChartSeries cost = new ChartSeries();
        cost.setLabel("Kosten");  
        
        List<Products> inventoryList = productFacade.findAll();
        Iterator<Products> iterator = inventoryList.iterator();
        while(iterator.hasNext()){
            Products prod = (Products) iterator.next();
            price.set(prod.getName(), prod.getPrice());
            
            // Zufallesgenerator für Produktionskosten
            String randomNumber = "";
            Random randomGenerator = new Random();        
            for(int i=0; i<1; i++){
                int zahl = randomGenerator.nextInt(2);
                randomNumber += zahl;
            }
            for(int i=0; i<1; i++){
                int zahl = randomGenerator.nextInt(99);
                randomNumber += "." + zahl;
            }
            
            cost.set(prod.getName(), Float.parseFloat(randomNumber));
        }
        barModel.addSeries(price);
        barModel.addSeries(cost);
        
        
        barModel.setTitle("Produktinformation");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Produkte");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Preise / Kosten");
        yAxis.setMin(0);
        yAxis.setMax(4);
    }
    
    public LineChartModel getAnimatedModel(){
        return animatedModel;
    }
    
    public void createAnimatedModel(){
        animatedModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        
        animatedModel.addSeries(series1);
        animatedModel.addSeries(series2);
                
        animatedModel.setTitle("Line Chart");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    
    public Integer getSelectedProductAmount(Integer productID) {
        List<Inventory> list = inventoryFacade.inventoryByProduct(productID);
        int amount = 0;
        Iterator<Inventory> iterator = list.iterator();
        while(iterator.hasNext()){
            Inventory inv = (Inventory) iterator.next();
            amount += inv.getCurrentAmount();
        }
        return amount;
    }
}
