package Pillars;

import RollerStackGenerator.Roller;

import java.util.Stack;

public class Pillar {
    private Stack<Roller> rollerStack;

    public Pillar(Stack<Roller> rollerStack) {
        this.rollerStack = rollerStack;
    }

    public Pillar(){
        this.rollerStack = new Stack<Roller>();
    }
}
