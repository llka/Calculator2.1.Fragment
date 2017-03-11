package ru.ilka.calculator21fragment;

import android.app.Fragment;
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

public class Fragment_Simple extends Fragment implements View.OnClickListener {

    Button btnClear;
    Button btnBacks;
    Button btnDiv;
    Button btnMul;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnMinus;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnPlus;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnResult;
    Button btn0;
    Button btnComma;

    String zd = "#0.000";
    String input = "";
    double n1 = 0, n2 = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frament_simple, null);

        btnClear = (Button) v.findViewById(R.id.btnClear);
        btnBacks = (Button) v.findViewById(R.id.btnBacks);
        btnDiv = (Button) v.findViewById(R.id.btnDiv);
        btnMul = (Button) v.findViewById(R.id.btnMul);
        btn1 = (Button) v.findViewById(R.id.btn1);
        btn2 = (Button) v.findViewById(R.id.btn2);
        btn3 = (Button) v.findViewById(R.id.btn3);
        btn4 = (Button) v.findViewById(R.id.btn4);
        btn5 = (Button) v.findViewById(R.id.btn5);
        btn6 = (Button) v.findViewById(R.id.btn6);
        btn7 = (Button) v.findViewById(R.id.btn7);
        btn8 = (Button) v.findViewById(R.id.btn8);
        btn9 = (Button) v.findViewById(R.id.btn9);
        btn0 = (Button) v.findViewById(R.id.btn0);
        btnMinus = (Button) v.findViewById(R.id.btnMinus);
        btnPlus = (Button) v.findViewById(R.id.btnPlus);
        btnComma = (Button) v.findViewById(R.id.btnComma);
        btnResult = (Button) v.findViewById(R.id.btnResult);

        btnClear.setOnClickListener(this);
        btnBacks.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnComma.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.btnClear:
                input = "";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnBacks:
                input = input.substring(0,input.length()-1);
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnDiv:
                input += "/";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnMul:
                input += "*";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn1:
                input += "1";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn2:
                input += "2";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn3:
                input += "3";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn4:
                input += "4";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn5:
                input += "5";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn6:
                input += "6";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn7:
                input += "7";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn8:
                input += "8";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn9:
                input += "9";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btn0:
                input += "0";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnMinus:
                input += "-";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnPlus:
                input += "+";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnComma:
                input += ".";
                ((TextView) getActivity().findViewById(R.id.tvResult)).setText(input);
                break;
            case R.id.btnResult:
                String rpn = sortingStation(input, MAIN_MATH_OPERATIONS);

                input = calculateExpression(input) + "";

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

