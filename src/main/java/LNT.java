import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LNT {

    private String EEHealth;//Состояние работоспособности внешнего оборудования
    private String EEName;//Паспортная табличка внешнего оборудования
    private double OpTmh;//Время работы
    private String FuFail;//Отказ предохранителя
    private double VRtg = 330;// Vol nom
    private double HzRtg = 50;
    private double Rat;//Отношение числа витков обмоток внешнего трансформатора тока/напряжения (преобразователя)
    private double Cor;//Поправка значения вектора напряжения внешнего трансформатора напряжения
    private double AngCor;//Поправка угла между векторами напряжения внешнего трансформатора напряжения
    private File comtrCfg, comtrDat;
    private BufferedReader br;
    private String line;
    private String[] lineData;
    private double k1[], k2[];
    private int count;
    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;
//    private String comtrName = "KZ1"; //+ КЗ ВС
        private String comtrName = "KZ2"; //+ КЗ АВС
//    private String comtrName = "KZ3"; // + КЗ АВ
//    private String comtrName = "KZ4"; // + КЗ В
//    private String comtrName = "KZ5"; // + КЗ 2 ф
//    private String comtrName = "KZ6"; // + КЗ 2 ф
//    private String comtrName = "KZ7"; // - КЗ В
    private String path = "C:\\Users\\Иван\\Desktop\\учеба и записи лекций\\Алгоритмы РЗА\\Лаба 3 Холодов\\Лабораторная работа №3\\Опыты\\";

    private String cfgName = path + comtrName + ".cfg";
    private String datName = path + comtrName + ".dat";

    public LNT() {
        comtrCfg = new File(cfgName);
        comtrDat = new File(datName);
    }

    public void start() throws IOException {

        br = new BufferedReader(new FileReader(comtrCfg));

        int lineNumber = 0;
        int count = 0;
        int numberData = 0;

        while ((line = br.readLine()) != null) {
            lineNumber++;
            if (lineNumber == 2) {
                numberData = Integer.parseInt(line.split(",")[1].replaceAll("A", ""));
//                System.out.println("Number Signals: " + numberData);
                k1 = new double[numberData];
                k2 = new double[numberData];
//                System.out.println("Number Data: " + numberData);
            }

            if (lineNumber > 2 && lineNumber < numberData + 3) {
                String sp1[] = line.split(",");

                k1[count] = Double.parseDouble(line.split(",")[5]); //столбец значений калибровки а
                k2[count] = Double.parseDouble(line.split(",")[6]); //столбец значений смещения   b
                count++;
            }
        }

        count = 0;

        double[] data = new double[6];
        br = new BufferedReader(new FileReader(comtrDat));
        while ((line = br.readLine()) != null) {
            count++;
            lineData = line.split(",");
            OpTmh = Double.parseDouble(lineData[1]);
            double PhV1 = Double.parseDouble(lineData[2]) * k1[0] + k2[0]; //Значение Х сигнала в файле .dat = a*X+b
            double PhV2 = Double.parseDouble(lineData[3]) * k1[1] + k2[1];
            double PhV3 = Double.parseDouble(lineData[4]) * k1[2] + k2[2];

            double PhA1 = Double.parseDouble(lineData[5]) * k1[3] + k2[3];
            double PhA2 = Double.parseDouble(lineData[6]) * k1[4] + k2[4];
            double PhA3 = Double.parseDouble(lineData[7]) * k1[5] + k2[5];
            data[0] = PhV1;
            data[1] = PhV2;
            data[2] = PhV3;
            data[3] = PhA1;
            data[4] = PhA2;
            data[5] = PhA3;
            sendData(data, forCallBack.get(addrLN.get("LNRFLO")));
            sendData(data,forCallBack.get(addrLN.get("LNRADR")));
        }
    }

    private void sendData(double[] data, CallBack forCallBack) {
        forCallBack.call(data);
    }

    public void setForCallBack(Map<String, CallBack> forCallBack, Map<String, String> addrLN) {
        this.forCallBack = forCallBack;
        this.addrLN = addrLN;
    }
}

