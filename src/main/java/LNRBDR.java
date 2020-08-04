import java.util.Arrays;

public class LNRBDR {

    private int OpCntRs = 0;
    private String ChTrg = "ChTrg";//Канал запущен
    private int ChNum;//Номер канала
    private String TrgMod = "TrgMod";//Режим пуска (внутренний триггер, внешний триггер или тот и другой)
    private String LevMod = "LevMod";//Режим уровня триггера / пуска
    private String HiTrgLev = "HiTrgLev";//Высокий (положительный) уровень триггера
    private String LoTrgLev = "LoTrgLev";//Низкий (отрицательный) уровень триггера
    private long PreTmms = System.currentTimeMillis();//Время до пуска
    private long PstTmms;//Время после пуска

    public void receiveFromPDIS(boolean[] data){
//        System.out.println("receiveFromPDIS " + Arrays.toString(data));
        OpCntRs++;
        if (OpCntRs == 1){
            System.out.println("PreTmms " + PreTmms);
            PstTmms = System.currentTimeMillis();
            System.out.println("PstTmms " + PstTmms);
            System.out.println(TrgMod);
        }
        for (ChNum = 0;ChNum < 4; ChNum++){
            if (OpCntRs == 1) {
                System.out.println(ChTrg + ChNum);
            }
            Charts.addDiscretData(ChNum,data[ChNum]);
        }

    }
}
