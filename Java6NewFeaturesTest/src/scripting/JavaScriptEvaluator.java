package scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptEvaluator {
	public static void main(String[] args) {
		evaluateSimpleScript();
		evaluateUsingArrays();
	}

	public static void evaluateUsingArrays() {
		// Create the script engine manager
		ScriptEngineManager semFactory = new ScriptEngineManager();
		// Okay. We need a js engine
		ScriptEngine jsEngine = semFactory.getEngineByName("JavaScript");

		jsEngine.put("x", new Integer(20));
		jsEngine.put("arr", new Integer[] { 1, 2, 3, 4, 5 });

		try {
			jsEngine.eval("println(x); println(arr[2])");
		} catch (ScriptException e) {
			e.printStackTrace();
		}

	}

	public static void evaluateSimpleScript() {
		// Create the script engine manager
		ScriptEngineManager semFactory = new ScriptEngineManager();
		// Okay. We need a js engine
		ScriptEngine jsEngine = semFactory.getEngineByName("JavaScript");

		// Instantiate a String with the script
		String jsScript = " var a = 1; a += 15; println(a) ";

		// Evaluate the javascript expression
		try {
			jsEngine.eval(jsScript);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
