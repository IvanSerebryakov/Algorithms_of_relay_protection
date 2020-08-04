import java.util.Arrays;
import java.util.Map;

public class LNPDIS {

    private int OpCntRs = 0;
    private String Str = "Str";//Пуск
    private String Op = "Op";//Срабатывание
    private double PoRch;//Полярная область — это диаметр на круговой диаграмме проводимости
    private double PhStr;//Начальное фазное значение
    private double GndStr;//Начальное значение нулевой последовательности
    private String DirMod = "DirMod";//Режим направленной защиты
    private double PctRch;//Процент области действия
    private double Ofs;//Смещение
    private double PctOfs;//Процент смещения
    private double RisLod;//Область сопротивления для зоны нагрузки
    private double AngLod;//Угол для зоны нагрузки
    private String TmDiMod = "TmDiMod";//Режим задержки времени срабатывания
    private double OpDITmms;//Задержка времени срабатывания
    private String PhDIMod = "PhDIMod";
    private double PhDITmms;//Время задержки срабатывания при многофазных КЗ
    private String GndDIMod = "GndDIMod";//Время задержки срабатывания при однофазном режиме замыкания на землю
    private double GndDITmms;//Время задержки срабатывания при однофазных замыканиях на землю
    private double X1;//Область реактивного сопротивления при прямой последовательности линии
    private double LinAng;//Угол сдвига фаз
    private double RisCndRch;//Область резистивного заземления
    private double RisPhRch;//Область резистивной фазы
    private double K0Fact;//Коэффициент остаточной компенсации К0
    private double K0FactAng;//Угол коэффициента остаточной компенсации
    private double RsDITmms;//Время задержки сброса
    private double[] list = new double[4];
    private double[] list1 = new double[6];
    private boolean[] flags = new boolean[4];
    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;

    public void receiveFromIHMI(double[] data){
//        System.out.println("receiveFromIHMI " + Arrays.toString(data));
        for (int i = 0; i< 4; i++){
            list[i] = data[i];
        }
        logic(list,list1);
    }

    public void receiveFromRFLO(double[] data){
//        System.out.println("receiveFromRFLO PDIS " + Arrays.toString(data));
        for (int i = 0; i < 6; i++){
            list1[i] = data[i];
        }
        logic(list,list1);
    }

    public void logic(double[] data,double[]data1){
//        System.out.println("list " + Arrays.toString(data));
//        System.out.println("list1 " + Arrays.toString(data1));
        double LNPDIS1 = data[0];
        double LNPDIS2 = data[1];
        double LNPDIS3 = data[2];
        double BlkZn = data[3];
        double FitZab = data1[0];
        double FitZbc = data1[1];
        double FitZca = data1[2];
        double HATm1 = data1[3];
        double HATm2 = data1[4];
        double HATm3 = data1[5];

        // 1 ступень защиты
        if ( (FitZab <= LNPDIS1 || FitZbc <= LNPDIS1 || FitZca <= LNPDIS1) &&
                (HATm1 >= BlkZn || HATm2 >= BlkZn || HATm3 >= BlkZn)){
            OpCntRs++;
            if(OpCntRs == 1){
                //Срабатывание
                System.out.println(Op + " LNPDIS1");
            }
            flags[0] = true;

        } else flags[0] = false;



        // 2 ступень защиты
        if (   (FitZab <= LNPDIS2 && FitZab > LNPDIS1 ||
                FitZbc <= LNPDIS2 && FitZbc > LNPDIS1 ||
                FitZca <= LNPDIS2 && FitZca > LNPDIS1) &&
                (HATm1 >= BlkZn || HATm2 >= BlkZn || HATm3 >= BlkZn)){
            OpDITmms++;
            if (OpDITmms < 200){
                if (OpDITmms == 1){
                    //Пуск
                    System.out.println(Str + " LNPDIS2");
                    //Режим задержки времени срабатывания
                    System.out.println(TmDiMod + " LNPDIS2");
                }
            }
            if (OpDITmms >= 1000) {
                if (OpDITmms == 1000){
                    //Срабатывание
                    System.out.println(Op + " LNPDIS2");
                }
                flags[1] = true;
            }
        }else flags[1] = false;


        // 3 ступень защиты
        if (   (FitZab <= LNPDIS3 && FitZab > LNPDIS2 ||
                FitZbc <= LNPDIS3 && FitZbc > LNPDIS2 ||
                FitZca <= LNPDIS3 && FitZca > LNPDIS2) &&
                (HATm1 >= BlkZn || HATm2 >= BlkZn || HATm3 >= BlkZn)){
            OpDITmms++;
            if (OpDITmms >= 200){
                if (OpDITmms == 200){
                    //Пуск
                    System.out.println(Str + " LNPDIS3");
                    //Режим задержки времени срабатывания
                    System.out.println(TmDiMod + " LNPDIS3");
                }
            }
            if (OpDITmms >= 1300) {
                if (OpDITmms == 1300){
                    //Срабатывание
                    System.out.println(Op + " LNPDIS3");
                }
                flags[2] = true;
            }
        } else flags[2] = false;


        // Блокировка при качаниях
        if ((HATm1 < BlkZn || HATm2 < BlkZn|| HATm3 < BlkZn))
            flags[3] = true; else flags[3] = false;

        sendData(flags,forCallBack.get(addrLN.get("LNRBDR")));
        sendData(flags,forCallBack.get(addrLN.get("LNPTRC")));
    }

    private void sendData(boolean[] data, CallBack forCallBack) {
        forCallBack.bool(data);
    }

    public void setForCallBack(Map<String, CallBack> forCallBack, Map<String, String> addrLN) {
        this.forCallBack = forCallBack;
        this.addrLN = addrLN;
    }
}
