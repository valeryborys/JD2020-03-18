/*
 * График с чартом запускаются отдельно от основной программы!
 */

package by.it.okatov.jd02_02;

import by.it.okatov.jd01_15.TaskB;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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

        //Читаем данные измерения из файла
        readFromFile(series);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart("time/number",
                "time",
                "number of buyers",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, true); //Создаем набор и передаем в него серию измерений
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesStroke(0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 1.0f)); //Создаем рендер для утолщения линии графика
        XYPlot plot = chart.getXYPlot();

        ChartFrame frame = new ChartFrame("График зависимости количества покупателей от времени", chart);
        frame.pack();
        frame.setVisible(true);
        plot.setRenderer(renderer);
    }

    private static void readFromFile(XYSeries series) {
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
    }
}
