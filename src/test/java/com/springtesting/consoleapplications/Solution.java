package com.springtesting.consoleapplications;

import java.util.Scanner;
import java.util.Stack;


public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            String input=sc.next();
            Stack<Character> stack=new Stack<>();
            boolean unbalanced=false;
            for(int i=0;i<input.length();i++)
            {
                try
                {
                    switch (input.charAt(i))
                    {
                        case '{':
                            stack.push(input.charAt(i));
                            break;
                        case '(':
                            stack.push(input.charAt(i));
                            break;
                        case '[':
                            stack.push(input.charAt(i));
                            break;
                        case '}':
                            if (stack.pop() != '{')
                            {
                                unbalanced = true;
                            }
                            break;
                        case ']':
                            if (stack.pop() != '[')
                            {
                                unbalanced = true;
                            }
                            break;
                        case ')':
                            if (stack.pop() != '(')
                            {
                                unbalanced = true;
                            }
                            break;
                    }
                    if (unbalanced)
                        break;
                }
                catch (Exception e)
                {
                    unbalanced=true;
                }
            }//End of for loop

            if(stack.empty()&& !unbalanced)
                System.out.println(true);
            else
                System.out.println(false);
        }

    }
}

