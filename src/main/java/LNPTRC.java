import java.util.Arrays;
import java.util.Map;

public class LNPTRC {

    private int OpCntRs = 0;
    private String Tr = "Tr";//Отключение
    private String Op = "Op";//Срабатывание (сочетание сигналов срабатывания, получаемых по подписке «Ор» — от функций защиты)
    private String Str = "Str";//Сумма всех пусков всех подключенных логических узлов
    private String TrMod = "TrMod";//Режим отключения
    private long TrPlsTmms;//Длительность импульса отключения
    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;

    public void receiveFromPDIS(boolean[] data){
//        System.out.println("receiveFromPDIS LNPTRC " + Arrays.toString(data));
        for(int i = 0; i < 3; i++){
            if (data[i]){
                OpCntRs++;
                if (OpCntRs == 1){
                    System.out.println(Tr);
                    System.out.println(TrMod);
                }
                sendData(data,forCallBack.get(addrLN.get("LNXCBR")));
            }
        }
    }

    private void sendData(boolean[] data, CallBack forCallBack) {
        forCallBack.bool(data);
    }

    public void setForCallBack(Map<String, CallBack> forCallBack, Map<String, String> addrLN) {
        this.forCallBack = forCallBack;
        this.addrLN = addrLN;
    }
}
