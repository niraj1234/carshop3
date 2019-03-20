package org.niraj.test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

//  http://www.tutorialspoint.com/jfreechart/jfreechart_pie_chart.htm

public class JFreeTest1PieChart {

	public static void main(String[] args) throws IOException {
		String filePath = "W:\\FilesByCode\\jfreeimage\\";

		 DefaultPieDataset dataset_pieChart = new DefaultPieDataset();

	      dataset_pieChart.setValue("Mobile", new Double( 20 ) );
	      dataset_pieChart.setValue("Entertainment", new Double( 32 ) );
	      dataset_pieChart.setValue("News", new Double( 17 ) );
	      dataset_pieChart.setValue("HowTo", new Double( 8 ) );
	      dataset_pieChart.setValue("Inspiration", new Double( 14 ) );
	      dataset_pieChart.setValue("Viral", new Double( 3 ) );

	      JFreeChart chart = ChartFactory
	      		.createPieChart("BlogByCategory", dataset_pieChart, true, true, false);

	      int width = 600; /* Width of the image */
	      int height = 400; /* Height of the image */

/*	      File pieChartFile = new File( "D:\\TestFolderJava\\PieChart2.png" );
	      ChartUtilities.saveChartAsPNG(pieChartFile , chart , width , height );
*/
	      File pieChartFile = new File( filePath+"PieChart2.jpeg" );
	      ChartUtilities.saveChartAsJPEG( pieChartFile , chart , width , height );

	      System.out.println("Chart created successfully ==>");
	}

}
