package org.niraj.test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeTest5PieChart3D {

	public static void main(String[] args) {
		String filePath = "W:\\FilesByCode\\jfreeimage\\";

		 DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "IPhone 5s" , new Double( 20 ) );
	      dataset.setValue( "SamSung Grand" , new Double( 20 ) );
	      dataset.setValue( "MotoG" , new Double( 40 ) );
	      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );

	      JFreeChart chart = ChartFactory.createPieChart3D(
	         "Mobile Sales" ,  // chart title
	         dataset ,         // data
	         true ,            // include legend
	         true,
	         false);

	      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );
	      plot.setStartAngle( 90 );
	      plot.setForegroundAlpha( 0.60f );
	      plot.setInteriorGap( 0.01 );
	      int width = 640; /* Width of the image */
	      int height = 480; /* Height of the image */
	      File pieChart3D = new File( filePath+"pie_Chart3D.jpeg" );
	      try {
			ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}