import scl.TDAI;
import scl.TDOI;
import scl.TLDevice;
import scl.TLN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LNRADR {
    private int OpCntRs = 0;
    private String ChTrg = "ChTrg";//Канал запущен
    private int ChNum;//Номер канала
    private String TrgMod = "TrgMod";//Режим пуска (внутренний триггер, внешний триггер или тот и другой)
    private String LevMod = "LevMod";//Режим уровня триггера / пуска
    private String HiTrgLev = "HiTrgLev";//Высокий (положительный) уровень триггера
    private String LoTrgLev = "LoTrgLev";//Низкий (отрицательный) уровень триггера
    private long PreTmms = System.currentTimeMillis();//Время до пуска
    private long PstTmms;//Время после пуска
    private List<String> list = new ArrayList<>();
    private double[] SetZ = new double[4];
//    private double[] for_building_cir = new double[6];

    public void receiveFromLNT(double[] data){
        OpCntRs++;
        if(OpCntRs==1){
            System.out.println("PreTmms " + PreTmms);
            PstTmms = System.currentTimeMillis();
            System.out.println("PstTmms " + PstTmms);
        }
        for (ChNum = 0; ChNum < 6; ChNum++) {
            if (OpCntRs == 1){
                System.out.println(ChTrg + ChNum);
            }
            Charts.addAnalogData(ChNum,0,data[ChNum]);
        }
    }


    public void receiveFromLNRFLO(double[] data){
        double Xab = data[0];
        double Xbc = data[1];
        double Xca = data[2];
        double Rab = data[3];
        double Rbc = data[4];
        double Rca = data[5];
        //TODO: Добавляем точки сопротивлений на график
        if (Rab < 1000 && Rab >= -600 && Xab < 1000 && Xab >= -100){
            ChartsXY.addAnalogData(0,4,Rab,Xab);
        }
        if(Rbc < 1000 && Rbc >= -600 && Xbc < 1000 && Xbc >= -100){
            ChartsXY.addAnalogData(0,5,Rbc,Xbc);
        }
        if(Rca < 1000 && Rca >= -600 && Xca < 1000 && Xca >= -100){
            ChartsXY.addAnalogData(0,6,Rca,Xca);
        }

    }

    public void parcingCIDForCircles(){
        TLDevice tlDevice = WorkWithCfgs.unMarshalAny(TLDevice.class, "PDIS.cid");
        for (TLN tln : tlDevice.getLN()) {
            for (TDOI tdoi : tln.getDOI()) {
                for (TDAI tdai : tdoi.getSDIOrDAI()) {
                    if(tdai.getVal() != null){
                        list.add(tdai.getVal());

                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            SetZ[i] = Double.parseDouble(list.get(i));
        }
        building_circles(SetZ);
    }

    public void building_circles(double[] SetZ){

        double LNPDIS1 = SetZ[0];
        double LNPDIS2 = SetZ[1];
        double LNPDIS3 = SetZ[2];
        double LinAng = 1.425;
        // Смещения
        double x0I = (LNPDIS1/2) * Math.cos(LinAng);
        double y0I = (LNPDIS1/2) * Math.sin(LinAng);
        double x0II = (LNPDIS2/2) * Math.cos(LinAng);
        double y0II = (LNPDIS2/2) * Math.sin(LinAng);
        double x0III = (LNPDIS3/2) * Math.cos(LinAng);
        double y0III = (LNPDIS3/2) * Math.sin(LinAng);

        // Из уравнения окружности
        for(Double xI : array_for_X(x0I - y0I, LNPDIS1, 1)){
            double point_YI = Math.sqrt(Math.pow((LNPDIS1/2),2) - Math.pow((xI - x0I),2));
            ChartsXY.addAnalogData(0,0,xI,point_YI + y0I);
            ChartsXY.addAnalogData(0,0,xI,-point_YI + y0I);
        }

        for(Double xII : array_for_X(x0II - y0II, LNPDIS2, 1)){
            double point_YII = Math.sqrt(Math.pow((LNPDIS2/2),2) - Math.pow((xII - x0II),2));
            ChartsXY.addAnalogData(0,1,xII,point_YII + y0II);
            ChartsXY.addAnalogData(0,1,xII,-point_YII + y0II);
        }

        for(Double xIII : array_for_X(x0III - y0III, LNPDIS3, 1)){
            double point_YIII = Math.sqrt(Math.pow((LNPDIS3/2),2) - Math.pow((xIII - x0III),2));
            ChartsXY.addAnalogData(0,2,xIII,point_YIII + y0III);
            ChartsXY.addAnalogData(0,2,xIII,-point_YIII + y0III);
        }

       //Построим прямую под углом м.ч.
        for (Double X : array_for_X(0,LNPDIS3 * Math.cos(LinAng),1)){
            double Y = 1.65 * X * Math.exp(LinAng);
            ChartsXY.addAnalogData(0,3,X,Y);
        }

    }

    // Метод для формирования массива Х
    public double[] array_for_X(double start, double finish, double step) {
        int length = (int) ((finish - start)/step);
        double[] array_for_X = new double[length];
        array_for_X[0] = start;
        for (int i = 1; i < length; i++){
            array_for_X[i] = start;
            start += step;
        }
        return array_for_X;
    }
}
