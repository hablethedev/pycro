package hazel.pycro.gui;

import hazel.pycro.PythonInterpreter;
import io.wispforest.owo.config.*;
import io.wispforest.owo.config.OwoConfigCommand;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.io.ObjectInputFilter;

import static hazel.pycro.Pycro.CONFIG;

public class PythonInterpreterGui extends Screen {
    public PythonInterpreterGui() {
        super(Text.of("Select Python Interpreter"));
    }

    @Override
    protected void init() {
        int x = width / 2 - 100;
        int y = height / 2 - 50;

        ButtonWidget pypyButton = ButtonWidget.builder(
                Text.of("PyPy (recommended)"),
                button -> {
                    // set config value Interpreter to PythonInterpreter.PYPY
                }
        ).dimensions(x, y, 200, 20).build();
        addDrawableChild(pypyButton);

        ButtonWidget cpythonButton = ButtonWidget.builder(
                Text.of("CPython (python.org)"),
                button -> {
                    // set config value Interpreter to PythonInterpreter.PYPY
                }
        ).dimensions(x, y + 30, 200, 20).build();
        addDrawableChild(cpythonButton);

        ButtonWidget doneButton = ButtonWidget.builder(
                Text.of("Done"),
                button -> MinecraftClient.getInstance().setScreen(null)
        ).dimensions(x, y + 80, 200, 20).build();
        addDrawableChild(doneButton);
    }
}
