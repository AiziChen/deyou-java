package com.cozz.deyou;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.DvmClass;
import com.github.unidbg.linux.android.dvm.DvmObject;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.memory.Memory;

import java.io.File;

public class NativeDecrypt {
    private static final String KEYENCRY_LIB_PATH = ClassLoader.getSystemClassLoader().getResource("libkeyencry.so").getPath();
    private static final AndroidEmulator emulator = AndroidEmulatorBuilder
            .for64Bit()
            .setProcessName("com.dongyu.yuliao")
            .build();
    private static VM virtualMachine;

    private static VM initVM(boolean verbose) {
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        VM vm = emulator.createDalvikVM();
        vm.setVerbose(verbose);
        DalvikModule dm = vm.loadLibrary(new File(KEYENCRY_LIB_PATH), true);
        dm.callJNI_OnLoad(emulator);
        return vm;
    }

    private static VM getVMInstance() {
        if (virtualMachine == null) {
            virtualMachine = initVM(false);
        }
        return virtualMachine;
    }

    public static String decrypt(String midDecToken) {
        DvmClass dvmClass = getVMInstance().resolveClass("com/tangran/diaodiao/utils/NativeMethod");
        dvmClass.callStaticJniMethodObject(emulator, "keyAlgorithm(Ljava/lang/String;)Ljava/lang/String;", "6tnym1br6fib7");
        DvmObject<String> sign = dvmClass.callStaticJniMethodObject(emulator, "tokenDecry(Ljava/lang/String;)Ljava/lang/String;", midDecToken);
        return sign.getValue();
    }
}
