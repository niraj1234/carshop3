package org.niraj.test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeTest2BarChart {

	public static void main(String[] args) {

		String filePath = "W:\\FilesByCode\\jfreeimage\\";

		 final String fiat = "FIAT";
	      final String audi = "AUDI";
	      final String ford = "FORD";
	      final String speed = "Speed";
	      final String millage = "Millage";
	      final String userrating = "User Rating";
	      final String safety = "safety";

	      final DefaultCategoryDataset dataset_barChart = new DefaultCategoryDataset( );

	      dataset_barChart.addValue( 1.0 , fiat , speed );
	      dataset_barChart.addValue( 3.0 , fiat , userrating );
	      dataset_barChart.addValue( 5.0 , fiat , millage );
	      dataset_barChart.addValue( 5.0 , fiat , safety );

	      dataset_barChart.addValue( 5.0 , audi , speed );
	      dataset_barChart.addValue( 6.0 , audi , userrating );
	      dataset_barChart.addValue( 10.0 , audi , millage );
	      dataset_barChart.addValue( 4.0 , audi , safety );

	      dataset_barChart.addValue( 4.0 , ford , speed );
	      dataset_barChart.addValue( 2.0 , ford , userrating );
	      dataset_barChart.addValue( 3.0 , ford , millage );
	      dataset_barChart.addValue( 6.0 , ford , safety );

	      JFreeChart barChart = ChartFactory.createBarChart( "CAR USAGE STATIStICS","Category",
	      			"Score", dataset_barChart, PlotOrientation.HORIZONTAL,  true, true, false);

	      int width = 640; /* Width of the image */
	      int height = 480; /* Height of the image */
	      File barChartFile = new File( filePath+"BarChartHorizontal.png" );
	      try {
			ChartUtilities.saveChartAsPNG( barChartFile , barChart , width , height );
			System.out.println("Bar Chart created successfully ==>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
