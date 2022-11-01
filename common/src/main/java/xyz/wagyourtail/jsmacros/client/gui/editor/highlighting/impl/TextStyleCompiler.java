package xyz.wagyourtail.jsmacros.client.gui.editor.highlighting.impl;

import io.noties.prism4j.AbsVisitor;
import io.noties.prism4j.Prism4j;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public abstract class TextStyleCompiler extends AbsVisitor {
    protected final Style defaultStyle;
    protected final Map<String, short[]> themeData;
    protected final List<LiteralText> result = new LinkedList<>();

    public static BiFunction<Style, Map<String, short[]>, TextStyleCompiler> getTextStyleCompiler;
    
    public TextStyleCompiler(Style defaultStyle, Map<String, short[]> themeData) {
        this.defaultStyle = defaultStyle;
        this.themeData = themeData;
        result.add((LiteralText) new LiteralText("").setStyle(defaultStyle.copy()));
    }
    
    @Override
    protected void visitText(@NotNull Prism4j.Text text) {
        String[] lines = text.literal().replaceAll("\t", "    ").split("\r\n|\n", -1);
        int i = 0;
        while (i < lines.length) {
            result.get(result.size() - 1).append(new LiteralText(lines[i]).setStyle(defaultStyle.copy()));
            if (++i < lines.length) result.add((LiteralText) new LiteralText("").setStyle(defaultStyle.copy()));
        }
    }
    
    protected void appendChildResult(List<LiteralText> childResult) {
        LiteralText first = childResult.remove(0);
        result.get(result.size() - 1).append(first);
        result.addAll(childResult);
    }
    
    protected Optional<Integer> colorForSyntax(String name, String alias) {
        Optional<Integer> val = getColorForToken(name);
        if (val.isPresent()) return val;
        else val = getColorForToken(alias);
        return val;
    }
    
    public List<LiteralText> getResult() {
        return result;
    }
    
    protected Optional<Integer> getColorForToken(@Nullable String name) {
        if (!themeData.containsKey(name)) return Optional.empty();
        short[] color = themeData.get(name);
        return Optional.of((color[0] & 255) << 16 | (color[1] & 255) << 8 | (color[2] & 255));
    }
}
