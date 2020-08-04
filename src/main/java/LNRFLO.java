import java.util.Map;

public class LNRFLO {

    private int OpCntRs = 0;
    private double FitZab;//Полное сопротивление в месте короткого замыкания ab
    private double FitZbc;//Полное сопротивление в месте короткого замыкания bc
    private double FitZca;//Полное сопротивление в месте короткого замыкания ca
    private double FitDiskm;//Участок повреждения в километрах (км)
    private String FitLoop;//Петля короткого замыкания
    private double LinLenKm = 273;//Длина линии в километрах (км)
    private double R1 = 0.048;//Сопротивление прямой последовательности в линии
    private double X1 = 0.328;//Реактивное сопротивление прямой последовательности в линии
    private double R0 = 0.198;//Сопротивление нулевой последовательности в линии
    private double X0 = 1.148;//Реактивное сопротивление нулевой последовательности в линии
    private double Z1Mod;//Значение полного сопротивления прямой последовательности в линии
    private double Z1Ang = 81;//Угол полного сопротивления прямой последовательности в линии
    private double Z0Mod;//Значение полного сопротивления нулевой последовательности в линии
    private double Z0Ang;//Угол полного сопротивления нулевой последовательности в линии
    private double Rm0;//Взаимное сопротивление
    private double Xm0;//Взаимное реактивное сопротивление
    private double Zm0Mod;//Взаимное полное сопротивление
    private double Zm0Ang;//Взаимный угол полного сопротивления
    private double[] PhV1 = new double[80];
    private double[] PhV2 = new double[80];
    private double[] PhV3 = new double[80];
    private double[] PhA1 = new double[80];
    private double[] PhA2 = new double[80];
    private double[] PhA3 = new double[80];
    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;

    public void receiveData(double[] data){
        //TODO: Рассчитываем значения Urms и Irms через фильтр Фурье
        PhV1[OpCntRs] = data[0];
        PhV2[OpCntRs] = data[1];
        PhV3[OpCntRs] = data[2];
        PhA1[OpCntRs] = data[3];
        PhA2[OpCntRs] = data[4];
        PhA3[OpCntRs] = data[5];

        double PhV1x = 0;
        double PhV1y = 0;
        double PhV2x = 0;
        double PhV2y = 0;
        double PhV3x = 0;
        double PhV3y = 0;

        double PhA1x = 0;
        double PhA1y = 0;
        double PhA2x = 0;
        double PhA2y = 0;
        double PhA3x = 0;
        double PhA3y = 0;

        for (int i = 0; i < 80; i++) {
            PhV1x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhV1[i]; // активное
            PhV1y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhV1[i]; // реактивное

            PhV2x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhV2[i];
            PhV2y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhV2[i];

            PhV3x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhV3[i];
            PhV3y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhV3[i];

            PhA1x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhA1[i];
            PhA1y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhA1[i];

            PhA2x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhA2[i];
            PhA2y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhA2[i];

            PhA3x += 0.025 * Math.sin(0.025 * Math.PI * i) * PhA3[i];
            PhA3y += 0.025 * Math.cos(0.025 * Math.PI * i) * PhA3[i];
        }


        // Фазные амплитуды токов
        double MaxAmp1 = Math.sqrt(Math.pow(PhA1x, 2) + Math.pow(PhA1y, 2));
        double MaxAmp2 = Math.sqrt(Math.pow(PhA2x, 2) + Math.pow(PhA2y, 2));
        double MaxAmp3 = Math.sqrt(Math.pow(PhA3x, 2) + Math.pow(PhA3y, 2));

        double[] RX = new double[6];
        // Для реактивных сопротивлений
        double Xab = (PhV1y - PhV2y)/(PhA1y - PhA2y);
        double Xbc = (PhV2y - PhV3y)/(PhA2y - PhA3y);
        double Xca = (PhV3y - PhV1y)/(PhA3y - PhA1y);
        RX[0] = Xab;
        RX[1] = Xbc;
        RX[2] = Xca;

        // Для активных сопротивлений
        double Rab = (PhV1x - PhV2x)/(PhA1x - PhA2x);
        double Rbc = (PhV2x - PhV3x)/(PhA2x - PhA3x);
        double Rca = (PhV3x - PhV1x)/(PhA3x - PhA1x);
        RX[3] = Rab;
        RX[4] = Rbc;
        RX[5] = Rca;

        // Углы - арктангенсы
        double Angab = Math.atan(Xab/Rab);
        double Angbc = Math.atan(Xbc/Rbc);
        double Angca = Math.atan(Xca/Rca);

        // Находим сопроивление по треугольнику сопротивлений
        double MaxZab = Math.sqrt(Math.pow(Xab,2) + Math.pow(Rab,2));
        double MaxZbc = Math.sqrt(Math.pow(Xbc,2) + Math.pow(Rbc,2));
        double MaxZca = Math.sqrt(Math.pow(Xca,2) + Math.pow(Rca,2));

        double[] data2 = new double[6];
        // Сопротивления в показательной форме
        FitZab = MaxZab * Math.exp(Angab);
        FitZbc = MaxZbc * Math.exp(Angbc);
        FitZca = MaxZca * Math.exp(Angca);
        data2[0] = FitZab;
        data2[1] = FitZbc;
        data2[2] = FitZca;

        //TODO:Находим производные токов для блокировки при качаниях
        // Для пускового органа берем фазные токи
        // Углы
        double Ang1 = Math.atan(PhA1y/PhA1x);
        double Ang2 = Math.atan(PhA2y/PhA2x);
        double Ang3 = Math.atan(PhA3y/PhA3x);

        // Производные фазных токов
        double HATm1 = -MaxAmp1 * Math.sin(Ang1) + MaxAmp1 * Math.cos(Ang1);
        double HATm2 = -MaxAmp2 * Math.sin(Ang2) + MaxAmp2 * Math.cos(Ang2);
        double HATm3 = -MaxAmp3 * Math.sin(Ang3) + MaxAmp3 * Math.cos(Ang3);
        data2[3] = HATm1;
        data2[4] = HATm2;
        data2[5] = HATm3;
        sendData(RX,forCallBack.get(addrLN.get("LNRADR")));
        sendData(data2,forCallBack.get(addrLN.get("LNPDIS")));

        if (++OpCntRs >= 80) OpCntRs = 0;
    }

    private void sendData(double[] data, CallBack forCallBack) {
        forCallBack.call2(data);
    }

    public void setForCallBack(Map<String, CallBack> forCallBack, Map<String, String> addrLN) {
        this.forCallBack = forCallBack;
        this.addrLN = addrLN;
    }
}
