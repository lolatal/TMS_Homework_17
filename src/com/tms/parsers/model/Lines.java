package com.tms.parsers.model;

public class Lines {

    String line;

    public Lines(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line + "\n";
    }
}
