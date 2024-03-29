package com.marchuk0.lab4.io.utils;

import com.marchuk0.lab4.dfa.DFA;
import com.marchuk0.lab4.dfa.DFAUtil;
import com.marchuk0.lab4.io.CodeFile;
import com.marchuk0.lab4.io.LexFile;
import com.marchuk0.lab4.nfa.IntegratedNFA;

public class App {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Need two arguments - InputFile OutputFile");
                return;
            }
            LexFile lexFile = new LexFile(args[0]);
            IntegratedNFA nfa = new IntegratedNFA(lexFile.regExps);
            DFA dfa = new DFA(nfa);
            dfa = DFAUtil.minimizeDFA(dfa);
            CodeFile codeFile = new CodeFile(lexFile, dfa);
            codeFile.writeFile(args[1]);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
