package eu.uvarov.cv;


import com.github.mustachejava.DeferringMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) throws IOException {
        String s = FileUtils.readFileToString(new File(args[0]));
        Gson gson = new Gson();
        Cv cv = gson.fromJson(s, Cv.class);

        DeferringMustacheFactory mf = new DeferringMustacheFactory();
        mf.setExecutorService(Executors.newCachedThreadPool());

        Mustache m = mf.compile(args[1]);
        PrintWriter pw = new PrintWriter(new FileOutputStream(args[2]));
        m.execute(pw, cv).close();

        m = mf.compile(args[3]);
        pw = new PrintWriter(new FileOutputStream(args[4]));
        m.execute(pw, cv).close();
    }
}
