package hazel.pycro.config;

import hazel.pycro.PythonInterpreter;
import io.wispforest.owo.config.annotation.Config;

@Config(name = "pycro", wrapperName = "PycroConfig")
public class PycroConfigModel {
    public PythonInterpreter interpreter = PythonInterpreter.PYPY;
}
