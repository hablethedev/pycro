package hazel.pycro.config;

import hazel.pycro.PythonInterpreter;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = "pycro")
@Config(name = "pycro", wrapperName = "PycroConfig")
public class PycroConfigModel {
    public PythonInterpreter interpreter = PythonInterpreter.PYPY;
}