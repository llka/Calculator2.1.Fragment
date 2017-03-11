package ru.ilka.calculator21fragment;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Fragment_Hard extends Fragment implements View.OnClickListener {

    Button btnHelp, btnLbracket, btnRbracket, btnPercent;
    Button btn1divx, btnKvadrat, btnKub, btnSettings;
    Button btnFactorial, btnSqrt, btnLn, btnExp;
    Button btnSin, btnCos, btnTg, btn2inx;
    Button btnSinH, btnCosH,btnTgH, btnPi;

    String zd = "#0.000";
    String input = "";
    double n1 = 0, n2 = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frament_simple, null);

        btnHelp= (Button) v.findViewById(R.id.btnHelp);
        btnLbracket = (Button) v.findViewById(R.id.btnLbracket);//
        btnRbracket = (Button) v.findViewById(R.id.btnRbracket);//
        btnPercent = (Button) v.findViewById(R.id.btnPercent);
        btn1divx = (Button) v.findViewById(R.id.btn1divx);
        btnKvadrat = (Button) v.findViewById(R.id.btnKvadrat);
        btnKub = (Button) v.findViewById(R.id.btnKub);
        btnSettings = (Button) v.findViewById(R.id.btnSettings);
        btnFactorial = (Button) v.findViewById(R.id.btnFatorial);
        btnSqrt = (Button) v.findViewById(R.id.btnSqrt);
        btnLn = (Button) v.findViewById(R.id.btnLN);
        btnExp = (Button) v.findViewById(R.id.btnExp);
        btnSin = (Button) v.findViewById(R.id.btnSin);
        btnCos = (Button) v.findViewById(R.id.btnCos);
        btnTg = (Button) v.findViewById(R.id.btnTg);
        btn2inx = (Button) v.findViewById(R.id.btn2inX);
        btnSinH = (Button) v.findViewById(R.id.btnSinH);
        btnCosH = (Button) v.findViewById(R.id.btnCosH);
        btnTgH = (Button) v.findViewById(R.id.btnTgH);
        btnPi = (Button) v.findViewById(R.id.btnPi);//

        btnLbracket.setOnClickListener(this);
        btnRbracket.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btn1divx.setOnClickListener(this);
        btnKvadrat.setOnClickListener(this);
        btnKub.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnExp.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTg.setOnClickListener(this);
        btn2inx.setOnClickListener(this);
        btnSinH.setOnClickListener(this);
        btnCosH.setOnClickListener(this);
        btnTgH.setOnClickListener(this);
        btnPi.setOnClickListener(this);
        btnHelp.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.btnHelp:
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("ru.ilka.help","ru.ilka.help.MainActivityHelp"));
                startActivity(intent);
                break;
            case R.id.btnLbracket:
                input += "(";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnRbracket:
                input += ")";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnPi:
                input += "3.1416";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnPercent:
                input = Double.parseDouble(input)/100 + "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn1divx:
                String r = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                input = 1/Double.parseDouble(input) + "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnKvadrat:
                String p = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                input = Double.parseDouble(input)*Double.parseDouble(input) + "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnKub:
                String rp2 = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                input = Double.parseDouble(input)*Double.parseDouble(input)*Double.parseDouble(input) + "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnSettings:
                //Intent intentik = new Intent(this, ActivityTwo.class);
                //startActivityForResult(intentik, 1);
                break;
            case R.id.btnFatorial:
                String rp = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(factorial(Double.parseDouble(input)) + "");
                input = ((TextView) getActivity().findViewById(R.id.tvResult)).getText().toString();
                break;
            case R.id.btnSqrt:
                String rp3 = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double d = (Double.parseDouble(input));
                input = Math.sqrt(d)+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnLN:
                String rp4 = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double d1 = (Double.parseDouble(input));
                input = Math.log(d1)+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnExp:
                String rp5 = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double d2 = (Double.parseDouble(input));
                input = Math.exp(d2)+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnSin:
                String q = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtosin = (Double.parseDouble(input));
                input = Math.sin(Math.toRadians(xtosin))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnCos:
                String w = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtocos = (Double.parseDouble(input));
                input = Math.cos(Math.toRadians(xtocos))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnTg:
                String qq = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtg = (Double.parseDouble(input));
                input = Math.tan(Math.toRadians(xtg))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnSinH:
                String qww = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtosinh = (Double.parseDouble(input));
                input = Math.sinh(Math.toRadians(xtosinh))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnCosH:
                String ww = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtocosh = (Double.parseDouble(input));
                input = Math.cosh(Math.toRadians(xtocosh))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnTgH:
                String qqq = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double xtgh = (Double.parseDouble(input));
                input = Math.tanh(Math.toRadians(xtgh))+ "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn2inX:
                String lenin = sortingStation(input, MAIN_MATH_OPERATIONS);
                input = calculateExpression(input) + "";
                double x = (Double.parseDouble(input));
                input = Math.pow(2,x) + "";
                input = new DecimalFormat(zd).format(Double.parseDouble(input));
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
        }
    }
    public static final Map<String, Integer> MAIN_MATH_OPERATIONS;

    static {
        MAIN_MATH_OPERATIONS = new HashMap<String, Integer>();
        MAIN_MATH_OPERATIONS.put("*", 1);
        MAIN_MATH_OPERATIONS.put("/", 1);
        MAIN_MATH_OPERATIONS.put("+", 2);
        MAIN_MATH_OPERATIONS.put("-", 2);
    }

    public static String sortingStation(String expression, Map<String, Integer> operations, String leftBracket,
                                        String rightBracket) {
        if (expression == null || expression.length() == 0)
            throw new IllegalStateException("Expression isn't specified.");
        if (operations == null || operations.isEmpty())
            throw new IllegalStateException("Operations aren't specified.");
        // Выходная строка, разбитая на "символы" - операции и операнды..
        List<String> out = new ArrayList<String>();
        // Стек операций.
        Stack<String> stack = new Stack<String>();

        // Удаление пробелов из выражения.
        expression = expression.replace(" ", "");

        // Множество "символов", не являющихся операндами (операции и скобки).
        Set<String> operationSymbols = new HashSet<String>(operations.keySet());
        operationSymbols.add(leftBracket);
        operationSymbols.add(rightBracket);

        // Индекс, на котором закончился разбор строки на прошлой итерации.
        int index = 0;
        // Признак необходимости поиска следующего элемента.
        boolean findNext = true;
        while (findNext) {
            int nextOperationIndex = expression.length();
            String nextOperation = "";
            // Поиск следующего оператора или скобки.
            for (String operation : operationSymbols) {
                int i = expression.indexOf(operation, index);
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation;
                    nextOperationIndex = i;
                }
            }
            // Оператор не найден.
            if (nextOperationIndex == expression.length()) {
                findNext = false;
            } else {
                // Если оператору или скобке предшествует операнд, добавляем его в выходную строку.
                if (index != nextOperationIndex) {
                    out.add(expression.substring(index, nextOperationIndex));
                }
                // Обработка операторов и скобок.
                // Открывающая скобка.
                if (nextOperation.equals(leftBracket)) {
                    stack.push(nextOperation);
                }
                // Закрывающая скобка.
                else if (nextOperation.equals(rightBracket)) {
                    while (!stack.peek().equals(leftBracket)) {
                        out.add(stack.pop());
                        if (stack.empty()) {
                            throw new IllegalArgumentException("Unmatched brackets");
                        }
                    }
                    stack.pop();
                }
                // Операция.
                else {
                    while (!stack.empty() && !stack.peek().equals(leftBracket) &&
                            (operations.get(nextOperation) >= operations.get(stack.peek()))) {
                        out.add(stack.pop());
                    }
                    stack.push(nextOperation);
                }
                index = nextOperationIndex + nextOperation.length();
            }
        }
        // Добавление в выходную строку операндов после последнего операнда.
        if (index != expression.length()) {
            out.add(expression.substring(index));
        }
        // Пробразование выходного списка к выходной строке.
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        StringBuffer result = new StringBuffer();
        if (!out.isEmpty())
            result.append(out.remove(0));
        while (!out.isEmpty())
            result.append(" ").append(out.remove(0));

        return result.toString();
    }

    public static String sortingStation(String expression, Map<String, Integer> operations) {
        return sortingStation(expression, operations, "(", ")");
    }

    public static BigDecimal calculateExpression(String expression) {
        String rpn = sortingStation(expression, MAIN_MATH_OPERATIONS);
        StringTokenizer tokenizer = new StringTokenizer(rpn, " ");
        Stack<BigDecimal> stack = new Stack<BigDecimal>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // Операнд.
            if (!MAIN_MATH_OPERATIONS.keySet().contains(token)) {
                stack.push(new BigDecimal(token));
            } else {
                BigDecimal operand2 = stack.pop();
                BigDecimal operand1 = stack.empty() ? BigDecimal.ZERO : stack.pop();
                if (token.equals("*")) {
                    stack.push(operand1.multiply(operand2));
                } else if (token.equals("/")) {
                    BigDecimal bg1 = new BigDecimal(0);
                    bg1 = operand1.divide(operand2,3, BigDecimal.ROUND_CEILING);
                    stack.push(bg1);
                } else if (token.equals("+")) {
                    stack.push(operand1.add(operand2));
                } else if (token.equals("-")) {
                    stack.push(operand1.subtract(operand2));
                }
            }
        }
        if (stack.size() != 1)
            throw new IllegalArgumentException("Expression syntax error.");
        return stack.pop();
    }

    public static double factorial(double n)
    {
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

}


