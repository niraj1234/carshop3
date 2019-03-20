package org.niraj.test;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;

public class JFreeTest6BubbleChart {

	public static void main(String[] args) {
		String filePath = "W:\\FilesByCode\\jfreeimage\\";


		  DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset( );
	      double ad[ ] = { 30 , 40 , 50 , 60 , 70 , 80 };
	      double ad1[ ] = { 10 , 20 , 30 , 40 , 50 , 60 };
	      double ad2[ ] = { 4 , 5 , 10 , 8 , 9 , 6 };
	      double ad3[ ][ ] = { ad , ad1 , ad2 };
	      defaultxyzdataset.addSeries( "Series 1" , ad3 );

	      JFreeChart jfreechart = ChartFactory.createBubbleChart(
	         "AGE vs WEIGHT vs WORK",
	         "Weight",
	         "AGE",
	         defaultxyzdataset,
	         PlotOrientation.HORIZONTAL,
	         true, true, false);

	      XYPlot xyplot = ( XYPlot )jfreechart.getPlot( );
	      xyplot.setForegroundAlpha( 0.65F );
	      XYItemRenderer xyitemrenderer = xyplot.getRenderer( );
	      xyitemrenderer.setSeriesPaint( 0 , Color.blue );
	      NumberAxis numberaxis = ( NumberAxis )xyplot.getDomainAxis( );
	      numberaxis.setLowerMargin( 0.2 );
	      numberaxis.setUpperMargin( 0.5 );
	      NumberAxis numberaxis1 = ( NumberAxis )xyplot.getRangeAxis( );
	      numberaxis1.setLowerMargin( 0.8 );
	      numberaxis1.setUpperMargin( 0.9 );

	      int width = 560; /* Width of the image */
	      int height = 370; /* Height of the image */
	      File bubbleChart = new File(filePath + "BubbleChart.jpeg");
	      try {
			ChartUtilities.saveChartAsJPEG(bubbleChart,jfreechart,width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
