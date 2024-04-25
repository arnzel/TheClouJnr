package main;

import base.Base;
import jnr.ffi.CallingConvention;
import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.mapper.FunctionMapper;

import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Base base = createBase();
        base.main(4,new String[]{"","-m0","-s0","-g4","-d1","f"});
        //base.main(4,null);
    }

    private static void runHelp(){
        Base base = createBase();
        String[]  argv = new String[2];
        argv[1] = "-h";
        base.main(2,argv);
    }

    private static Base createBase(){
        return LibraryLoader.create(Base.class)
                .option(LibraryOption.CallingConvention, CallingConvention.DEFAULT)
                .load("/Users/211897/IdeaProjects/TheClouJnr/src/main/java/main/base2.so");
    }
}