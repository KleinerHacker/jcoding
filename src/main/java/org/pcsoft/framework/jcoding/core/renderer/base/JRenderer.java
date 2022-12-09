package org.pcsoft.framework.jcoding.core.renderer.base;

import org.apache.commons.io.IOUtils;
import org.pcsoft.framework.jcoding.core.data.base.JData;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class JRenderer<T extends JData> {
    protected abstract String doRender(T data);

    public final String renderToString(T data) {
        return doRender(data);
    }

    public final void render(T data, OutputStream out) throws IOException {
        final var code = doRender(data);
        IOUtils.write(code, out, StandardCharsets.UTF_8);
    }

    public final void render(T data, Writer writer) throws IOException {
        final var code = doRender(data);
        IOUtils.write(code, writer);
    }

    public final void render(T data, File file) throws IOException {
        try (final var out = new FileOutputStream(file)) {
            render(data, out);
        }
    }
}
