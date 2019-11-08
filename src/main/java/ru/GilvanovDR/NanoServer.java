/*
 * Gilvanov DR 2019.
 */

package ru.GilvanovDR;


import fi.iki.elonen.NanoHTTPD;
import org.thymeleaf.context.Context;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class NanoServer extends NanoHTTPD {
    NanoServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Context context = new Context();
        context.setVariable("title", "TEst Page");
        context.setVariable("name", "VAsI");
        String uri = "/".equals(session.getUri()) ? "/index.html" : session.getUri();
        System.out.println("----" + ThymeLeafConfig.getTemplatePath() + uri);
        InputStream data = new ByteArrayInputStream(ThymeLeafConfig
                .getTemplateEngine()
                .process(uri, context).getBytes());
        return newChunkedResponse(Response.Status.OK,
                NanoHTTPD.getMimeTypeForFile(uri),
                data);
    }
}