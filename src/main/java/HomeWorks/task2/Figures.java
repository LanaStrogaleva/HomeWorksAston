package HomeWorks.task2;

abstract class Figures {
    public String backgroundColor;
    public String borderColor;

    public Figures(String backgroundColor,String borderColor) {

        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public String commonInfo() {
        return  ", цвет фона: " + backgroundColor + ", цвет границ: " + borderColor;
    }

}
