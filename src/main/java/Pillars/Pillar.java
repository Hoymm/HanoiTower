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

    public boolean addRoller(Roller roller) {
        if (rollerStack.empty()){
            rollerStack.push(roller);
        }
        return true;
        //else if (rollerStack.peek().compareTo(roller))
    }
}
