package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JNamedData;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JFileData extends JNamedData {
    private JPackageData packageData;
    private final List<JTypeData> types = new ArrayList<>();

    public JFileData(String name, JPackageData packageData, JTypeData[] types) {
        super(name);
        this.packageData = packageData;
        this.types.addAll(Arrays.asList(types));
    }
}
