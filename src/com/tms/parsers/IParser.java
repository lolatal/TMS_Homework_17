package com.tms.parsers;

import com.tms.parsers.model.Lines;
import java.util.List;

public interface IParser {
    List<Lines> process(String file);
}
