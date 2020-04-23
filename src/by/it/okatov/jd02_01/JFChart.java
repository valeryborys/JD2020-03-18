package by.it.okatov.jd02_01;

import by.it.okatov.jd01_15.TaskB;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JFChart {
    public static void main(String[] args) {
        XYSeries series = new XYSeries("Number of buyers");
        double a, b;

        try (Scanner sc = new Scanner(
                new File(
                        TaskB.getFileName(
                                Supermarket.class, "Chart.txt"
                        )
                )

        )
        ) {
            while (sc.hasNext()) {
                series.add(sc.nextInt(), sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart("time/number",
                "time",
                "number of buyers",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, true);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesStroke(0, new BasicStroke(
                5.0f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 1.0f));

        ChartFrame frame = new ChartFrame("123", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
