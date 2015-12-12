package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JMethodBodyBuilder extends JObjectBuilderBase<JMethodBodyDescriptor> {
    public static JMethodBodyBuilder create() {
        return new JMethodBodyBuilder();
    }

    private JMethodBodyBuilder() {
        super(JMethodBodyDescriptor.class);
    }
}
