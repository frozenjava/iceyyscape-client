public class Hack {
    public static void setInterfaceConfig(int interfaceId, int childId, boolean set) {
        int interfaceConfig = interfaceId << 16 | childId;
        Class45 class45 = Class68_Sub20_Sub15.method1170(interfaceConfig, (byte) -80);
        if (class45.aBoolean764 == !set) {
            class45.aBoolean764 = set;
            Class113.method1682(class45, -120);
        }
    }
}