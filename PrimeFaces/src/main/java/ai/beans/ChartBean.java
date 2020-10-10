package ai.beans;

import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
        createLineModel();
    }

    private void createLineModel() {
        lineModel = new LineChartModel();

        LineChartSeries sinSeries = new LineChartSeries();
        sinSeries.setLabel("sin");
        LineChartSeries cosSeries = new LineChartSeries();
        cosSeries.setLabel("cos");
        for(int angle = 0; angle <= 360; angle += 10) {
            sinSeries.set(angle, Math.sin(Math.toRadians(angle)));
            cosSeries.set(angle, Math.cos(Math.toRadians(angle)));
        }
        lineModel.addSeries(sinSeries);
        lineModel.addSeries(cosSeries);

        lineModel.setTitle("Trigonometric functions");
        lineModel.setLegendPosition("n");
        lineModel.setZoom(true);

        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
}
