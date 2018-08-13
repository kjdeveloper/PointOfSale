package outputdevices;

import java.util.HashMap;
import java.util.Map;

public class OutputDeviceFactory {

    private static final Map<DeviceType, OutputDevice> MAP = new HashMap<DeviceType, OutputDevice>();

    static{
        MAP.put(DeviceType.LCD, new Lcd());
        MAP.put(DeviceType.PRINTER, new Printer());
    }

    public OutputDevice create(DeviceType type){ return MAP.get(type);}
}
