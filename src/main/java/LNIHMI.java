import scl.TDAI;
import scl.TDOI;
import scl.TLDevice;
import scl.TLN;

import java.io.IOException;
import java.util.*;

public class LNIHMI {

    private Map<String, CallBack> forCallBack;
    private Map<String, String> addrLN;
    private double[] SetZ = new double[4];
    private List<String> list1 = new ArrayList<>();

    public void for_tripPoints() throws IOException {
        TLDevice tlDevice = WorkWithCfgs.unMarshalAny(TLDevice.class, "PDIS.cid");
        for (TLN tln : tlDevice.getLN()) {
            for (TDOI tdoi : tln.getDOI()) {
                for (TDAI tdai : tdoi.getSDIOrDAI()) {
                    if(tdai.getVal() != null){
                        list1.add(tdai.getVal());

                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            SetZ[i] = Double.parseDouble(list1.get(i));
        }
        sendData(SetZ,forCallBack.get(addrLN.get("LNPDIS")));
    }

    private void sendData(double[] data, CallBack forCallBack) {
        forCallBack.call(data);
    }

    public void setForCallBack(Map<String, CallBack> forCallBack, Map<String, String> addrLN) {
        this.forCallBack = forCallBack;
        this.addrLN = addrLN;
    }
}


