package com.Lab_5.ClientProject.Client;

import com.Lab_5.ClientProject.HumanBeing.HumanBeing;

import java.io.Serializable;
import java.util.LinkedList;

public class MyCommand implements Serializable {
    private String commandName = null;
    private Long id = -1L;
    private LinkedList<String> args = new LinkedList<>();
    private HumanBeing transfer = null;

    public MyCommand(String commandName, Long id, LinkedList<String> args, HumanBeing human) {
        this.commandName = commandName;
        this.id = id;
        this.args = args;
        this.transfer = human;
    }

    public MyCommand(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public LinkedList<String> getArgs() {
        return args;
    }

    public void setArgs(LinkedList<String> args) {
        this.args = args;
    }

    public HumanBeing getTransfer() {
        return transfer;
    }

    public void setTransfer(HumanBeing transfer) {
        this.transfer = transfer;
    }

    @Override
    public String toString() {
        return "MyCommand{" +
                "commandName='" + commandName + '\'' +
                ", id=" + id +
                ", args=" + args +
                ", transfer=" + transfer +
                '}';
    }
}
