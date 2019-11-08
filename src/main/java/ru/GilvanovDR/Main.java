/*
 * Gilvanov DR 2019.
 */

package ru.GilvanovDR;

import fi.iki.elonen.NanoHTTPD;

//https://jgalacambra.wordpress.com/2016/06/08/writing-a-file-using-thymeleaf/
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new NanoServer(80).start(NanoHTTPD.SOCKET_READ_TIMEOUT,false);
    }
}
