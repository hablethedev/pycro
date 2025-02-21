package hazel.pycro.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

// TODO: save this, make it appear on first run, and make it actually do something

public class PythonInterpreterGui extends Screen {

    private TextFieldWidget customPathField;
    private String selectedInterpreter = "PyPy"; // todo: actually make this do stuff

    public PythonInterpreterGui() {
        super(Text.of("Select Python Interpreter"));
    }

    @Override
    protected void init() {
        int x = width / 2 - 100;
        int y = height / 2 - 50;

        ButtonWidget pypyButton = ButtonWidget.builder(Text.of("PyPy (recommended)"), button -> {
            selectedInterpreter = "PyPy";
        }).dimensions(x, y, 200, 20).build();
        addDrawableChild(pypyButton);

        ButtonWidget pathButton = ButtonWidget.builder(Text.of("PATH Python"), button -> {
            selectedInterpreter = "PATH";
        }).dimensions(x, y + 30, 200, 20).build();
        addDrawableChild(pathButton);

        ButtonWidget customButton = ButtonWidget.builder(Text.of("Custom"), button -> {
            selectedInterpreter = "Custom";
        }).dimensions(x, y + 60, 200, 20).build();
        addDrawableChild(customButton);

        customPathField = new TextFieldWidget(textRenderer, x, y + 90, 200, 20, Text.of("Enter path")); //idk why
        customPathField.setVisible(false);
        addDrawableChild(customPathField);

        ButtonWidget doneButton = ButtonWidget.builder(Text.of("Done"), button -> {
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(x, y + 120, 200, 20).build();
        addDrawableChild(doneButton);
    }

    @Override
    public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void tick() {
        super.tick();

        customPathField.setVisible(selectedInterpreter.equals("Custom"));
    }
}
