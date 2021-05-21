/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.chart;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;
import com.mycompany.myapp.entitie.Testfitness;
import com.mycompany.myapp.services.TestfitnessService;
import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class BudgetPieChart extends AbstractDemoChart{
            static Testfitness b=new Testfitness();
                Form currentA;
int stock;
String nom;
  ArrayList<Testfitness> liste=TestfitnessService.getInstance().AllTestfitnessAction();
  public int nmbreProducts= liste.size();
public int values[ ] = new int[nmbreProducts];
public String productTitle[] = new String[nmbreProducts];
//public int [] values;

              
                
    

  /**
   * Returns the chart name.
   * 
   * @return the chart name
   */
  public String getName() {
    return "pourcentage selon les durées des tests chart";
  }

  /**
   * Returns the chart description.
   * 
   * @return the chart description
   */
  public String getDesc() {
    return "The Stock per product for this year (pie chart)";
  }

  /**
   * Executes the chart demo.
   * 
   * @param context the context
   * @return the built intent
   */

   
  public Form execute() {
       
       int i=0;
        int j=0;
 for(Testfitness c1 : liste) {
    stock=c1.getDuree();  
    values[i] = stock;
     i++;
      nom= "durée:"+c1.getDuree()+"{id test:"+c1.getId()+"}";  
    productTitle[j] = nom ;
    j++;
    
    System.err.println(stock);
       System.err.println(nom);
        }


   
    //  values = new int[] {stock,20,30,10,25};

    int[] colors = new int[] { ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN };
    final DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    //renderer.setChartTitleTextFont(/*largeFont*/);
   // renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
   
    final CategorySeries seriesSet = buildCategoryDataset("Product Quantity", values,productTitle);

    
    final PieChart chart = new PieChart(seriesSet, renderer);
    ChartComponent comp = new ChartComponent(chart){

        private boolean inDrag = false;
        
        @Override
        public void pointerPressed(int x, int y) {
            inDrag = false;
            super.pointerPressed(x, y); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void pointerDragged(int x, int y) {
            inDrag = true;
            super.pointerDragged(x, y); //To change body of generated methods, choose Tools | Templates.
        }

        
        
        @Override
        protected void seriesReleased(SeriesSelection sel) {
            
            if ( inDrag ){
                // Don't do this if it was a drag operation
                return;
            }
            
            for ( SimpleSeriesRenderer r : renderer.getSeriesRenderers()){
                r.setHighlighted(false);
            }
            SimpleSeriesRenderer r = renderer.getSeriesRendererAt(sel.getPointIndex());
            r.setHighlighted(true);
            
            Shape seg = chart.getSegmentShape(sel.getPointIndex());
            Rectangle bounds = seg.getBounds();
            bounds = new Rectangle(
                    bounds.getX()-40,
                    bounds.getY()-40,
                    bounds.getWidth()+80,
                    bounds.getHeight()+80
            );
            
            this.zoomToShapeInChartCoords(bounds, 500);
            
            
            
        }
       
        
        
    };
    comp.setZoomEnabled(false);
    comp.setPanEnabled(true);


    return wrap("Stock", comp);

  }

  
     
}
