import java.util.Arrays;
import java.util.Map;

public class LNXCBR {

    private String Loc = "Loc";//Локальная операция («локальная» означает нахождение вне сети связи автоматизации подстанции; непосредственный контроль с помощью аппаратного подключения)
    private String EEHealth = "EEHealth";//Состояние работоспособности внешнего оборудования
    private String EEName;//Паспортная табличка внешнего оборудования
    private int OpCnt = 0;//Счетчик числа переключений
    private String Pos = "Pos";//Положение переключателя
    private String BlkOpn = "BlkOpn";//Блокировка отключения
    private String BlkCls = "BlkCls";//Блокировка включения
    private String ChaMotEna = "ChaMotEna";//Двигатель зарядного устройства включен
    private double SumSwARs;//Общее количество переключаемых амперов, со сбросом
    private String CBOpCap = "CBOpCap";//Функциональные возможности выключателя
    private String PowCap = "POWCap";//Возможности переключения по совпадению фазы
    private String MaxOpCap = "MaxOpCap";//Функциональные характеристики выключателя при полной нагрузке
    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;

    public void receiveFromPTRC(boolean[] data){
//        System.out.println("receiveFromPTRC LNXCBR " + Arrays.toString(data));
        for (int i = 0; i < 3; i ++){
            if (data[i]){
                OpCnt++;
                if(OpCnt == 1){
                    System.out.println(BlkCls);
                }
            }else{
                OpCnt++;
                if (OpCnt ==1){
                    System.out.println(BlkOpn);
                }
            }
        }
        if (data[3]){
            OpCnt++;
            if (OpCnt == 1){
                System.out.println(BlkOpn);
            }
        }
    }
}
