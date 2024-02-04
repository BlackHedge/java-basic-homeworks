package ru.chernov.java.basic.homeworks.homework4;

/**
 * Params of Box-objects
 * literalSize - S, M, L, XXL
 * statusOpened: closed is false; opened is true. Initial status is closed (false)
 * content - max 1 item; "" if empty
 */
public class Box {
    private String literalSize;
    private String color;
    private boolean statusOpened;
    private String content;

    public Box(String literalSize, String color) {
        this.literalSize = literalSize;
        this.color = color;
        this.statusOpened = false;
        this.content = "";
    }

    public String getLiteralSize() {
        return literalSize;
    }

    public String getColor() {
        return color;
    }

    public boolean isStatusOpened() {
        if(statusOpened) {
            System.out.println("The box is opened");
        } else {
            System.out.println("The box is closed");
        }
        return statusOpened;
    }

    public String getContent() {
        if(content.isEmpty()) {
            System.out.println("The box is empty");
        } else {
            System.out.println("The box contains \"" + content + "\"");
        }
        return content;
    }

    public void open() {
        if(statusOpened) {
            System.out.println("The box is already opened");
        } else {
            statusOpened = true;
            System.out.println("Now the box is opened");
        }
    }

    public void close() {
        if(!statusOpened) {
            System.out.println("The box is already closed");
        } else {
            this.statusOpened = false;
            System.out.println("Now the box is closed");
        }
    }

    public void repaint(String color) {
        this.color = color;
        System.out.println("The box color have changed on " + color);
    }

    public void fullInfoBox() {
        System.out.println("*   -Info about box-   *");
        System.out.println("Size: " + getLiteralSize());
        System.out.println("Color: " + getColor());
        isStatusOpened();
        getContent();
        System.out.println("---------------");
    }

    public void putItem(String item) {
        if(statusOpened && content.isEmpty()) {
            content = item;
            System.out.println("\"" + item + "\" add in the box");
        }
        if(!statusOpened) {
            System.out.println("The box is closed. To put an item open the box");
        }
        if(!content.isEmpty()) {
            System.out.println("The item \"" + content + "\" in the box. Please remove it before put a new.");
        }
    }

    public void removeItem(String item) {
        if(statusOpened && content.equals(item)) {
            content = "";
            System.out.println("The box is empty. \"" + item + "\" was removed.");
        }
        if(!statusOpened) {
            System.out.println("The box is closed. To remove an item open the box");
        }
        if(content.isEmpty()) {
            System.out.println("No items to remove");
        }
        if(!content.equals(item)) {
            System.out.println("No such item in box");
        }
    }

}
