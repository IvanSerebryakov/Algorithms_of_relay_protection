import scl.TDAI;
import scl.TDOI;
import scl.TLDevice;
import scl.TLN;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        CallClass callClass = new CallClass();
        callClass.createCharts();
        callClass.calls();

    }
    public static void createCID(){
        TLDevice tlDevice = new TLDevice();

        //TODO:PDIS
        TLN tlnPDIS = new TLN();
        tlnPDIS.setInst(1);
        tlnPDIS.setPrefix("");
        tlnPDIS.getLnClass().add("LNPDIS");

        TDOI tdoiPDIS = new TDOI();
        tdoiPDIS.setName("Obj");
        tdoiPDIS.setDesc("New Object");

        TDAI tdaiPDIS1 = new TDAI();
        tdaiPDIS1.setName("LNPDIS1");
        tdaiPDIS1.setVal("271.99");
        tdaiPDIS1.setDesc("Зона 1 Дистанционной защиты");

        TDAI tdaiPDIS2 = new TDAI();
        tdaiPDIS2.setName("LNPDIS2");
        tdaiPDIS2.setVal("516.78");
        tdaiPDIS2.setDesc("Зона 2 Дистанционной защиты");

        TDAI tdaiPDIS3 = new TDAI();
        tdaiPDIS3.setName("LNPDIS3");
        tdaiPDIS3.setVal("968.56");
        tdaiPDIS3.setDesc("Зона 3 Дистанционной защиты");

        TDAI tdaiPDIS4 = new TDAI();
        tdaiPDIS4.setName("BlkZn");
        tdaiPDIS4.setVal("1.41");
        tdaiPDIS4.setDesc("Блокировка коррелированной зоны LNPDIS");

        TDAI tdaiPDIS5 = new TDAI();
        tdaiPDIS5.setName("LNPDIS");
        tdaiPDIS5.setSAddr("LNPDIS");

        tdoiPDIS.getSDIOrDAI().add(tdaiPDIS1);
        tdoiPDIS.getSDIOrDAI().add(tdaiPDIS2);
        tdoiPDIS.getSDIOrDAI().add(tdaiPDIS3);
        tdoiPDIS.getSDIOrDAI().add(tdaiPDIS4);
        tdoiPDIS.getSDIOrDAI().add(tdaiPDIS5);
        tlnPDIS.getDOI().add(tdoiPDIS);


        //TODO:LNTVTR
        TLN tlnTVTR = new TLN();
        tlnTVTR.setInst(1);
        tlnTVTR.setPrefix("");
        tlnTVTR.getLnClass().add("LNTVTR");

        TDOI tdoiTVTR = new TDOI();
        tdoiTVTR.setName("Obj");
        tdoiTVTR.setDesc("New Object");

        TDAI tdaiTVTR = new TDAI();
        tdaiTVTR.setName("LNTVTR");
        tdaiTVTR.setSAddr("LNTVTR");
        tdoiTVTR.getSDIOrDAI().add(tdaiTVTR);
        tlnTVTR.getDOI().add(tdoiTVTR);

        //TODO:LNRFLO
        TLN tlnRFLO = new TLN();
        tlnRFLO.setInst(1);
        tlnRFLO.setPrefix("");
        tlnRFLO.getLnClass().add("LNRFLO");

        TDOI tdoiRFLO = new TDOI();
        tdoiRFLO.setName("Obj");
        tdoiRFLO.setDesc("New Object");

        TDAI tdaiRFLO = new TDAI();
        tdaiRFLO.setName("LNRFLO");
        tdaiRFLO.setSAddr("LNRFLO");

        tdoiRFLO.getSDIOrDAI().add(tdaiRFLO);
        tlnRFLO.getDOI().add(tdoiRFLO);

        tlDevice.getLN().add(tlnPDIS);
        tlDevice.getLN().add(tlnTVTR);
        tlDevice.getLN().add(tlnRFLO);
        WorkWithCfgs.marshalAny(TLDevice.class, tlDevice, "PDIS.cid");

    }
}

