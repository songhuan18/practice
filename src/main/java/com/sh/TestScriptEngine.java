package com.sh;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试数学公式表达式
 */
public class TestScriptEngine {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String exp = "1 < 3";
        String exp1 = "2 * 4 + 10";
        System.out.println(engine.eval(exp));
        System.out.println(engine.eval(exp1));
    }
}
