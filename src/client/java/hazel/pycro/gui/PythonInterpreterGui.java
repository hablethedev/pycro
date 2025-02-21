package hazel.pycro.gui;

import hazel.pycro.PythonInterpreter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

// TODO: save this, make it appear on first run, and make it actually do something

public class PythonInterpreterGui extends Screen {
    private PythonInterpreter selectedInterpreter = PythonInterpreter.PYPY; // todo: actually make this do stuff

    public PythonInterpreterGui() {
        super(Text.of("Select Python Interpreter"));
    }

    @Override
    protected void init() {
        int x = width / 2 - 100;
        int y = height / 2 - 50;

        ButtonWidget pypyButton = ButtonWidget.builder(Text.of("PyPy (recommended)"), button -> selectedInterpreter = PythonInterpreter.PYPY).dimensions(x, y, 200, 20).build();
        addDrawableChild(pypyButton);

        ButtonWidget pathButton = ButtonWidget.builder(Text.of("CPython (python.org)"), button -> selectedInterpreter = PythonInterpreter.CPYTHON).dimensions(x, y + 30, 200, 20).build();
        addDrawableChild(pathButton);

        ButtonWidget doneButton = ButtonWidget.builder(Text.of("Done"), button -> MinecraftClient.getInstance().setScreen(null)).dimensions(x, y + 80, 200, 20).build();
        addDrawableChild(doneButton);
    }
}
