import scl.TDAI;
import scl.TDOI;
import scl.TLDevice;
import scl.TLN;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CallClass {

    private Map<String, String> addrLN = new HashMap<>();

    public void calls() throws IOException {
        parsingCID();
        final LNT lntvtr = new LNT();
        final LNRFLO lnrflo = new LNRFLO();
        final LNRADR lnradr = new LNRADR();
        final LNPDIS lnpdis = new LNPDIS();
        final LNIHMI lnihmi = new LNIHMI();
        final LNRBDR lnrbdr = new LNRBDR();
        final LNPTRC lnptrc = new LNPTRC();
        final LNXCBR lnxcbr = new LNXCBR();
        Map<String, CallBack> forCallBack = new HashMap<>();

        forCallBack.put("LNRFLO", new CallBack() {
            @Override
            public void call(double[] data) {
                lnrflo.receiveData(data);
            }

            @Override
            public void call2(double[] data) {

            }

            @Override
            public void bool(boolean[] data) {
            }
        });
        forCallBack.put("LNRADR", new CallBack() {
            @Override
            public void call(double[] data) {
                lnradr.receiveFromLNT(data);
            }

            @Override
            public void call2(double[] data) {
                lnradr.receiveFromLNRFLO(data);
            }

            @Override
            public void bool(boolean[] data) {

            }
        });
        forCallBack.put("LNPDIS", new CallBack() {
            @Override
            public void call(double[] data) {
                lnpdis.receiveFromIHMI(data);
            }

            @Override
            public void call2(double[] data) {
                lnpdis.receiveFromRFLO(data);
            }
            @Override
            public void bool(boolean[] data) {

            }
        });
        forCallBack.put("LNRBDR", new CallBack() {
            @Override
            public void call(double[] data) {

            }

            @Override
            public void call2(double[] data) {

            }

            @Override
            public void bool(boolean[] data) {
                lnrbdr.receiveFromPDIS(data);
            }
        });
        forCallBack.put("LNPTRC", new CallBack() {
            @Override
            public void call(double[] data) {

            }

            @Override
            public void call2(double[] data) {

            }

            @Override
            public void bool(boolean[] data) {
                lnptrc.receiveFromPDIS(data);
            }
        });
        forCallBack.put("LNXCBR", new CallBack() {
            @Override
            public void call(double[] data) {

            }

            @Override
            public void call2(double[] data) {

            }

            @Override
            public void bool(boolean[] data) {
                lnxcbr.receiveFromPTRC(data);
            }
        });
        lntvtr.setForCallBack(forCallBack, addrLN);
        lnrflo.setForCallBack(forCallBack, addrLN);
        lnihmi.setForCallBack(forCallBack,addrLN);
        lnpdis.setForCallBack(forCallBack,addrLN);
        lnptrc.setForCallBack(forCallBack,addrLN);

        lnihmi.for_tripPoints();
        lnradr.parcingCIDForCircles();
        lntvtr.start();
    }

    public void parsingCID() {
        TLDevice tlDevice = WorkWithCfgs.unMarshalAny(TLDevice.class, "PDIS.cid");
        for (TLN tln : tlDevice.getLN()) {
            for (TDOI tdoi : tln.getDOI()) {
                for (TDAI tdai : tdoi.getSDIOrDAI()) {
//                    if (tdai.getName().length() == 2) {//4
                        addrLN.put(tdai.getName(), tdai.getSAddr());
//                        System.out.println(addrLN);
//                    } else {
//                        trippoints.put(tdai.getName(), Double.parseDouble(tdai.getVal()));
//                        System.out.println("trippoints " + trippoints);
                    }
                }
            }
        }




    public void createCharts(){
        Charts.createAnalogChart("PhV1", 0);
        Charts.addSeries("PhV1", 0, 0);

        Charts.createAnalogChart("PhV2", 1);
        Charts.addSeries("PhV2", 1, 0);

        Charts.createAnalogChart("PhV3", 2);
        Charts.addSeries("PhV3", 2, 0);

        Charts.createAnalogChart("PhA1", 3);
        Charts.addSeries("PhA1", 3, 0);

        Charts.createAnalogChart("PhA2", 4);
        Charts.addSeries("PhA2", 4, 0);

        Charts.createAnalogChart("PhA3", 5);
        Charts.addSeries("PhA3", 5, 0);

        Charts.createDiscreteChart("PDIS1",0);

        Charts.createDiscreteChart("PDIS2",1);

        Charts.createDiscreteChart("PDIS3",2);

        Charts.createDiscreteChart("BlkZn",3);

        ChartsXY.createAnalogChart("LNPDIS",0);
        ChartsXY.addSeries("LNPDIS1",0,0);
        ChartsXY.addSeries("LNPDIS2",0,1);
        ChartsXY.addSeries("LNPDIS3",0,2);
        ChartsXY.addSeries("PctRch",0,3);

        ChartsXY.addSeries("FitZab",0,4);
        ChartsXY.addSeries("FitZbc",0,5);
        ChartsXY.addSeries("FitZca",0,6);

    }
}



